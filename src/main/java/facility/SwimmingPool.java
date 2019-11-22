package main.java.facility;

import java.net.PasswordAuthentication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * SwimmingPool is a class that allows the manager to increase and decrease the capcity of people at the Swimming-pool.
 * It also checks if the swimming-pool is available and open.
 */
public class SwimmingPool extends Facility implements Availability{
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    Date six;
    Date eighteen;

    private int MAX_CAPACITY = 100;
    public int ACTUAL_NUMBER = 0;

    public SwimmingPool(){
        try {
            six = parser.parse("06:00");
            eighteen = parser.parse("18:00");
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * already explained previously
     * @return
     */
    public int increase() {
        return ACTUAL_NUMBER++;
    }

    /**
     * already explained previously
     * @return
     */
    public int decrease() {
        return ACTUAL_NUMBER--;
    }

    /**
     * already explained previously
     * @return
     */
    @Override
    public boolean open (Date userTime) {
        if (userTime.after(six) && userTime.before(eighteen)) {
            return true;
        } return false;
    }

    /**
     * already explained previously
     * @return
     */
    @Override
    public boolean availability() {
        if (MAX_CAPACITY - ACTUAL_NUMBER > 0) {
            return true;
        } return false;
    }
}