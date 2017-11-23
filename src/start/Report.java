package start;

public class Report {
    public static void getReportOnePaddock(Paddock paddock){
        paddock.calcNeed();
        System.out.println("Report about your paddock: '"+paddock.getName()+"'");
        System.out.println("Need food = "+paddock.getNeedFood());
        System.out.println("Need to pay for food = "+paddock.getCostFood()+" $");
        System.out.println("Need size = "+paddock.getNeedSize()+" m^2");
        System.out.println("Need to pay for size = "+paddock.getCostSize()+" $");
    }
}
