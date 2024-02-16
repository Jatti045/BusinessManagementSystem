import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main extends CustomerManager {
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);

        manager.loadDataFromFile("Customers.JSON");

        while (true) {
            System.out.println("\n=== Customer Management System ===\n");
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
                    System.out.print("\nInvalid option selected. Please enter a number between 1 and 5.\n");
                    break;
            }
        }
    }

    private static void addCustomer(Scanner scanner, CustomerManager manager) {

        int ID = getValidID(manager);

        String promtFirstName = "Enter Customer First Name: ";
        String promptFirstNameError = "The first name entered is not valid. Please try again.";
        String firstName = getValidString(promtFirstName, promptFirstNameError);

        String promptSurname = "Enter Customer Surname: ";
        String promptSurnameError = "The surname entered is not valid. Please try again.";
        String lastName = getValidString(promptSurname, promptSurnameError);

        String phone = getValidPhone();

        String email = getValidEmail();

        Customer customer = new Customer(ID, firstName, lastName, phone, email);

        manager.addCustomer(customer);
    }

    private static void removeCustomer(Scanner scanner, CustomerManager manager) {
        int ID;
        while (true) {
            System.out.print("\nEnter the ID of the customer you would like to remove: ");
            if (scanner.hasNextInt()) {
                ID = scanner.nextInt();
                scanner.nextLine();

                if (manager.customerMap.containsKey(ID)) {
                    manager.removeCustomer(ID);
                    break;
                } else {
                    System.out.println("\nA customer with this ID does not exist.");
                    break;
                }
            } else {
                System.out.println("The input is incorrect. The Customer ID must be a whole number. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    //Under Build

    private static void updateCustomer(Scanner scanner, CustomerManager manager) {

        int id;
        while(true) {
            System.out.print("\nEnter the ID of the customer you would like to update: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("\nThe input is incorrect. Please enter a valid customer ID.\n");
                scanner.nextLine();
            }
        }

        Customer existingCustomer = manager.getCustomerById(id);
        if (existingCustomer == null) {
            System.out.println("\nCustomer with ID " + id + " does not exist.\n");
            return;
        }

        String firstName = null;
        while(true) {
            System.out.print("Enter Customer First Name (leave blank to keep current name): ");
            String input = scanner.nextLine();

            if(input.matches("[a-zA-Z]+")) {
                firstName = input;
                break;
            } else if (input.isEmpty()) {
                firstName = existingCustomer.getFirstName();
                break;
            } else {
                System.out.println("The first name entered is not valid. Please try again.");
            }
        }

        String lastName = null;
        while(true) {
            System.out.print("Enter Customer Surname (leave blank to keep current surname): ");
            String input = scanner.nextLine();

            if(input.matches("[a-zA-Z]+")) {
                lastName = input;
                break;
            } else if (input.isEmpty()) {
                lastName = existingCustomer.getLastName();
                break;
            } else {
                System.out.println("The surname entered is not valid. Please try again.");
            }
        }

        String phone = null;
        while(true) {
            System.out.print("Enter Customer Phone number In The Format xxx-xxx-xxxx (leave blank to keep current phone number): ");
            String input = scanner.nextLine();

            if(input.matches("^\\d{3}-\\d{3}-\\d{4}$")){
                phone = input;
                break;
            } else if (input.isEmpty()) {
                phone = existingCustomer.getPhoneNumber();
                break;
            } else {
                System.out.println("The phone number entered is invalid. Please enter a phone number in the correct format and try again.");
            }
        }


        String email = null;
        while(true) {
            System.out.print("Enter Customer Email (leave blank to keep current email): ");
            email = scanner.nextLine();

            if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
                break;
            } else if (email.isEmpty()) {
                email = existingCustomer.getEmail();
                break;
            } else {
                System.out.println("The email address entered is invalid. Please enter a valid email address and try again.");
            }
        }

        Customer updatedCustomer = new Customer(id, firstName, lastName, phone, email);
        manager.updateCustomer(updatedCustomer);
    }

    public static int operation() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("Please select the operation you would like to perform by choosing a number from the following options (1, 2, 3, 4, 5): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                System.out.println("\nThe input provided is incorrect. Please enter a valid value.\n");
                scanner.nextLine();
            }
        }
    }
    public static int getValidID(CustomerManager manager) {

        Scanner scanner = new Scanner(System.in);

        int ID = -1;
        while (true) {
            System.out.print("Enter Customer ID: ");
            if (scanner.hasNextInt()) {
                ID = scanner.nextInt();
                scanner.nextLine();
                if (manager.customerMap.containsKey(ID)) {
                    System.out.println("\nA customer with this ID already exists.\n");
                } else {
                    return ID;
                }
            } else {
                System.out.println("The customer ID entered is invalid. Please enter a correct customer ID and try again.");
                scanner.nextLine();
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

    public static String getValidPhone() {
        Scanner scanner = new Scanner(System.in);
        final String PHONE_PATTERN = "^\\d{3}-\\d{3}-\\d{4}$";

        while(true) {
            System.out.print("Enter Customer Phone Number In The Format xxx-xxx-xxxx: ");
            String phone = scanner.nextLine();
            Pattern pattern = Pattern.compile(PHONE_PATTERN);
            Matcher matcher = pattern.matcher(phone);

            if(matcher.matches()) {
                return phone;
            } else {
                System.out.println("The phone number entered is invalid. Please enter a phone number in the correct format and try again.");
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
                System.out.println("The email address entered is invalid. Please enter a valid email address and try again.");
            }
        }
    }
}
