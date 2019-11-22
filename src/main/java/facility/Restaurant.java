package main.java.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Restaurant is class that allows the manager to increase and decrease the capcity of people at the restaurant.
 * It also checks if the restaurant is available and open.
 */
public class Restaurant extends Facility implements Availability {

    Table table = new Table();
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");

    Date ten;
    Date six;
    Date eighteen;
    Date twentyTwo;

    public Restaurant() {
        try {
            ten = parser.parse("10:00");
            six = parser.parse("06:00");
            eighteen = parser.parse("18:00");
            twentyTwo = parser.parse("22:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * already explained previously
     * @param userTime the time when the user wanted to access the activity
     * @return
     */
    @Override
    public boolean open (Date userTime) {
        if (userTime.after(six) && userTime.before(ten) || userTime.after(eighteen) && userTime.before(twentyTwo)) {
            return true;
        } return false;
    }

    /**
     * already explained previously
     * @return
     */
    @Override
    public boolean availability() {
        return table.availability();
    }
}