package com.github.spardarus.myzoo.foods;

/**
 * A class describes the characteristics of the food
 */
public class Foods {
    private int feel;
    private int saturation;
    private int cost;

    /**
     * The number of increasing well-being
     * @return The number of increasing well-being
     */
    public int getFeel() {
        return feel;
    }

    /**
     * The price of one food
     * @return The price of one food
     */
    public int getCost() {
        return cost;
    }

    /**
     * Saturation
     * @return Saturation
     */
    public int getSaturation() {
        return saturation;
    }

    /**
     * create food
     * @param f The number of increasing well-being
     * @param s The price of one food
     * @param c Saturation
     */
    public Foods(int f, int s, int c){feel=f; saturation=s; cost=c;}
}
