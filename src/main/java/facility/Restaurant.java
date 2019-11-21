package main.java.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurant extends Facility implements Availability {
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    Date six = parser.parse("06:00");
    Date ten = parser.parse("10:00");
    Date eighteen = parser.parse("18:00");
    Date twentyTwo = parser.parse("22:00");

    Table table = new Table();


    public Restaurant() throws ParseException {
    }


    @Override
    public boolean open (Date userTime) {
        if (userTime.after(six) && userTime.before(ten) || userTime.after(eighteen) && userTime.before(twentyTwo)) {
            return true;
        } return false;
    }


    @Override
    public boolean availability() {
        return table.availability();
    }
}