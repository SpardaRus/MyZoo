package tests;

import animals.*;
import paddock.Paddock;

public class Test {
    public static Paddock initTest1(){
        Paddock p=new Paddock();
        p.setName("MyZoo");
        p.setAnimal(new Elephant());
        p.setAnimal(new Elephant());
        p.setAnimal(new Elephant());
        p.calcNeed();
        return p;
    }
}
