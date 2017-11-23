package animals;

public abstract class Animals {
     public Animals(int NEED_FOOD, int NEED_SIZE) {
          this.NEED_FOOD = NEED_FOOD;
          this.NEED_SIZE = NEED_SIZE;
     }

     int NEED_FOOD;
     int NEED_SIZE;
     public int getNeedFood() {
          return NEED_FOOD;
     }
     public int getNeedSize() {
          return NEED_SIZE;
     }
}


