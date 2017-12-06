package game;

import admin.Administrator;
import paddock.Paddock;

public class Report {
    public static void getReportOnePaddock(Paddock paddock){
        System.out.println("Report about your paddock: '"+paddock.getName()+"'");
        System.out.print("You have: "+paddock.getAnimal().size()+" "
                +paddock.getAnimal().get(0).getClass().getSimpleName());
        System.out.println(", money = "+ Administrator.getMoney()+"$");
        System.out.print("Need food = "+paddock.getNeedFood());
        System.out.print("\t| Feel "+paddock.getAnimal().get(0).getClass().getSimpleName()+" = "
                +paddock.getAnimal().get(0).getFeel());
        System.out.println("\t| Visitors = "+paddock.getAnimal().get(0).getVisitors()*paddock.getAnimal().size());
    }
}
