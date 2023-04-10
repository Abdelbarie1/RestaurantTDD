package io.training.tdd.restaurant;

public class Stock {

    private int flourQuantityKg;

    private int tomatoesQuantity;

    private String salt;

    private int ballsMozzarellaQuantity;

    private String oil;

    private String pepper;

    private String water;


    public Stock(int ballsMozzarellaQuantity, int tomatoesQuantity, String oil, String pepper) {
        this.ballsMozzarellaQuantity = ballsMozzarellaQuantity;
        this.tomatoesQuantity = tomatoesQuantity;
        this.oil = oil;
        this.pepper = pepper;
    }

    public Stock(int flourQuantityKg, int tomatoesQuantity, String salt, int ballsMozzarellaQuantity, String oil, String water) {
        this.flourQuantityKg = flourQuantityKg;
        this.tomatoesQuantity = tomatoesQuantity;
        this.salt = salt;
        this.ballsMozzarellaQuantity = ballsMozzarellaQuantity;
        this.oil = oil;
        this.water = water;
    }

    public int getBallsMozzarellaQuantity() {
        return ballsMozzarellaQuantity;
    }

    public int getTomatoesQuantity() {
        return tomatoesQuantity;
    }

    public String getOil() {
        return oil;
    }

    public String getPepper() {
        return pepper;
    }
}
