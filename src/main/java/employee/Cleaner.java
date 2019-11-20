package employee;

public class Cleaner extends Employee {

    /**
     *  returns Employee descrioption.
     */
    @Override
    public String toString() {
        return "Cleaner [details: " +  super.toString() + "]";
    }
}
