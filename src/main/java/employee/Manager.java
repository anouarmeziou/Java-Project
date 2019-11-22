package main.java.employee;

public class Manager extends Employee {

	Manager(String fname, String lname, String prof) {
		super(fname, lname, prof);
	}


    /**
     *  returns Employee descrioption.
     */
    @Override
    public String toString() {
        return "Manager [details: " +  super.toString() + "]";
    }
}
