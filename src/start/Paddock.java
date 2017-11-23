package start;

import animals.Animals;
import needs.foods.BadFood;
import needs.Land;

import java.util.ArrayList;
import java.util.List;

public class Paddock{
    /**
     * This is the list of animals
     */
    private List<Animals> animal=new ArrayList<>();
    /**
     * The need for food
     */
    private int needFood;
    /**
     * The cost of food
     */
    private int costFood;


    public void setAnimal(Animals ani) {
        if(!animal.contains(ani)){
            this.animal.add(ani);
        }else{
            throw new IllegalArgumentException();
        }
    }


    public int getCostFood() {
        return costFood;
    }

    public int getNeedSize() {
        return needSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostSize() {
        return costSize;
    }

    public void calcNeed() {
        for(Animals x:animal){
            needFood+=x.getNeedFood();
            needSize+=x.getNeedSize();
        }
        int saturation=needFood;
        while(saturation>0){
            costFood+=new BadFood().getCOST();
            saturation=saturation- BadFood.getSaturation();
        }
        int size=needSize;
        while(size>0){
            costSize+=new Land().getCOST();
            size=size-Land.getSIZE();
        }
    }

    public int getNeedFood() {
        return needFood;
    }

    /**
     * The name of paddock
     */
    private String name;
    /**
     * This is need size paddock
     */
    private int needSize;
    /**
     * This is need size paddock
     */
    private int costSize;
    /**
     * The quality of the cleaning
     */
    private int cleaning;
    /**
     * The quality of the security
     */
    private int security;
    /**
     * The percentage that the animal may escape,
     * poisoned food visitors, it can steal.
     * This percentage depends on the level of security.
     */
    private int fail;
    /**
     * The quality of the medical examination
     */
    private int medical;

}
