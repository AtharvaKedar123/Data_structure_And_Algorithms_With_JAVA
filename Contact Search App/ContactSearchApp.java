import java.util.Scanner;

public class ContactSearchApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of contacts: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of contacts must be greater than 0.");
            sc.close();
            return;
        }

        String[] names = new String[n];
        String[] phoneNumbers = new String[n];
        String[] emails = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for contact " + (i + 1));

            System.out.print("Enter name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter phone number: ");
            phoneNumbers[i] = sc.nextLine();

            System.out.print("Enter email: ");
            emails[i] = sc.nextLine();
        }

        System.out.print("\nEnter name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;
        int foundIndex = -1;

        for (int i = 0; i < n; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                found = true;
                foundIndex = i;
                break;
            }
        }

        System.out.println("\n----- Search Result -----");

        if (found) {
            System.out.println("Contact Found");
            System.out.println("Name: " + names[foundIndex]);
            System.out.println("Phone Number: " + phoneNumbers[foundIndex]);
            System.out.println("Email: " + emails[foundIndex]);
            System.out.println("Position: " + (foundIndex + 1));
            System.out.println("Array Index: " + foundIndex);
        } else {
            System.out.println("No contact found with name: " + searchName);
        }

        sc.close();
    }
}