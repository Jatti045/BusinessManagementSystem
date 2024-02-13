import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    final Map<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer addCustomer) {
        customerMap.put(addCustomer.getCustomerID(), addCustomer);
        System.out.println();
        System.out.println("Customer Successfully Added.");
    }

    public void removeCustomer(int removeCustomer) {
        if(customerMap.containsKey(removeCustomer)) {
            customerMap.remove(removeCustomer);
            System.out.println();
            System.out.println("Customer Successfully Removed.");
        } else {
            System.out.println();
            System.out.println("A Customer With This ID Does Not Exist.");
        }

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



