package io.training.tdd.restaurant;

import io.training.tdd.restaurant.exception.UnavailableDishException;
import junit.framework.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTest {

    /**
     * recipe for a single dish of Tomato Mozzarella Salad is
     *
     * 1 ball of Mozzarella
     * 2 tomatoes
     * some olive oil
     *
     * preparation time is 6 minutes
     *
     * regarding Restaurant stocks :
     *   if there is not quantity it means that the ingredient is in stock and unlimited. (here it concern olive oil and pepper)
     */
    @Test
    public void shouldServeTomatoMozzarellaSalad() throws UnavailableDishException {
        Restaurant restaurant = new Restaurant("6 balls Mozzarella", "20 tomatoes", "olive oil", "pepper");
        Ticket ticket = restaurant.order("1 Tomato Mozzarella Salad");
        Meal meal = restaurant.retrieve(ticket);
        assertThat(meal.servedDishes()).isEqualTo(1);
        assertThat(meal.cookingDuration()).isEqualTo("6");
    }

/**
     * write a test to ensure that when a recipe require out of stocks ingredients we receive an UnavailableDishException (unchecked)
     */

// Allowed modification zone stats here
/*    @Test
    public void shouldFailWhenOutOfStock(){
        Restaurant restaurant=new Restaurant("6 balls Mozzarella", "20 tomatoes", "olive oil", "pepper");
        Ticket ticket = restaurant.order("21 Tomato Mozzarella Salad");
        Meal meal = restaurant.retrieve(ticket);
        Assert.fail();
    }*/
// Allowed modification zone ends here



/**
     * when cooking more than one dish of the same type :
     * first dish takes standard time, subsequents dish have their cooking time halved
     *
     * here : first = 6 ; 2nd = 3 ; 3rd = 3 ; 4th = 3 => 15 minutes
     */

    @Test
    public void shouldCookFasterWhenDoingMultipleInstanceOfTheSameDish() throws UnavailableDishException {
        Restaurant restaurant = new Restaurant("6 balls Mozzarella", "20 tomatoes", "olive oil", "sea salt");
        Ticket ticket = restaurant.order("4 Tomato Mozzarella Salad");
        Meal meal = restaurant.retrieve(ticket);
        assertThat(meal.servedDishes()).isEqualTo(4);
        assertThat(meal.cookingDuration()).isEqualTo("15");
    }


/**
     * recipe for a Pizza is
     *
     * 1 ball of Mozzarella
     * 4 tomatoes
     * some olive oil
     * 100cl of water
     * 300g of Flour
     * sea salt
     *
     * cooking time is 10 minutes
     * baking time is 10 minutes at 300 degree celsius
     *
     *
     * Regarding baking :
     *   oven have unlimited capacity multiple dishes can be baked at the same time
     */

    @Test
    public void shouldServeMixedOrders() throws UnavailableDishException {
        Restaurant restaurant = new Restaurant("1Kg Flour", "50 tomatoes", "sea salt", "6 balls Mozzarella", "olive oil", "water");
        Ticket ticket = restaurant.order("3 Tomato Mozzarella Salad").and("2 Pizza");
        Meal meal = restaurant.retrieve(ticket);
        assertThat(meal.servedDishes()).isEqualTo(5);
        assertThat(meal.cookingDuration()).isEqualTo("27");
    }

}
