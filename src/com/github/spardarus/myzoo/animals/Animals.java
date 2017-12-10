package com.github.spardarus.myzoo.animals;

import com.github.spardarus.myzoo.foods.Foods;

/**
 * Structure of animals
 */
public class Animals {
     /**
      * Set values for the parameters of the animal
      * @param needFood The amount of food to satisfy hunger
      * @param ratioVisitors The rating of visitors
      * @param cost The price of one animal
      */
     public Animals(int needFood,double ratioVisitors,int cost) {
          this.needFood = needFood;
          this.ratioVisitors = ratioVisitors;
          this.cost=cost;
     }
     private int feel;
     private int needFood;
     private double ratioVisitors;
     private int visitors;
     private int cost;

     /**
      * The rating of visitors
      * @return The rating of visitors
      */
     public double getRatioVisitors() {
          return ratioVisitors;
     }

     /**
      * The price of one animal
      * @return The price of one animal
      */
     public int getCost() {
          return cost;
     }

     /**
      * The number of visitors
      * @return The number of visitors
      */

     public int getVisitors() {
          return visitors;
     }

     /**
      * The calculation of the quantity of visitors
      */
     public void calcVisitors(){
          if(feel* ratioVisitors>0){
               visitors =(int)(feel* ratioVisitors);
          }else{
               visitors=1;
          }

     }

     /**
      * Rating of well-being
      * @return Rating of well-being
      */
     public int getFeel() {
          return feel;
     }

     /**
      * The amount of food to satisfy hunger
      * @return The amount of food to satisfy hunger
      */
     public int getNeedFood() {
          return needFood;
     }

     /**
      * The method of eating food
      * @param foods Type of food
      */
     public void toEat(Foods foods){
               feel += foods.getFeel();
               calcVisitors();
     }

}


