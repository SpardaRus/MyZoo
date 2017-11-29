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
                System.out.print(""+(i+1)+": "+eArray[i]+",\t");
                if(i==1||i==3||i==4){
                    System.out.print("\t");
                }
                System.out.println("| cost: "+eArray[i].getAnimal().getCost()+"$");

            }
            switch (sc.nextInt()){
                case 1: n=1; p.setAnimal(Administrator.byAnimals(new Elephant())); v=false;  break;
                case 2: n=2; p.setAnimal(Administrator.byAnimals(new Tiger())); v=false;  break;
                case 3: n=3; p.setAnimal(Administrator.byAnimals(new Crocodile())); v=false;  break;
                case 4: n=4; p.setAnimal(Administrator.byAnimals(new Parrot())); v=false;  break;
                case 5: n=5; p.setAnimal(Administrator.byAnimals(new Wolf())); v=false;  break;
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
                case 2:
                    if(p.getAnimal().get(0)==null){
                        System.out.println("You must by animal");
                    }else{
                        v=false;
                    }
                    break;
            }
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
            Report.getReportOnePaddock(initTest);
            System.out.println("Need by food. Your choose is:");
            for(int i=0;i<eArray.length;i++){
                System.out.print(""+(i+1)+": "+eArray[i]);
                if(i==0||i==1){
                    System.out.print("\t");
                }
                if(i==0){
                    System.out.print("\t");
                }
                System.out.println("\t| cost: "+eArray[i].getFood().getCOST()+"$ "+
                                    "\t| feel: "+eArray[i].getFood().getFeel()+
                                    "\t| saturation: "+eArray[i].getFood().getSaturation());
            }
            System.out.println("4: End");
            switch (sc.nextInt()){
                case 1:
                    payAndEat(initTest, new BadFood());
                    Administrator.pay(-Visitors.pay()*initTest.getAnimal().size()*
                            initTest.getAnimal().get(0).getVisitors());
                    break;
                case 2:
                    payAndEat(initTest, new NormalFood());
                    Administrator.pay(-Visitors.pay()*initTest.getAnimal().size()*
                            initTest.getAnimal().get(0).getVisitors());
                    break;
                case 3:
                    payAndEat(initTest, new ExcellentFood());
                    Administrator.pay(-Visitors.pay()*initTest.getAnimal().size()*
                            initTest.getAnimal().get(0).getVisitors());
                    break;
                case 4:
                    v=false; break;
            }


        }

    }
}
