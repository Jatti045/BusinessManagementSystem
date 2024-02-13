import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    private final Map<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer addCustomer) {
        customerMap.put(addCustomer.getCustomerID(), addCustomer);
        System.out.println();
        System.out.println("Customer Successfully Added.");
    }

    public void removeCustomer(int removeCustomer) {
        customerMap.remove(removeCustomer);
        System.out.println();
        System.out.println("Customer Successfully Removed.");
    }

    public void updateCustomer(Customer updatedCustomer) {
        customerMap.put(updatedCustomer.getCustomerID(), updatedCustomer);
        System.out.println();
        System.out.println("Customer Updated Successfully.");
    }

    public void listCustomers() {
        customerMap.values().forEach(System.out::println);
    }
}



