package com.github.spardarus.myzoo.foods;

/**
 * List of foods
 */
public enum EnumFoods {
    BAD_FOOD(-10, 20, 10),
    NORMAL_FOOD(1, 20, 30),
    EXCELLENT_FOOD(10, 10, 50);
    Foods food;
    EnumFoods(int f, int s, int c){
        food=new Foods(f,s,c);
    }
    public Foods getFood() {
        return food;
    }
}
