package io.training.tdd.restaurant;

import io.training.tdd.restaurant.exception.UnavailableDishException;

public class Restaurant {

    Stock stock;

    public Restaurant(String balls, String tomatoes, String oil, String pepper) {
        int ballsMozzarellaQuantity,tomatoesQuantity;
        ballsMozzarellaQuantity = Integer.parseInt(balls.split(" ")[0]);
        tomatoesQuantity = Integer.parseInt(tomatoes.split(" ")[0]);
        this.stock=new Stock(ballsMozzarellaQuantity,tomatoesQuantity,oil,pepper);
    }

    public Restaurant(String flour, String tomatoes, String seaSalt, String ballMozzarella, String oliveOil, String water) {
        int ballsMozzarellaQuantity,tomatoesQuantity,floutQuantity;
        ballsMozzarellaQuantity = Integer.parseInt(ballMozzarella.split(" ")[0]);
        tomatoesQuantity = Integer.parseInt(tomatoes.split(" ")[0]);
        floutQuantity = Integer.parseInt(flour.split("")[0]);
        this.stock=new Stock(floutQuantity,tomatoesQuantity,seaSalt,ballsMozzarellaQuantity,oliveOil,water);
    }


    public Ticket order(String order) throws UnavailableDishException {
        int ballMozzarellaQuantity=Integer.parseInt(order.split(" ")[0]);
        if(ballMozzarellaQuantity>stock.getBallsMozzarellaQuantity()){
            throw new UnavailableDishException("There is not enought Ball for this Order !!^_^");
        }
        return new Ticket(order);
    }

    public Meal retrieve(Ticket ticket) {
        return new Meal(ticket);
    }
}
