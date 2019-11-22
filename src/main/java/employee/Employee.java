package main.java.employee;

import java.util.Random;

public class Employee {

    Random random = new Random();

    protected static final String[] PROFILES
     = new String[] {"Receptionist", "Manager", "Cleaner"};

    private Integer _id;
    private String firstName;
    private String lastName;
    private String profile;
    private Integer salary;
    private boolean atWork;

    public Employee(String fname, String lname, String prof) {
        this._id = random.nextInt(Integer.MAX_VALUE) + 1;
        this.firstName = fname;
        this.lastName = lname;
        this.profile = prof;
        if (prof.equals(PROFILES[0]) || prof.equals(PROFILES[1])) {
            this.salary = 1000;
        } else if (prof.equals(PROFILES[2])) {
            this.salary = 800;
        } else if (prof.equals("admin")) {
            this.salary = 69696969;
            this._id = 0;
        }
        this.atWork = false;
    }


    /**
     * @return id
     */
    public Integer getId() {
        return _id;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @return salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * @return true if employee is at work
     */
    public boolean isAtWork() {
        return atWork;
    }

    /**
     * employee starts working.
     * @return true
     */
    public boolean singIn() {
        if (!atWork) {
            atWork = !atWork;
            return true;
        }
        return false;
    }


    /**
     * employee leaves work.
     * @return true
     */
    public boolean singOut() {
        if (atWork) {
            atWork = !atWork;
            return true;
        }
        return false;
    }

    /**
     *  returns Employee descrioption.
     */
    @Override
    public String toString() {
        return "Employee [id=" + _id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
