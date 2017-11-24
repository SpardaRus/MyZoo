package animals;

import needs.foods.Foods;

public abstract class Animals {
     public Animals(int needFood,int ratioVisitors) {
          this.needFood = needFood;
          this.ratioVisitors = ratioVisitors;
     }
     static int feel=1;
     static int needFood=1;
     static int ratioVisitors=1;
     static int visitors=1;

     public static int getVisitors() {
          return visitors;
     }

     public static void calcVisitors(){
          if(feel* ratioVisitors>0){
               visitors =feel* ratioVisitors;
          }else{
               visitors=1;
          }

     }
     public int getFeel() {
          return feel;
     }
     public static int getNeedFood() {
          return needFood;
     }
     public static void toEat(Foods foods){
          feel+=foods.getFeel();
     }
}


