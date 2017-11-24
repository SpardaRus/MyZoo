package tests;

import animals.*;
import needs.foods.*;
import start.Administrator;
import start.Paddock;
import start.Report;
import start.Visitors;

import java.util.Scanner;

public class Test {
    public static Paddock initTest1(){
        Paddock p=new Paddock();
        p.setName("MyZoo");
        p.setAnimal(new Elephant());
        p.setAnimal(new Elephant());
        p.setAnimal(new Elephant());
        p.calcNeed();
        Elephant.calcVisitors();
        return p;
    }
    public static Paddock initTest2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name your paddock");
        Paddock p=new Paddock();
        p.setName(""+sc.next());
        EnumAnimals[] eArray=EnumAnimals.values();
        boolean v=true;
        int n=0;
        while(v){
            System.out.println("Choose animal for add in you paddock");
            for(int i=0;i<eArray.length;i++){
                System.out.println(""+(i+1)+": "+eArray[i]);
            }
            switch (sc.nextInt()){
                case 1: p.setAnimal(new Elephant()); n=1; v=false; break;
                case 2: p.setAnimal(new Tiger()); n=2; v=false; break;
                case 3: p.setAnimal(new Crocodile());n=3; v=false; break;
                case 4: p.setAnimal(new Parrot()); n=4; v=false; break;
                case 5: p.setAnimal(new Wolf()); n=5; v=false; break;
            }
        }
        v=true;
        while(v){
            System.out.println("Add the "+p.getAnimal().get(0).getClass().getSimpleName()+" again?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            switch (sc.nextInt()) {
                case 1:
                    switch (n){
                        case 1: p.setAnimal(new Elephant()); break;
                        case 2: p.setAnimal(new Tiger()); break;
                        case 3: p.setAnimal(new Crocodile());break;
                        case 4: p.setAnimal(new Parrot()); break;
                        case 5: p.setAnimal(new Wolf()); break;
                    }
                    break;
                case 2: v=false; break;            }
        }
        p.calcNeed();
        return p;
    }
    public static void payAndEat(Paddock initTest, Foods f){
        int nf=0;
        int sut=0;
        int i=0;
        while(initTest.getNeedFood()>nf){
            while(initTest.getAnimal().get(i).getNeedFood()>sut){
                initTest.getAnimal().get(i).toEat(Administrator.payFood(f));
                sut+=f.getSaturation();
            }
            i++;
            nf+=sut;
            sut=0;
        }
    }
    public static void test(Paddock initTest){
        Scanner sc = new Scanner(System.in);
        EnumFoods[] eArray=EnumFoods.values();
        boolean v=true;
        while (v){
            System.out.println();
            Elephant.calcVisitors();
            Report.getReportOnePaddock(initTest);
            System.out.println("Need pay food, your choose is:");
            for(int i=0;i<eArray.length;i++){
                System.out.println(""+(i+1)+": "+eArray[i]);
            }
            System.out.println("4: End");
            switch (sc.nextInt()){
                case 1:
                    payAndEat(initTest, new BadFood());
                    break;
                case 2:
                    payAndEat(initTest, new NormalFood());
                    break;
                case 3:
                    payAndEat(initTest, new ExcellentFood());
                    break;
                case 4:
                    v=false; break;
            }
            Administrator.pay(-Visitors.pay()*initTest.getAnimal().size()*
                    initTest.getAnimal().get(0).getVisitors());

        }

    }
}
