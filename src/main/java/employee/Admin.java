package main.java.employee;

import main.java.database.Mongo;
import main.java.facility.Facility;

public class Admin extends Employee {

	public static Mongo mongo;
	public Facility facility;

	Admin(Mongo mongo) {
		super("admin", "admin", "admin");
		this.mongo = mongo;
	}

    private void hire(String fname, String lname, String prof) {
    	Employee emp = null;
    	if (prof.equals(super.PROFILES[0])) {
    		emp = new Receptionist(fname, lname, prof);
    	} else if (prof.equals(super.PROFILES[1])) {
    		emp = new Manager(fname, lname, prof);
    	} else if (prof.equals(super.PROFILES[2])) {
    		emp = new Cleaner(fname, lname, prof);
    	}
    	mongo.storeItem(emp);
    }

    private void fire(Integer id) {

    }

}
