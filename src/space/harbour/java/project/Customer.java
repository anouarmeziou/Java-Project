package space.harbour.java.project;

public class Customer {
    private String id;
    private String name;
    private String bankAcc;
    private boolean paid = false;

    public Customer(String i, String n, String b, boolean p) {
        this.bankAcc = b;
        this.id = i;
        this.name = n;
        this.paid = p;
    }

    /**
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return bankAccount
     */
    public String getBankAcc() {
        return this.id;
    }


    /**
     *
     * @return set the customer as paid
     */
    public boolean setPaid() {
        return paid=true;
    }

    /**
     *
     * @return check if the customer paid or not
     */
    public boolean getPaid() {
        return paid;
    }


    /**
     *
     * @return customer to string
     */
    public String toString() {
        return "Customer [" + "id=" + id + ", name=" + name + ", bankAcc=" + bankAcc + "]";
    }
}
