import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class RecentCallsTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<String> recentCalls = new Stack<>();
        Queue<String> callQueue = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n----- Recent Calls Tracker -----");
            System.out.println("1. Add Recent Call");
            System.out.println("2. View Most Recent Call");
            System.out.println("3. Delete Most Recent Call");
            System.out.println("4. View All Recent Calls");
            System.out.println("5. Add Call to Waiting Queue");
            System.out.println("6. Answer Next Waiting Call");
            System.out.println("7. View Waiting Calls");
            System.out.println("8. Clear All Calls");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter caller name: ");
                String callerName = sc.nextLine();

                System.out.print("Enter phone number: ");
                String phoneNumber = sc.nextLine();

                String callDetails = callerName + " - " + phoneNumber;

                recentCalls.push(callDetails);

                System.out.println("Recent call added successfully.");

            } else if (choice == 2) {

                if (recentCalls.isEmpty()) {
                    System.out.println("No recent calls available.");
                } else {
                    System.out.println("Most recent call: " + recentCalls.peek());
                }

            } else if (choice == 3) {

                if (recentCalls.isEmpty()) {
                    System.out.println("No recent calls to delete.");
                } else {
                    String deletedCall = recentCalls.pop();

                    System.out.println("Deleted recent call: " + deletedCall);
                }

            } else if (choice == 4) {

                if (recentCalls.isEmpty()) {
                    System.out.println("No recent calls available.");
                } else {
                    System.out.println("\n----- Recent Calls -----");

                    int position = 1;

                    for (int i = recentCalls.size() - 1; i >= 0; i--) {
                        System.out.println(position + ". " + recentCalls.get(i));
                        position++;
                    }
                }

            } else if (choice == 5) {

                System.out.print("Enter caller name: ");
                String callerName = sc.nextLine();

                System.out.print("Enter phone number: ");
                String phoneNumber = sc.nextLine();

                String callDetails = callerName + " - " + phoneNumber;

                callQueue.add(callDetails);

                System.out.println("Call added to waiting queue.");

            } else if (choice == 6) {

                if (callQueue.isEmpty()) {
                    System.out.println("No waiting calls available.");
                } else {
                    String answeredCall = callQueue.poll();

                    System.out.println("Answering call: " + answeredCall);

                    recentCalls.push(answeredCall);

                    System.out.println("Call added to recent calls.");
                }

            } else if (choice == 7) {

                if (callQueue.isEmpty()) {
                    System.out.println("No waiting calls available.");
                } else {
                    System.out.println("\n----- Waiting Calls -----");

                    int position = 1;

                    for (String call : callQueue) {
                        System.out.println(position + ". " + call);
                        position++;
                    }
                }

            } else if (choice == 8) {

                recentCalls.clear();
                callQueue.clear();

                System.out.println("All recent and waiting calls cleared.");

            } else if (choice == 9) {

                System.out.println("Exiting Recent Calls Tracker...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 9);

        sc.close();
    }
}