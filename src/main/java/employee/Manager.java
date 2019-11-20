package employee;

public class Manager extends Employee {

    /**
     *  returns Employee descrioption.
     */
    @Override
    public String toString() {
        return "Manager [details: " +  super.toString() + "]";
    }
}
