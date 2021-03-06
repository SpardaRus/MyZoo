package com.github.spardarus.myzoo.game;

import com.github.spardarus.myzoo.admin.Administrator;
import com.github.spardarus.myzoo.admin.ChooseMoney;
import com.github.spardarus.myzoo.admin.EMoney;
import com.github.spardarus.myzoo.animals.*;
import com.github.spardarus.myzoo.foods.*;
import com.github.spardarus.myzoo.paddock.Paddock;
import com.github.spardarus.myzoo.visitors.Visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Logic games
 */
public class Go {
    public static Administrator adm=Administrator.getInstance();

    /**
     * Create a new paddock
     * @return new paddock
     * @throws Exception
     */
    public static Paddock initPaddock() throws Exception {
        Scanner sc = new Scanner(System.in);
        Paddock p = new Paddock();
        EnumAnimals[] eArray = EnumAnimals.values();
        Integer admMoney=new ChooseMoney().chooseMoney(EMoney.SIMPLE);
        boolean v = true;
        int n = 1;

        System.out.println("Please enter name your paddock");
        p.setName("" + sc.next());
        while (v) {
            if(!adm.isCheckMoney()){
                break;
            }
                System.out.println("Choose animal for add in you paddock");
                try {
                    System.out.println("You have " + admMoney + "$");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < eArray.length; i++) {
                    System.out.print("" + (i + 1) + ": " + eArray[i] + ",\t");
                    if (i == 1 || i == 3 || i == 4) {
                        System.out.print("\t");
                    }
                    System.out.println("| cost: " + eArray[i].getAnimal().getCost() + "$ \t| need food: "
                            + eArray[i].getAnimal().getNeedFood() +
                            "\t| ratio visitor: " + eArray[i].getAnimal().getRatioVisitors());
                }
            String console = sc.next();
            try {
                Integer ind=Integer.parseInt(console);
                if (ind>0&&ind<=eArray.length){
                    n = ind;
                    p.addAnimal(adm.buyAnimals(eArray[ind-1].getAnimal()));
                    p.setTypeAnimals(eArray[ind-1]);
                    v = false;
                }
            }catch (Exception e){
            }
        }
        v = true;
        while (v) {
            if(!adm.isCheckMoney()){
                break;
            }
            System.out.println("You have " + adm.getMoney() + "$");
            System.out.println("Add the " + eArray[n - 1] +
                    "?. Cost: " + eArray[n - 1].getAnimal().getCost() + "$");
            System.out.println("1: Yes\t 2: No");
            switch (sc.nextInt()) {
                case 1:
                    addAnimal(eArray[n-1], p);
                    break;
                case 2:
                    v = false;
                    break;
            }
        }
        p.calcNeed();
        return p;
    }


    /**
     * Adding an animal into the paddock
     * @param n Type of animal
     * @param p paddock
     * @throws Exception
     */
    public static void addAnimal(EnumAnimals n, Paddock p) throws Exception {
        p.addAnimal(adm.buyAnimals(n.getAnimal()));
    }

    /**
     * Buying and feeding animals
     * @param initTest Paddock
     * @param f Type of foods
     */
    public static void payAndEat(Paddock initTest, Foods f) {
        int nf = 0;
        int sut = 0;
        int i = 0;
        while (initTest.getNeedFood() >= nf) {
            while (initTest.getIndexAnimal(i).getNeedFood() >= sut) {
                initTest.getIndexAnimal(i).toEat(adm.buyFood(f));
                sut += f.getSaturation();
            }
            i++;
            nf += sut;
            sut = 0;
        }
    }

    /**
     * Count money to pay for food in the paddock
     * @param p Paddock
     * @return Money to pay for food in the paddock
     */
    public static int getMoneyFood(Paddock p) {
        int money = 0;
        for (Object i:p.getAnimal()) {
            money += (p.getOneAnimal().getNeedFood()) / p.getFoods().getSaturation() *
                    p.getFoods().getCost();
            if (p.getOneAnimal().getNeedFood() % p.getFoods().getSaturation() > 0) {
                money += p.getFoods().getCost();
            }
        }
        return money;
    }

