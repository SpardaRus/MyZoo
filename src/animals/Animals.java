package animals;

import needs.foods.Foods;

public class Animals {
     public Animals(int needFood,double ratioVisitors,int cost) {
          this.needFood = needFood;
          this.ratioVisitors = ratioVisitors;
          this.cost=cost;
     }
     int feel;
     int needFood;
     double ratioVisitors;
     int visitors;
     int cost;

     public double getRatioVisitors() {
          return ratioVisitors;
     }

     public int getCost() {
          return cost;
     }

     public int getVisitors() {
          return visitors;
     }

     public void calcVisitors(){
          if(feel* ratioVisitors>0){
               visitors =(int)(feel* ratioVisitors);
          }else{
               visitors=1;
          }

     }
     public int getFeel() {
          return feel;
     }
     public int getNeedFood() {
          return needFood;
     }
     public void toEat(Foods foods){
          feel+=foods.getFeel();
          calcVisitors();
     }

}


