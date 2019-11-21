package main.java.facility;

import java.util.Date;

public interface Availability {

    /**
     *
     * @return true if the activity is available for a new customer
     */
    public boolean availability();

    /**
     *
     * @param userTime the time when the user wanted to access the activity
     * @return true if the time and the activity time matches
     */
    public boolean open(Date userTime);
}
