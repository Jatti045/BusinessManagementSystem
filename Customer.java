public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;


    //Constructor
    public Customer(int customerID, String firstName, String lastName, String phone, String email) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    //Getters
    public int getCustomerID(){
        return this.customerID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phone;
    }

    public String getEmail(){
        return this.email;
    }



    //Setters
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Customer: {" +
                "ID='" + customerID + "', " +
                "First Name='" + firstName + "', " +
                "Surname='" + lastName + "', " +
                "Phone='" + phone + "', " +
                "Email='" + email + "'" +
                '}';
    }
}
