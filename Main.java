import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main extends CustomerManager {
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);

        manager.loadDataFromFile("Customers.JSON");

        while (true) {
            System.out.println("\nCustomer Management System\n");
            System.out.println("1. Add Customer\n2. Remove Customer\n3. Update Customer\n4. List Customers\n5. Save And Exit\n");

            int choice = operation();

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
                    manager.saveDataToFile("Customers.JSON");
                    System.exit(0);
                    break;
                default:
                    System.out.print("\nInvalid Input.\n");
                    break;
            }
        }
    }

    private static void addCustomer(Scanner scanner, CustomerManager manager) {

        int ID = getValidID();

        String promtFirstName = "Enter Customer First Name: ";
        String promptFirstNameError = "Invalid FirstName. Please Try Again.";
        String firstName = getValidString(promtFirstName, promptFirstNameError);

        String promptSurname = "Enter Customer Surname: ";
        String promptSurnameError = "Invalid Surname. Please Try Again.";
        String lastName = getValidString(promptSurname, promptSurnameError);

        String email = getValidEmail();

        Customer customer = new Customer(ID, firstName, lastName, email);

        manager.addCustomer(customer);
    }

    private static void removeCustomer(Scanner scanner, CustomerManager manager) {
        int ID;
        while (true) {
            System.out.print("\nEnter The ID Of The Customer You Would Like To Remove: ");
            if (scanner.hasNextInt()) {
                ID = scanner.nextInt();
                scanner.nextLine();

                if (manager.customerMap.containsKey(ID)) {
                    manager.removeCustomer(ID);
                    break;
                } else {
                    System.out.println("\nA Customer With This ID Does Not Exist.");
                    break;
                }
            } else {
                System.out.println("Invalid Input. Customer ID Must Be An Integer.");
                scanner.nextLine();
            }
        }
    }

    //Under Build

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

    public static int operation() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("Which Operation Would You Like To Perform (1/2/3/4/5): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                System.out.println("\nInvalid Input. Please Enter An Appropriate Value.\n");
                scanner.nextLine();
            }
        }
    }

    public static int getValidID() {

        Scanner scanner = new Scanner(System.in);
        CustomerManager manager = new CustomerManager();

        int ID = -1;
        while (true) {
            System.out.print("Enter Customer ID: ");
            if (scanner.hasNextInt()) {
                ID = scanner.nextInt();
                scanner.nextLine();
                if (manager.customerMap.containsKey(ID)) {
                    System.out.println("\nA Customer With This ID Already Exists.\n");
                } else {
                    return ID;
                }
            } else {
                System.out.println("Invalid Customer ID. Please Try Again.");
                scanner.nextLine();
            }
        }
    }

    public static String getValidEmail() {
        Scanner scanner = new Scanner(System.in);
        final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        while(true) {
            System.out.print("Enter Customer Email: ");
            String email = scanner.nextLine();
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);

            if(matcher.matches()) {
                return email;
            } else {
                System.out.println("Invalid Email. Please try again.");
            }
        }
    }

    public static String getValidString(String prompt, String promptError) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            final String IS_VALID = "[a-zA-Z]+";

            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input.matches(IS_VALID)) {
                return input;
            } else {
                System.out.println(promptError);
            }
        }
    }
}
