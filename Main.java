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
                    System.out.println("\nInvalid Input. Please Enter An Appropriate Value.\n");
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
                    System.out.print("\nInvalid Input. Please Enter An Appropriate Value (1/2/3/4/5).\n");
                    break;
            }
        }
    }
    private static void addCustomer(Scanner scanner, CustomerManager manager) {
        int ID = -1;
        while (true) {
            System.out.print("Enter Customer ID: ");
            if (scanner.hasNextInt()) {
                ID = scanner.nextInt();
                scanner.nextLine();
                if (manager.customerMap.containsKey(ID)) {
                    System.out.println("\nA Customer With This ID Already Exists.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid Input. Customer ID Must Be An Integer.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter Customer First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Customer Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(ID, firstName, lastName, email);
        manager.addCustomer(customer);
    }

    private static void removeCustomer(Scanner scanner, CustomerManager manager) {
        int ID;
        while (true) {
            System.out.print("Enter The ID Of The Customer You Would Like To Remove: ");
            if (scanner.hasNextInt()) {
                ID = scanner.nextInt();
                scanner.nextLine();

                if (manager.customerMap.containsKey(ID)) {
                    manager.removeCustomer(ID);
                } else {
                    System.out.println("\nA Customer With This ID Does Not Exist.\n");
                    break;
                }
            } else {
                System.out.println("Invalid Input. Customer ID Must Be An Integer.");
                scanner.nextLine();
                break;
            }
        }
    }

    private static void updateCustomer(Scanner scanner, CustomerManager manager) {
        System.out.print("Enter The ID Of The Customer You Would Like To Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Customer First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Customer Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();

        Customer updatedCustomer = new Customer(id, firstName, lastName, email);
        manager.updateCustomer(updatedCustomer);
    }

    private static void validateCustomerId() {

    }
}
