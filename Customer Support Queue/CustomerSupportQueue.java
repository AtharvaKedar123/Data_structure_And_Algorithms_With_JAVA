import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class CustomerSupportQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<String> supportQueue = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n----- Customer Support Queue -----");
            System.out.println("1. Add Customer Request");
            System.out.println("2. Serve Next Customer");
            System.out.println("3. View Next Customer");
            System.out.println("4. View All Waiting Customers");
            System.out.println("5. Check Total Waiting Customers");
            System.out.println("6. Clear Queue");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter customer name: ");
                String customerName = sc.nextLine();

                System.out.print("Enter issue/problem: ");
                String issue = sc.nextLine();

                String request = customerName + " - " + issue;

                supportQueue.add(request);

                System.out.println("Customer request added successfully.");

            } else if (choice == 2) {

                if (supportQueue.isEmpty()) {
                    System.out.println("No customer requests available.");
                } else {
                    String servedCustomer = supportQueue.poll();

                    System.out.println("Now serving: " + servedCustomer);
                    System.out.println("Customer request resolved.");
                }

            } else if (choice == 3) {

                if (supportQueue.isEmpty()) {
                    System.out.println("No customer requests available.");
                } else {
                    System.out.println("Next customer: " + supportQueue.peek());
                }

            } else if (choice == 4) {

                if (supportQueue.isEmpty()) {
                    System.out.println("No customers waiting.");
                } else {
                    System.out.println("\n----- Waiting Customers -----");

                    int position = 1;

                    for (String request : supportQueue) {
                        System.out.println(position + ". " + request);
                        position++;
                    }
                }

            } else if (choice == 5) {

                System.out.println("Total waiting customers: " + supportQueue.size());

            } else if (choice == 6) {

                supportQueue.clear();

                System.out.println("Customer support queue cleared.");

            } else if (choice == 7) {

                System.out.println("Exiting Customer Support Queue...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);

        sc.close();
    }
}