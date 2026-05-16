import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class PrinterJobScheduler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<String> printQueue = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n----- Printer Job Scheduler -----");
            System.out.println("1. Add Print Job");
            System.out.println("2. Print Next Job");
            System.out.println("3. View Next Job");
            System.out.println("4. View All Print Jobs");
            System.out.println("5. Check Total Jobs");
            System.out.println("6. Clear All Jobs");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter document name: ");
                String documentName = sc.nextLine();

                printQueue.add(documentName);

                System.out.println("Print job added: " + documentName);

            } else if (choice == 2) {

                if (printQueue.isEmpty()) {
                    System.out.println("No print jobs available.");
                } else {
                    String printedJob = printQueue.poll();

                    System.out.println("Printing document: " + printedJob);
                    System.out.println("Print completed.");
                }

            } else if (choice == 3) {

                if (printQueue.isEmpty()) {
                    System.out.println("No print jobs available.");
                } else {
                    System.out.println("Next document to print: " + printQueue.peek());
                }

            } else if (choice == 4) {

                if (printQueue.isEmpty()) {
                    System.out.println("Print queue is empty.");
                } else {
                    System.out.println("\n----- Pending Print Jobs -----");

                    int position = 1;

                    for (String job : printQueue) {
                        System.out.println(position + ". " + job);
                        position++;
                    }
                }

            } else if (choice == 5) {

                System.out.println("Total pending print jobs: " + printQueue.size());

            } else if (choice == 6) {

                printQueue.clear();

                System.out.println("All print jobs cleared.");

            } else if (choice == 7) {

                System.out.println("Exiting Printer Job Scheduler...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);

        sc.close();
    }
}