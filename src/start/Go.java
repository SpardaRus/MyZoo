package start;

import animals.*;
import needs.foods.*;

import java.util.Scanner;

public class Go {
    public static Paddock initPaddock(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name your paddock");
        Paddock p=new Paddock();
        p.setName(""+sc.next());
        EnumAnimals[] eArray=EnumAnimals.values();
        boolean v=true;
        int n=0;
        while(v){
            System.out.println("Choose animal for add in you paddock");
            System.out.println("You have "+Administrator.getMoney()+"$");
            for(int i=0;i<eArray.length;i++){
                System.out.println(""+(i+1)+": "+eArray[i]+
                        ", cost: "+eArray[i].getAnimal().getCost()+"$");
            }
            switch (sc.nextInt()){
                case 1: n=1; v=false; break;
                case 2: n=2; v=false; break;
                case 3: n=3; v=false; break;
                case 4: n=4; v=false; break;
                case 5: n=5; v=false; break;
            }
        }
        v=true;
        while(v){
            System.out.println("You have "+Administrator.getMoney()+"$");
            System.out.println("Add the "+eArray[n-1]+
                    "?. Cost: "+eArray[n-1].getAnimal().getCost()+"$");
            System.out.println("1: Yes");
            System.out.println("2: No");
            switch (sc.nextInt()) {
                case 1:
                    switch (n){
                        case 1: p.setAnimal(Administrator.byAnimals(new Elephant()));  break;
                        case 2: p.setAnimal(Administrator.byAnimals(new Tiger())); break;
                        case 3: p.setAnimal(Administrator.byAnimals(new Crocodile()));break;
                        case 4: p.setAnimal(Administrator.byAnimals(new Parrot())); break;
                        case 5: p.setAnimal(Administrator.byAnimals(new Wolf())); break;
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
                initTest.getAnimal().get(i).toEat(Administrator.byFood(f));
                sut+=f.getSaturation();
            }
            i++;
            nf+=sut;
            sut=0;
        }
    }
    public static void start(Paddock initTest){
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
