package main.java.facility;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Gym is a class that allows the user to increase and decrease the capcity of people at the Gym.
 * It also checks if the gym is available and open.
 */
public class Gym extends Facility implements Availability{

    private int MAX_CAPACITY = 100;
    public int ACTUAL_NUMBER = 0;

    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    Date six;
    Date eighteen;


    public Gym() {
        try {
            six = parser.parse("06:00");
            eighteen = parser.parse("18:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    @Override
    public boolean open (Date userTime) {
        if (userTime.after(six) && userTime.before(eighteen)) {
            return true;
        } return false;
    }


    @Override
    public boolean availability() {
        if (MAX_CAPACITY - ACTUAL_NUMBER > 0) {
            return true;
        } return false;
    }
}
