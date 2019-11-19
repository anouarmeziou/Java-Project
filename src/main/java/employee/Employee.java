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



    public Short getId() {
        return id;
    }

    public boolean isAtWork() {
        return atWork == true;
    }

    public boolean startWork() {
        if !(atWork) {
            atWork = !atWork;
            return true;
        }
        return false;
    }

    public boolean finishWork() {
        if (atWork) {
            atWork = !atWork;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Employee [id="
         + id + ", firstName="
          + firstName + ", lastName="
           + lastName + "]";
    }
}
