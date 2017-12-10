package animals;
public enum EnumAnimals {
    ELEPHANT(30,1.9,90),
    TIGER(25,2.1,110),
    CROCODILE(20,1.7,70),
    PARROT(5,1.2,20),
    WOLF(10,1.3,30);
    Animals anim;
    EnumAnimals(int needFood,double ratioVisitors,int cost){
        anim=new Animals(needFood,ratioVisitors,cost);
    }
    public Animals getAnimal(){
        return anim;
    }
}

