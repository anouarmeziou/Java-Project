package main.java.employee;

public class Cleaner extends Employee {


	Cleaner(String fname, String lname, String prof) {
		super(fname, lname, prof);
	}

    /**
     *  returns Employee descrioption.
     */
    @Override
    public String toString() {
        return "Cleaner [details: " +  super.toString() + "]";
    }
}
