package employee;

public class Employee {

    private static final String[] PROFILES
     = new String[] {"Receptionist", "Manager", "Cleaner"};

    private Short id;
    private String firstName;
    private String lastName;
    private String profile;
    private Integer salary;
    private boolean atWork;


    /**
     * @return id
     */
    public Short getId() {
        return id;
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
         + id + ", firstName="
          + firstName + ", lastName="
           + lastName + "]";
    }
}
