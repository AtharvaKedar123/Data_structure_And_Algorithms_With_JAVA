import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class TicketBookingQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<String> bookingQueue = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n----- Ticket Booking Queue -----");
            System.out.println("1. Add Customer to Queue");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Next Customer");
            System.out.println("4. View All Customers");
            System.out.println("5. Check Queue Size");
            System.out.println("6. Clear Queue");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter customer name: ");
                String customerName = sc.nextLine();

                bookingQueue.add(customerName);

                System.out.println(customerName + " added to the booking queue.");

            } else if (choice == 2) {

                if (bookingQueue.isEmpty()) {
                    System.out.println("No customers in queue.");
                } else {
                    String servedCustomer = bookingQueue.poll();

                    System.out.println("Ticket booked for: " + servedCustomer);
                }

            } else if (choice == 3) {

                if (bookingQueue.isEmpty()) {
                    System.out.println("No customers in queue.");
                } else {
                    System.out.println("Next customer: " + bookingQueue.peek());
                }

            } else if (choice == 4) {

                if (bookingQueue.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    System.out.println("\n----- Customers in Queue -----");

                    int position = 1;

                    for (String customer : bookingQueue) {
                        System.out.println(position + ". " + customer);
                        position++;
                    }
                }

            } else if (choice == 5) {

                System.out.println("Total customers waiting: " + bookingQueue.size());

            } else if (choice == 6) {

                bookingQueue.clear();

                System.out.println("Queue cleared successfully.");

            } else if (choice == 7) {

                System.out.println("Exiting Ticket Booking Queue...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);

        sc.close();
    }
}