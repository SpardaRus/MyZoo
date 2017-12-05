package start;

import animals.Animals;
import needs.foods.Foods;

public class Administrator {
    private static int money=220;
    public static int getMoney() {
        return money;
    }
    public static boolean pay(int m){
            money-=m;
            return true;
    }
    public static Foods buyFood(Foods foods){
        if(pay(foods.getCOST())){
            return foods;
        }else{
            return null;
        }

    }
    public static Animals buyAnimals(Animals animals){
        if(pay(animals.getCost())){
            return animals;
        }else{
            return null;
        }

    }
}
