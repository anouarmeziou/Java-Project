package main.java.facility;

import java.text.ParseException;

public class Facility {

    /**
     * Facility allows the employee to have control on the restaurant, gym, swimmingPool and the cinema.
     */

    public Facility() {
    }

    public static void main(String[] args) throws ParseException {

        Cinema cinema = new Cinema();
        for(int i = 0; i < 200; i++) {
            cinema.increase();
        }
        System.out.println(cinema.availability());
        Restaurant restaurant = new Restaurant();
        System.out.println(restaurant.availability());
        Gym gym = new Gym();
        System.out.println(gym.availability());
        SwimmingPool swimmingPool = new SwimmingPool();
        System.out.println(swimmingPool.availability());

    }
}
