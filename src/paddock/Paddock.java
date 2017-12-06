package paddock;

import animals.Animals;
import needs.foods.BadFood;
import needs.foods.Foods;

import java.util.ArrayList;
import java.util.List;

public class Paddock{
    public List<Animals> getAnimal() {
        return animal;
    }
    private List<Animals> animal=new ArrayList<>();
    private int needFood;

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    private Foods foods=new BadFood();
    public void setAnimal(Animals ani) {
        if(!animal.contains(ani)&&ani!=null){
            this.animal.add(ani);
        }else{
            System.out.println("This object is contains or null");
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void calcNeed() {
        needFood=animal.size()*animal.get(0).getNeedFood();
    }
    public int getNeedFood() {
        calcNeed();
        return needFood;
    }
    private String name;

    @Override
    public String toString() {
        return  "name='" + name + "'";
    }
}
