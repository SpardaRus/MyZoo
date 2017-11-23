package needs.foods;

public abstract class Foods {
    static int feel;
    static int saturation;
    static int cost;
    public static int getFeel() {
        return feel;
    }
    public static int getCOST() {
        return cost;
    }
    public static int getSaturation() {
        return saturation;
    }
    public Foods(int f, int s, int c){feel=f; saturation=s; cost=c;}
}
