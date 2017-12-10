package admin;

import animals.Animals;
import needs.foods.Foods;

public class Administrator {
    private Administrator(BuyInterface buyC){
        buy=buyC;
    }
    private static Administrator instance=new Administrator(new SimpleBuy());
    public static Administrator getInstance(){
        return instance;
    }
    private BuyInterface buy;
    private int money=350;
    @GetMoney(EMoney.SIMPLE)
    public int getMoney() {
        return money;
    }
    @GetMoney(EMoney.WithNDS)
    public int getMoneyNDS() {
         money-=18;
        return money;
    }
    public boolean isCheckMoney() {
        if (getInstance().getMoney() > 20000) {
            System.out.println("You Win\nBecause money > 20000$");
            return false;
        }
        if (getInstance().getMoney() < 0) {
            System.out.println("You Lose\nBecause money < 0$");
            return false;
        } else {
            return true;
        }
    }
    public boolean pay(int m){
        if(isCheckMoney()){
            money-=m;
            return isCheckMoney();
        }
        return isCheckMoney();
    }
    public Foods buyFood(Foods foods){
        return buy.buyFood(foods);
    }
    public Animals buyAnimals(Animals animals){
        return buy.buyAnimals(animals);
    }
}
