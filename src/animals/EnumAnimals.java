package animals;
public enum EnumAnimals {
    ELEPHANT(new Elephant()),
    TIGER(new Tiger()),
    CROCODILE(new Crocodile()),
    PARROT(new Parrot()),
    WOLF(new Wolf());
    Animals anim;
    EnumAnimals(Animals a){
        anim=a;
    }
    public Animals getAnimal(){
        return anim;
    }
}

