import java.util.Scanner;
import java.util.ArrayList;

public class ToDoListManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n----- To-Do List Manager -----");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter task: ");
                String task = sc.nextLine();

                tasks.add(task);

                System.out.println("Task added successfully.");

            } else if (choice == 2) {

                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    System.out.println("\n----- Your Tasks -----");

                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }

            } else if (choice == 3) {

                if (tasks.isEmpty()) {
                    System.out.println("No tasks available to update.");
                } else {
                    System.out.print("Enter task number to update: ");
                    int taskNumber = sc.nextInt();
                    sc.nextLine();

                    if (taskNumber < 1 || taskNumber > tasks.size()) {
                        System.out.println("Invalid task number.");
                    } else {
                        System.out.print("Enter new task: ");
                        String newTask = sc.nextLine();

                        tasks.set(taskNumber - 1, newTask);

                        System.out.println("Task updated successfully.");
                    }
                }

            } else if (choice == 4) {

                if (tasks.isEmpty()) {
                    System.out.println("No tasks available to delete.");
                } else {
                    System.out.print("Enter task number to delete: ");
                    int taskNumber = sc.nextInt();
                    sc.nextLine();

                    if (taskNumber < 1 || taskNumber > tasks.size()) {
                        System.out.println("Invalid task number.");
                    } else {
                        String removedTask = tasks.remove(taskNumber - 1);

                        System.out.println("Deleted Task: " + removedTask);
                    }
                }

            } else if (choice == 5) {

                if (tasks.isEmpty()) {
                    System.out.println("No tasks available to search.");
                } else {
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine().toLowerCase();

                    boolean found = false;

                    System.out.println("\n----- Search Results -----");

                    for (int i = 0; i < tasks.size(); i++) {
                        if (tasks.get(i).toLowerCase().contains(keyword)) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching task found.");
                    }
                }

            } else if (choice == 6) {

                System.out.println("Exiting To-Do List Manager...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 6);

        sc.close();
    }
}