package main.java.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Cinema is class that allows the manager to increase and decrease the capacity of people at the cinema
 * It also return a movie name according to userTime.
 * It also checks if the gym is available and open.
 */
public class Cinema extends Facility implements Availability {
    private int MAX_CAPACITY = 100;
    public int ACTUAL_NUMBER = 0;
    List<String> movies = Arrays.asList("Joker", "Blade Runner", "James Bond", "Lucy", "Pineapple Express");
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    Date ten;
    Date twelve;
    Date fourteen;
    Date eighteen;
    Date twenty;
    Date twentyTwo;

    public Cinema() {
        try {
            ten = parser.parse("10:00");
            twelve = parser.parse("12:00");
            fourteen = parser.parse("14:00");
            eighteen = parser.parse("18:00");
            twenty = parser.parse("20:00");
            twentyTwo = parser.parse("22:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param userTime same param as in the interface
     * @return movieName or if the user is not in time of movie it will return a string
     */
    public String getMovie(Date userTime) {
        if (userTime.after(ten) && userTime.before(twelve)) {
            return movies.get(0);
        }else if(userTime.after(twelve) && userTime.before(fourteen)) {
            return movies.get(1);
        }else if(userTime.after(fourteen) && userTime.before(eighteen)) {
            return movies.get(2);
        }else if(userTime.after(eighteen) && userTime.before(twenty)) {
            return movies.get(3);
        }else if(userTime.after(twenty) && userTime.before(twentyTwo)) {
            return movies.get(4);
        }return "Movies are not scheduled for this time";
    }

    /**
     *
     * @return the actual capacity increased by 1
     */
    public int increase() {
        return ACTUAL_NUMBER++;
    }

    /**
     *
     * @return the actual capacity decreased by 1
     */
    public int decrease() {
        return ACTUAL_NUMBER--;
    }

    /**
     *
     * @return the availability of the cinema by checking the max capacity minus the actual capacity
     */
    @Override
    public boolean availability() {
        if (MAX_CAPACITY - ACTUAL_NUMBER > 0) {
            return true;
        } return false;
    }

    /**
     *
     * @param userTime the time when the user wanted to access the activity
     * @return true if the user is in time of seeing a movie
     */
    @Override
    public boolean open(Date userTime) {
        if (userTime.after(ten) && userTime.before(twelve) ||
                userTime.after(twelve) && userTime.before(fourteen) ||
                userTime.after(fourteen) && userTime.before(eighteen) ||
                userTime.after(eighteen) && userTime.before(twenty) ||
                userTime.after(twenty) && userTime.before(twentyTwo)) {
            return true;
        } return false;
    }
}
