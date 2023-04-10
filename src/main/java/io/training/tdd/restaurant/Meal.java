package io.training.tdd.restaurant;

public class Meal {

    private Ticket ticket;

    public Meal(Ticket ticket) {
        this.ticket = ticket;
    }


    public int servedDishes() {
        return ticket.getBallMozzarellaQuantity()+ticket.getNumberOfPizza();
    }

    public String cookingDuration() {
        int cookingTime=6;
        for (int count=1;count<ticket.getBallMozzarellaQuantity();count++) {
            cookingTime += 3;
        }
        if(ticket.getNumberOfPizza()>0){
            cookingTime+=10;
            for (int count=1;count<ticket.getNumberOfPizza();count++) {
                cookingTime += 5;
            }
        }
        return ""+cookingTime;
    }
}
