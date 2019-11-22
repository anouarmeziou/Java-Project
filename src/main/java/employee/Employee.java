package main.java.employee;

public class Employee {

    private static final String[] PROFILES
     = new String[] {"Receptionist", "Manager", "Cleaner"};

    private Integer _id;
    private String firstName;
    private String lastName;
    private String profile;
    private Integer salary;
    private boolean atWork;

    // public Employee(int id, String fname, String lname, String prof, Integer salar) {
    //     this._id = id;
    //     this.firstName = fname;
    //     this.lastName = lname;
    //     this.profile = prof;
    //     this.salary = salar;
    //     this.atWork = false;
    // }


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
    public boolean startWork() {
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
    public boolean finishWork() {
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
        return "Employee [id="
         + _id + ", firstName="
          + firstName + ", lastName="
           + lastName + "]";
    }
}
