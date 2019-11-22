package main.java.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 */
public class SwimmingPool extends Facility implements Availability{
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    Date six = parser.parse("06:00");
    Date eighteen = parser.parse("18:00");

    private int MAX_CAPACITY = 100;
    public int ACTUAL_NUMBER = 0;

    public SwimmingPool() throws ParseException {
    }

    public int increase() {
        return ACTUAL_NUMBER++;
    }

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