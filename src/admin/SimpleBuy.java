package admin;

import animals.Animals;
import needs.foods.Foods;

import static admin.Administrator.pay;

public class SimpleBuy implements BuyInterface {
    @Override
    public Foods buyFood(Foods foods) {
        if(pay(foods.getCOST())){
            return foods;
        }else{
            return null;
        }
    }

    @Override
    public Animals buyAnimals(Animals animals) {
        if(pay(animals.getCost())){
            return animals;
        }else{
            return null;
        }
    }
}
