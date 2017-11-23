package tests;

import animals.*;
import start.Paddock;
import start.Report;

import java.util.Scanner;

public class Test {

    private static Paddock initTest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello in Zoo");
        System.out.println("Please enter name your paddock");
        Paddock p=new Paddock();
        p.setName(""+sc.next());
        System.out.println("Choose animal for add in you paddock");
        EnumAnimals[] eArray=EnumAnimals.values();
        for(int i=0;i<eArray.length;i++){
            System.out.println(""+(i+1)+": "+eArray[i]);
        }
        int n=sc.nextInt();
        switch (n){
            case 1: p.setAnimal(new Elephant()); break;
            case 2: p.setAnimal(new Tiger()); break;
            case 3: p.setAnimal(new Crocodile()); break;
            case 4: p.setAnimal(new Parrot()); break;
            case 5: p.setAnimal(new Wolf()); break;
        }

        return p;
    }
    public static void test(){
        Report.getReportOnePaddock(initTest());
    }
}
