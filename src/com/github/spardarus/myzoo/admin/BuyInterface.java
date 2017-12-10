package com.github.spardarus.myzoo.admin;

import com.github.spardarus.myzoo.animals.Animals;
import com.github.spardarus.myzoo.foods.Foods;

public interface BuyInterface {
    Foods buyFood(Foods foods);
    Animals buyAnimals(Animals animals);
}
