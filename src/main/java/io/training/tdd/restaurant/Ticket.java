package io.training.tdd.restaurant;

public class Ticket {

    private int ballMozzarellaQuantity;

    private String saucce;

    private String extra;

    private int numberOfPizza=0;

    public Ticket(String order) {
        int ballMozzarellaQuantity=Integer.parseInt(order.split(" ")[0]);
        this.ballMozzarellaQuantity = ballMozzarellaQuantity;
        this.saucce = order.split(" ")[1];
        this.extra = order.split(" ")[3];
    }

    public int getBallMozzarellaQuantity() {
        return ballMozzarellaQuantity;
    }

    public String getSaucce() {
        return saucce;
    }

    public String getExtra() {
        return extra;
    }

    public int getNumberOfPizza() {
        return numberOfPizza;
    }

    public void setNumberOfPizza(int numberOfPizza) {
        this.numberOfPizza = numberOfPizza;
    }

    public Ticket and(String s) {
        this.setNumberOfPizza(Integer.parseInt(s.split(" ")[0]));
        return this;
    }

}
