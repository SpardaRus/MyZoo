package com.github.spardarus.myzoo.admin;

import com.github.spardarus.myzoo.animals.Animals;
import com.github.spardarus.myzoo.foods.Foods;

/**
 * The class that provides the behaviour of buying food and animals
 */
public class SimpleBuy implements BuyInterface {
    @Override
    public Foods buyFood(Foods foods) {
        if(Administrator.getInstance().pay(foods.getCost())){
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
