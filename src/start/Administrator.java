package start;

import animals.Animals;
import needs.foods.Foods;

public class Administrator {
    private static int money=250;
    public static int getMoney() {
        return money;
    }
    public static boolean pay(int m){
            money-=m;
            return true;
    }
    public static Foods byFood(Foods foods){
        if(pay(foods.getCOST())){
            return foods;
        }else{
            return null;
        }

    }
    public static Animals byAnimals(Animals animals){
        if(pay(animals.getCost())){
            return animals;
        }else{
            return null;
        }

    }
}
