package com.github.spardarus.myzoo.foods;

public class Foods {
    int feel;
    int saturation;
    int cost;
    public int getFeel() {
        return feel;
    }
    public int getCost() {
        return cost;
    }
    public int getSaturation() {
        return saturation;
    }
    public Foods(int f, int s, int c){feel=f; saturation=s; cost=c;}
}
