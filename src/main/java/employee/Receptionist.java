package main.java.employee;

public class Receptionist extends Employee {

	Receptionist(String fname, String lname, String prof) {
		super(fname, lname, prof);
	}

    /**
     *  returns Employee descrioption.
     */
    @Override
    public String toString() {
        return "Receptionist [details: " +  super.toString() + "]";
    }
}
