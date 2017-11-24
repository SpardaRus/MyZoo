package needs.foods;

public enum EnumFoods {
    BAD_FOOD(new BadFood()),
    NORMAL_FOOD(new NormalFood()),
    EXCELLENT_FOOD(new ExcellentFood());
    Foods food;
    EnumFoods(Foods f){
        food=f;
    }
    public Foods getFood() {
        return food;
    }
}
