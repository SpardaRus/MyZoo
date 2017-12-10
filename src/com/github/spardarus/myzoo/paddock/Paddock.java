package com.github.spardarus.myzoo.paddock;

import com.github.spardarus.myzoo.animals.Animals;
import com.github.spardarus.myzoo.animals.EnumAnimals;
import com.github.spardarus.myzoo.foods.EnumFoods;
import com.github.spardarus.myzoo.foods.Foods;

import java.util.ArrayList;
import java.util.List;

/**
 * Storing and working with animals
 * @param <T> extends Animals
 */
public class Paddock<T extends Animals>{

    private List<T> animal=new ArrayList<>();
    private int needFood;
    private Foods foods= EnumFoods.BAD_FOOD.getFood();
    private String name;
    private EnumAnimals typeAnimals;

    /**
     * Get type Animals
     * @return Get type Animals
     */
    public EnumAnimals getTypeAnimals() {
        return typeAnimals;
    }

    /**
     * Set type Animals
     * @param typeAnimals type Animals
     */
    public void setTypeAnimals(EnumAnimals typeAnimals) {
        this.typeAnimals = typeAnimals;
    }

    /**
     * The type of food they feed the animals in the paddock
     * @return type of food they feed the animals
     */
    public Foods getFoods() {
        return foods;
    }

    /**
     * Set the type of food they feed the animals in the paddock
     * @param foods type of food
     */
    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    /**
     * Get list animals
     * @return list animals
     */
    public List<T> getAnimal() {
        return animal;
    }

    /**
     * Add animals
     * @param ani animal
     */
    public void addAnimal(T ani) {
        if(ani!=null){
            animal.add((ani));
        }else{
            System.out.println("This object is null");
        }
    }

    /**
     * Get first add animal
     * @return animal
     */
    public T getOneAnimal(){
        return animal.get(0);
    }

    /**
     * Get animal of index
     * @param index index of animal
     * @return animal
     */
    public T getIndexAnimal(int index){
        return animal.get(index);
    }

    /**
     * Get name of paddock
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of paddock
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The calculation of the amount of food required to feed the animals
     */
    public void calcNeed() {
        needFood=animal.size()*getOneAnimal().getNeedFood();
    }

    /**
     * Get food required to feed the animals
     * @return The amount of food
     */
    public int getNeedFood() {
        calcNeed();
        return needFood;
    }

    @Override
    public String toString() {
        return  "name='" + name + "'";
    }
}
