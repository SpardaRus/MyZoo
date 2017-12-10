package paddock;

import animals.Animals;
import animals.EnumAnimals;
import needs.foods.BadFood;
import needs.foods.Foods;

import java.util.ArrayList;
import java.util.List;

public class Paddock<T extends Animals>{

    private List<T> animal=new ArrayList<>();
    private int needFood;
    private Foods foods=new BadFood();
    private String name;
    private EnumAnimals typeAnimals;

    public EnumAnimals getTypeAnimals() {
        return typeAnimals;
    }
    public void setTypeAnimals(EnumAnimals typeAnimals) {
        this.typeAnimals = typeAnimals;
    }

    public Foods getFoods() {
        return foods;
    }
    public void setFoods(Foods foods) {
        this.foods = foods;
    }
    public List<T> getAnimal() {
        return animal;
    }
    public void setAnimal(T ani) {
        if(!animal.contains(ani)&&ani!=null){
            animal.add((ani));
        }else{
            System.out.println("This object is contains or null");
        }
    }
    public T getOneAnimal(){
        return animal.get(0);
    }
    public T getIndexAnimal(int index){
        return animal.get(index);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void calcNeed() {
        needFood=animal.size()*getOneAnimal().getNeedFood();
    }
    public int getNeedFood() {
        calcNeed();
        return needFood;
    }

    @Override
    public String toString() {
        return  "name='" + name + "'";
    }
}
