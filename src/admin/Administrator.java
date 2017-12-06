package admin;

import animals.Animals;
import needs.foods.Foods;

public class Administrator {
    static BuyInterface buy=new SimpleBuy();
    private static int money=220;
    public static int getMoney() {
        return money;
    }
    public static boolean pay(int m){
            money-=m;
            return true;
    }
    public static Foods buyFood(Foods foods){
        return buy.buyFood(foods);
    }
    public static Animals buyAnimals(Animals animals){
        return buy.buyAnimals(animals);
    }
}
