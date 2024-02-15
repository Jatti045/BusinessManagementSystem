import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.GsonBuilder;


public class CustomerManager {

    Map<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer addCustomer) {
        customerMap.put(addCustomer.getCustomerID(), addCustomer);
        System.out.println();
        System.out.println("Customer Successfully Added.");
    }

    public void removeCustomer(int removeCustomer) {
        customerMap.remove(removeCustomer);
        System.out.println("\nCustomer Successfully Removed.");


    }
    public void updateCustomer(Customer updatedCustomer) {
        customerMap.put(updatedCustomer.getCustomerID(), updatedCustomer);
        System.out.println();
        System.out.println("Customer Updated Successfully.");
    }

    public void listCustomers() {
            System.out.println();
            customerMap.values().forEach(System.out::println);
    }

    public Customer getCustomerById(int id) {
        return null;
        //Write Program;
    }
    public void saveDataToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(customerMap, writer);
            System.out.println("\nSaving Existing Data...\n");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadDataFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            TypeToken<Map<Integer, Customer>> typeToken = new TypeToken<>() {};
            customerMap = gson.fromJson(reader, typeToken);
            System.out.println("\nData Successfully Loaded.\n");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}


