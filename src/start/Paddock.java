package start;

import animals.Animals;
import needs.foods.BadFood;
import java.util.ArrayList;
import java.util.List;

public class Paddock{
    public List<Animals> getAnimal() {
        return animal;
    }
    private List<Animals> animal=new ArrayList<>();
    private int needFood;
    private int costFood;
    public void setAnimal(Animals ani) {
        if(!animal.contains(ani)&&ani!=null){
            this.animal.add(ani);
        }else{
            throw new IllegalArgumentException();
        }
    }
    public int getCostFood() {
        return costFood;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void calcNeed() {
        for(Animals x:animal){
            needFood+=x.getNeedFood();
        }
    }
    public int getNeedFood() {
        return needFood;
    }
    private String name;
}
