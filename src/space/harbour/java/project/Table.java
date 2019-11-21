package space.harbour.java.project;

import java.util.Date;

public class Table implements Availability {

    private int MAX_CAPACITY = 100;
    public int ACTUAL_NUMBER = 0;

    private boolean available = false;

    public int increase() {
        return ACTUAL_NUMBER++;
    }

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
     * @return true as we control the method in restaurant class
     */
    @Override
    public boolean open(Date userTime) {
        return true;
    }
}
