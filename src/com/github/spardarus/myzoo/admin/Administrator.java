package com.github.spardarus.myzoo.admin;

import com.github.spardarus.myzoo.animals.Animals;
import com.github.spardarus.myzoo.foods.Foods;

/**
 * Designed for shopping
 */
public class Administrator {
    private Administrator(BuyInterface buyC){
        buy=buyC;
    }
    private static Administrator instance=new Administrator(new SimpleBuy());

    /**
     * Returns the only instance
     * @return Administrator
     */
    public static Administrator getInstance(){
        return instance;
    }
    private BuyInterface buy;
    private int money=350;

    /**
     * Returns the total amount of money
     * @return money
     */
    @GetMoney(EMoney.SIMPLE)
    public int getMoney() {
        return money;
    }
    /**
     * Returns the total amount of money with a tax deduction
     * @return money
     */
    @GetMoney(EMoney.WITH_NDS)
    public int getMoneyNDS() {
         money-=18;
        return money;
    }

    /**
     * Checks the value of money to lose and win
     * @return If lost or won, false
     */
    public boolean isCheckMoney() {
        if (getInstance().getMoney() > 20000) {
            System.out.println("You Win\nBecause money > 20000$");
            return false;
        }
        if (getInstance().getMoney() < 0) {
            System.out.println("You Lose\nBecause money < 0$");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Payment
     * @param m - The purchase price
     * @return If the operation is successful, then true
     */
    public boolean pay(int m){
        if(isCheckMoney()){
            money-=m;
            return isCheckMoney();
        }
        return isCheckMoney();
    }

    /**
     * Buying food is a separate class implements interface 'BuyInterface'
     * @param foods - Type food
     * @return food
     */
    public Foods buyFood(Foods foods){
        return buy.buyFood(foods);
    }
    /**
     * Buying animals is a separate class implements interface 'BuyInterface'
     * @param animals - Type animal
     * @return animal
     */
    public Animals buyAnimals(Animals animals){
        return buy.buyAnimals(animals);
    }
}
