import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    private Map<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer addCustomer) {
        customerMap.put(addCustomer.getCustomerID(), addCustomer);
        System.out.println("Customer Successfully Added.");
    }

    public void removeCustomer(Customer removeCustomer) {
        customerMap.remove(removeCustomer.getCustomerID());
        System.out.println("Customer Successfully Removed.");
    }

    public void updateCustomer(Customer updatedCustomer) {
        customerMap.put(updatedCustomer.getCustomerID(), updatedCustomer);
        System.out.println("Customer Updated Successfully.");
    }

    public Customer findCustomer(int customerID) {
        return customerMap.get(customerID);
    }

    public void listCustomers() {
        customerMap.values().forEach(System.out::println);
    }
}



