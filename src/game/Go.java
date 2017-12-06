package game;

import admin.Administrator;
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
    public static Paddock initPaddock() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name your paddock");
        Paddock p = new Paddock();
        p.setName("" + sc.next());
        EnumAnimals[] eArray = EnumAnimals.values();
        boolean v = true;
        int n = 1;
        String s = new Elephant().getClass().getName();
        while (v) {
            System.out.println("Choose animal for add in you paddock");
            System.out.println("You have " + Administrator.getMoney() + "$");
            for (int i = 0; i < eArray.length; i++) {
                System.out.print("" + (i + 1) + ": " + eArray[i] + ",\t");
                if (i == 1 || i == 3 || i == 4) {
                    System.out.print("\t");
                }
                System.out.println("| cost: " + eArray[i].getAnimal().getCost() + "$ \t| need food: "
                        + eArray[i].getAnimal().getNeedFood() +
                        "\t| ratio visitor: " + eArray[i].getAnimal().getRatioVisitors());
            }
            switch (sc.nextInt()) {
                case 1:
                    n = 1;
                    s = new Elephant().getClass().getName();
                    p.setAnimal(Administrator.buyAnimals(new Elephant()));
                    v = false;
                    break;
                case 2:
                    n = 2;
                    s = new Tiger().getClass().getName();
                    p.setAnimal(Administrator.buyAnimals(new Tiger()));
                    v = false;
                    break;
                case 3:
                    n = 3;
                    s = new Crocodile().getClass().getName();
                    p.setAnimal(Administrator.buyAnimals(new Crocodile()));
                    v = false;
                    break;
                case 4:
                    n = 4;
                    s = new Parrot().getClass().getName();
                    p.setAnimal(Administrator.buyAnimals(new Parrot()));
                    v = false;
                    break;
                case 5:
                    n = 5;
                    s = new Wolf().getClass().getName();
                    p.setAnimal(Administrator.buyAnimals(new Wolf()));
                    v = false;
                    break;
            }
        }
        v = true;
        while (v) {
            if (!isCheckMoney()) {
                break;
            }
            System.out.println("You have " + Administrator.getMoney() + "$");
            System.out.println("Add the " + eArray[n - 1] +
                    "?. Cost: " + eArray[n - 1].getAnimal().getCost() + "$");
            System.out.println("1: Yes\t 2: No");
            switch (sc.nextInt()) {
                case 1:
                    addAnimal(Class.forName(s), p);
                    break;
                case 2:
                    v = false;
                    break;
            }
        }
        p.calcNeed();
        return p;
    }

    public static boolean isCheckMoney() {
        if (Administrator.getMoney() > 20000) {
            System.out.println("You Win\nBecause money > 20000$");
            return false;
        }
        if (Administrator.getMoney() < 0) {
            System.out.println("You Lose\nBecause money < 0$");
            return false;
        } else {
            return true;
        }
    }

    public static void addAnimal(Class n, Paddock p) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor<Animals> c = n.getDeclaredConstructor();
        c.setAccessible(true);
        p.setAnimal(Administrator.buyAnimals(c.newInstance()));
    }

    public static void payAndEat(Paddock initTest, Foods f) {
        int nf = 0;
        int sut = 0;
        int i = 0;
        while (initTest.getNeedFood() >= nf) {
            while (initTest.getAnimal().get(i).getNeedFood() >= sut) {
                initTest.getAnimal().get(i).toEat(Administrator.buyFood(f));
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
            money += (p.getAnimal().get(0).getNeedFood()) / p.getFoods().getSaturation() *
                    p.getFoods().getCOST();
            if (p.getAnimal().get(0).getNeedFood() % p.getFoods().getSaturation() > 0) {
                money += p.getFoods().getCOST();
            }
        }
        return money;
    }

    public static int getMoneyVistors(Paddock p) {
        int money = 0;
        money = p.getAnimal().get(0).getVisitors() * Visitors.getPay() * p.getAnimal().size();
        return money;
    }

    public static void startGame() {
        List<Paddock> paddocks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean v = true;
        int money = Administrator.getMoney();
        while (v) {
            if (!isCheckMoney()) {
                break;
            }
            System.out.println("You have " + Administrator.getMoney() + "$");
            if (paddocks.size() == 0) {
                System.out.println("You have't paddock");
            } else {
                System.out.println("You have: " + paddocks.size() + " paddock");
                System.out.println("Day of money: " + (Administrator.getMoney() - money));

                for (Paddock x : paddocks) {
                    System.out.println((paddocks.indexOf(x) + 1) + ": " + x + ", " + x.getAnimal().get(0) + ": "
                            + (x.getAnimal().size()) + ", Visitors: " + x.getAnimal().get(0).getVisitors() * x.getAnimal().size() + ", " +
                            "Feel: " + (x.getAnimal().get(0).getFeel() * x.getAnimal().size()) +
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
                if (ind>=0&&ind<=paddocks.size()){
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
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "N":
                        money = Administrator.getMoney();
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
            Administrator.pay(-Visitors.pay() * p.getAnimal().size() *
                    p.getAnimal().get(0).getVisitors());
        }
    }

    public static void startPaddock(Paddock paddock) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        EnumFoods[] eArray = EnumFoods.values();
        boolean v = true;
        while (v) {
            if (!isCheckMoney()) {
                break;
            }
            System.out.println();
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
            System.out.println("4: By " + paddock.getAnimal().get(0).getClass().getSimpleName() + "?");
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
                    addAnimal(paddock.getAnimal().get(0).getClass(), paddock);
                    break;
                case 5:
                    v = false;
                    break;
            }
        }
    }
}