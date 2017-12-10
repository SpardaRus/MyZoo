package game;

import admin.Administrator;
import admin.ChooseMoney;
import admin.EMoney;
import animals.*;
import needs.foods.*;
import paddock.Paddock;
import visitors.Visitors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Go {
    public static Administrator adm=Administrator.getInstance();
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
                    p.setAnimal(adm.buyAnimals(eArray[ind-1].getAnimal()));
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



    public static void addAnimal(EnumAnimals n, Paddock p) throws Exception {
        p.setAnimal(adm.buyAnimals(n.getAnimal()));
    }

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

    public static int getMoneyFood(Paddock p) {
        int money = 0;
        for (int i = 0; i < p.getAnimal().size(); i++) {
            money += (p.getOneAnimal().getNeedFood()) / p.getFoods().getSaturation() *
                    p.getFoods().getCOST();
            if (p.getOneAnimal().getNeedFood() % p.getFoods().getSaturation() > 0) {
                money += p.getFoods().getCOST();
            }
        }
        return money;
    }

    public static int getMoneyVistors(Paddock p) {
      return p.getOneAnimal().getVisitors() * Visitors.getPay() * p.getAnimal().size();
    }

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

    public static void endDay(List<Paddock> paddocks) {
        for (Paddock p : paddocks) {
            payAndEat(p, p.getFoods());
            adm.pay(-Visitors.pay() * p.getAnimal().size() *
                    p.getOneAnimal().getVisitors());
        }
    }

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
                System.out.println("\t| cost: " + eArray[i].getFood().getCOST() + "$ " +
                        "\t| feel: " + eArray[i].getFood().getFeel() +
                        "\t| saturation: " + eArray[i].getFood().getSaturation());
            }
            System.out.println("4: By " + paddock.getTypeAnimals() + "?");
            System.out.println("5: Back");
            switch (sc.nextInt()) {
                case 1:
                    paddock.setFoods(new BadFood());
                    break;
                case 2:
                    paddock.setFoods(new NormalFood());
                    break;
                case 3:
                    paddock.setFoods(new ExcellentFood());
                    break;
                case 4:
                    addAnimal(paddock.getTypeAnimals(), paddock);
                    break;
                case 5:
                    v = false;
                    break;
            }
        }
    }
}
