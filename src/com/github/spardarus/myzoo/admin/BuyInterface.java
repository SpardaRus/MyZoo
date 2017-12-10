package com.github.spardarus.myzoo.admin;

import com.github.spardarus.myzoo.animals.Animals;
import com.github.spardarus.myzoo.foods.Foods;

/**
 * Intended to substitute different implementations purchases
 */
public interface BuyInterface {
    Foods buyFood(Foods foods);
    Animals buyAnimals(Animals animals);
}
