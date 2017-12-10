package game;

import admin.Administrator;
import paddock.Paddock;

public class Report {
    public static void getReportOnePaddock(Paddock paddock){
        Administrator adm=Administrator.getInstance();
        System.out.println();
        System.out.println("Report about your paddock: '"+paddock.getName()+"'");
        System.out.print("You have: "+paddock.getAnimal().size()+" "
                +paddock.getTypeAnimals());
        System.out.println(", money = "+ adm.getMoney()+"$");
        System.out.print("Need food = "+paddock.getNeedFood());
        System.out.print("\t| Feel "+paddock.getAnimal().get(0).getClass().getSimpleName()+" = "
                +paddock.getOneAnimal().getFeel());
        System.out.println("\t| Visitors = "+paddock.getOneAnimal().getVisitors()*paddock.getAnimal().size());
    }
}
