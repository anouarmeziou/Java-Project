package employee;

public class Receptionist extends Employee {

    /**
     *  returns Employee descrioption.
     */
    @Override
    public String toString() {
        return "Receptionist [details: " +  super.toString() + "]";
    }
}
