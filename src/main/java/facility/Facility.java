package main.java.facility;

import java.text.ParseException;

public class Facility {

    /**
     * Facility allows the employee to have control on the restaurant, gym, swimmingPool and the cinema.
     */
    Restaurant restaurant = new Restaurant();
    Gym gym = new Gym();
    SwimmingPool swimmingPool = new SwimmingPool();
    Cinema cinema = new Cinema();

    /**
     *
     * @throws ParseException
     */
    public Facility() throws ParseException {
    }
}
