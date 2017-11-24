package start;


import tests.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        System.out.println();
        Go.start(Go.initPaddock());
        System.out.println();
        System.out.println("End");
    }
}
