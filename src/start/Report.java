package start;

public class Report {
    public static void getReportOnePaddock(Paddock paddock){
        System.out.println("Report about your paddock: '"+paddock.getName()+"'");
        System.out.println("You have "+paddock.getAnimal().size()+" "
                +paddock.getAnimal().get(0).getClass().getSimpleName());
        System.out.println("You have "+Administrator.getMoney()+"$");
        System.out.println("Need food = "+paddock.getNeedFood());
        System.out.println("Feel "+paddock.getAnimal().get(0).getClass().getSimpleName()+" = "
                +paddock.getAnimal().get(0).getFeel());
        System.out.println("Visitors = "+paddock.getAnimal().get(0).getVisitors()*paddock.getAnimal().size());
    }
}
