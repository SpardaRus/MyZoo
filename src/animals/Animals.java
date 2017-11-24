package animals;

import needs.foods.Foods;

public abstract class Animals {
     public Animals(int needFood,double ratioVisitors,int cost) {
          this.needFood = needFood;
          this.ratioVisitors = ratioVisitors;
          this.cost=cost;
     }
     int feel=1;
     int needFood=1;
     double ratioVisitors=1;
     int visitors=1;
     int cost=1;

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
     }
}


