package start;

import needs.foods.Foods;

public class Administrator {
    private static int money=10;
    public static int getMoney() {
        return money;
    }
    public static void pay(int m){
        money-=m;
    }

    public static Foods payFood(Foods foods){
        pay(foods.getCOST());
        return foods;
    }
}