    /**
     * The count arrived in the paddock
     * @param p Paddock
     * @return Arrived in the paddock
     */
    public static int getMoneyVistors(Paddock p) {
      return p.getOneAnimal().getVisitors() * Visitors.pay() * p.getAnimal().size();
    }

    /**
     * The main menu of the game
     */
    public static void startGame() {
        List<Paddock> paddocks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean v = true;
        int money = adm.getMoney();
        while (v) {
            if(!adm.isCheckMoney()){
                break;
            }
            System.out.println("You have " + adm.getMoney() + "$");
            if (paddocks.size() == 0) {
                System.out.println("You have't paddock");
            } else {
                System.out.println("You have: " + paddocks.size() + " paddock");
                System.out.println("Day of money: " + (adm.getMoney() - money));

                for (Paddock x : paddocks) {
                    System.out.println((paddocks.indexOf(x) + 1) + ": " + x + ", " + x.getTypeAnimals() + ": "
                            + (x.getAnimal().size()) + ", Visitors: " + x.getOneAnimal().getVisitors() *
                            x.getAnimal().size() + ", " +
                            "Feel: " + (x.getOneAnimal().getFeel() * x.getAnimal().size()) +
                            "\n\tDay of money: " + getMoneyVistors(x) +
                            "$, Cost food: " + getMoneyFood(x) + "$");
                }
            }
            System.out.println("A: Add the paddock");
            System.out.println("N: Next day");
            System.out.println("End: End the game");
            String console = sc.next();
            try {
                Integer ind=Integer.parseInt(console);
                if (ind>0&&ind<=paddocks.size()){
                    startPaddock(paddocks.get(Integer.parseInt(console)-1));
                }
            }catch (Exception e){

            }
                switch (console) {
                    case "A":
                        try {
                            Paddock p = initPaddock();
                            paddocks.add(p);
                            startPaddock(p);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "N":
                        money = adm.getMoney();
                        endDay(paddocks);
                        break;
                    case "End":
                        v = false;
                        break;
                }
        }
    }

    /**
     * Summing up the day
     * @param paddocks List paddock
     */
    public static void endDay(List<Paddock> paddocks) {
        for (Paddock p : paddocks) {
            payAndEat(p, p.getFoods());
            adm.pay(-Visitors.pay() * p.getAnimal().size() *
                    p.getOneAnimal().getVisitors());
        }
    }

    /**
     * Setting the paddock
     * @param paddock Paddock
     * @throws Exception
     */
    public static void startPaddock(Paddock paddock) throws Exception {
        Scanner sc = new Scanner(System.in);
        EnumFoods[] eArray = EnumFoods.values();
        boolean v = true;
        while (v) {
            if(!adm.isCheckMoney()){
                break;
            }
            Report.getReportOnePaddock(paddock);
            System.out.println("Need by food. Your choose is:");
            for (int i = 0; i < eArray.length; i++) {
                System.out.print("" + (i + 1) + ": " + eArray[i]);
                if (i == 0 || i == 1) {
                    System.out.print("\t");
                }
                if (i == 0) {
                    System.out.print("\t");
                }
                System.out.println("\t| cost: " + eArray[i].getFood().getCost() + "$ " +
                        "\t| feel: " + eArray[i].getFood().getFeel() +
                        "\t| saturation: " + eArray[i].getFood().getSaturation());
            }
            System.out.println(""+(eArray.length+1)+": By " + paddock.getTypeAnimals() + "?");
            System.out.println(""+(eArray.length+2)+": Back");
            String console = sc.next();
            try {
                Integer ind=Integer.parseInt(console);
                if(ind>0){
                    if (ind<=eArray.length){
                        paddock.setFoods(eArray[ind-1].getFood());
                    }else{
                        if(ind<=eArray.length+1){
                            addAnimal(paddock.getTypeAnimals(), paddock);
                        }else{
                            if(ind<=eArray.length+2){
                                v = false;
                            }
                        }

                    }
                }


            }catch (Exception e){

            }
        }
    }
}
