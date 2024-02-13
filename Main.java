import java.util.Scanner;

public class Main extends CustomerManager {
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCustomer Management System\n");
            System.out.println("1. Add Customer\n2. Remove Customer\n3. Update Customer\n4. List Customers\n5. Exit");
            System.out.println();

            int choice;

            while(true) {
                System.out.print("Which Operation Would You Like To Perform (1/2/3/4/5): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println();
                    System.out.println("Invalid Input. Please Enter An Appropriate Value.");
                    System.out.println();
                    scanner.nextLine();
                }
            }


            switch (choice) {
                case 1:
                    addCustomer(scanner, manager);
                    break;
                case 2:
                    removeCustomer(scanner, manager);
                    break;
                case 3:
                    updateCustomer(scanner, manager);
                    break;
                case 4:
                    manager.listCustomers();
                    break;
                case 5:
                    System.out.println("Saving Existing Data...");
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.print("Invalid Input. Please Enter An Appropriate Value (1/2/3/4/5).");
                    System.out.println();
                    break;
            }
        }
    }
    private static void addCustomer(Scanner scanner, CustomerManager manager) {
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(id, firstName, lastName, email);
        manager.addCustomer(customer);
    }

    private static void removeCustomer(Scanner scanner, CustomerManager manager) {
        System.out.print("Enter The ID Of The Customer You Would Like To Remove: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        manager.removeCustomer(ID);
    }

    private static void updateCustomer(Scanner scanner, CustomerManager manager) {
        System.out.print("Enter The ID Of The Customer You Would Like To Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Customer updatedCustomer = new Customer(id, firstName, lastName, email);
        manager.updateCustomer(updatedCustomer);
    }
}
