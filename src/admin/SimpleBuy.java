package admin;

import animals.Animals;
import needs.foods.Foods;

public class SimpleBuy implements BuyInterface {
    @Override
    public Foods buyFood(Foods foods) {
        if(Administrator.getInstance().pay(foods.getCOST())){
            return foods;
        }else{
            return null;
        }
    }

    @Override
    public Animals buyAnimals(Animals animals){
        if(Administrator.getInstance().pay(animals.getCost())){
            return animals;
        }else{
            return null;
        }
    }
}
