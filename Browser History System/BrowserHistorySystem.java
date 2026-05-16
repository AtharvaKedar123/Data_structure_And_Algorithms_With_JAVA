import java.util.Scanner;
import java.util.Stack;

public class BrowserHistorySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();

        String currentPage = "Home";

        int choice;

        do {
            System.out.println("\n----- Browser History System -----");
            System.out.println("Current Page: " + currentPage);
            System.out.println("1. Visit New Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. View Back History");
            System.out.println("5. View Forward History");
            System.out.println("6. Clear History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter page URL/name: ");
                String newPage = sc.nextLine();

                backStack.push(currentPage);
                currentPage = newPage;
                forwardStack.clear();

                System.out.println("Visited: " + currentPage);

            } else if (choice == 2) {

                if (backStack.isEmpty()) {
                    System.out.println("No previous page available.");
                } else {
                    forwardStack.push(currentPage);
                    currentPage = backStack.pop();

                    System.out.println("Moved back to: " + currentPage);
                }

            } else if (choice == 3) {

                if (forwardStack.isEmpty()) {
                    System.out.println("No forward page available.");
                } else {
                    backStack.push(currentPage);
                    currentPage = forwardStack.pop();

                    System.out.println("Moved forward to: " + currentPage);
                }

            } else if (choice == 4) {

                if (backStack.isEmpty()) {
                    System.out.println("Back history is empty.");
                } else {
                    System.out.println("\n----- Back History -----");

                    for (int i = backStack.size() - 1; i >= 0; i--) {
                        System.out.println(backStack.get(i));
                    }
                }

            } else if (choice == 5) {

                if (forwardStack.isEmpty()) {
                    System.out.println("Forward history is empty.");
                } else {
                    System.out.println("\n----- Forward History -----");

                    for (int i = forwardStack.size() - 1; i >= 0; i--) {
                        System.out.println(forwardStack.get(i));
                    }
                }

            } else if (choice == 6) {

                backStack.clear();
                forwardStack.clear();

                System.out.println("Browser history cleared.");

            } else if (choice == 7) {

                System.out.println("Exiting Browser History System...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);

        sc.close();
    }
}