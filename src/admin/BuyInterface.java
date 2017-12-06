package admin;

import animals.Animals;
import needs.foods.Foods;

public interface BuyInterface {
    Foods buyFood(Foods foods);
    Animals buyAnimals(Animals animals);
}
