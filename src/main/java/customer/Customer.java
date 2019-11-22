package customer;

public class Customer {
    private Integer _id;
    private String name;
    private String bankAcc;
    private boolean paid = false;


    public Customer(int i, String n, String b) {
        this.bankAcc = b;
        this._id = i;
        this.name = n;
        this.paid = false;
    }

    /**
     *
     * @return id
     */
    public Integer getId() {
        return this._id;
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
        return this.bankAcc;
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
        return "Customer [" + "id=" + _id + ", name=" + name + ", bankAcc=" + bankAcc + "]";
    }
}
