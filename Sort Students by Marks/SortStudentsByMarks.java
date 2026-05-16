import java.util.Scanner;
import java.util.ArrayList;

public class SortStudentsByMarks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n----- Sort Students by Marks -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Sort by Marks High to Low");
            System.out.println("4. Sort by Marks Low to High");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter marks: ");
                int studentMarks = sc.nextInt();
                sc.nextLine();

                if (studentMarks < 0 || studentMarks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                } else {
                    studentNames.add(name);
                    marks.add(studentMarks);
                    System.out.println("Student added successfully.");
                }

            } else if (choice == 2) {

                if (studentNames.isEmpty()) {
                    System.out.println("No students available.");
                } else {
                    System.out.println("\n----- Student List -----");

                    for (int i = 0; i < studentNames.size(); i++) {
                        System.out.println((i + 1) + ". " + studentNames.get(i) + " - Marks: " + marks.get(i));
                    }
                }

            } else if (choice == 3) {

                if (studentNames.isEmpty()) {
                    System.out.println("No students available to sort.");
                } else {

                    for (int i = 0; i < marks.size() - 1; i++) {
                        for (int j = 0; j < marks.size() - i - 1; j++) {

                            if (marks.get(j) < marks.get(j + 1)) {

                                int tempMarks = marks.get(j);
                                marks.set(j, marks.get(j + 1));
                                marks.set(j + 1, tempMarks);

                                String tempName = studentNames.get(j);
                                studentNames.set(j, studentNames.get(j + 1));
                                studentNames.set(j + 1, tempName);
                            }
                        }
                    }

                    System.out.println("\nStudents sorted from high marks to low marks.");

                    for (int i = 0; i < studentNames.size(); i++) {
                        System.out.println((i + 1) + ". " + studentNames.get(i) + " - Marks: " + marks.get(i));
                    }
                }

            } else if (choice == 4) {

                if (studentNames.isEmpty()) {
                    System.out.println("No students available to sort.");
                } else {

                    for (int i = 0; i < marks.size() - 1; i++) {
                        for (int j = 0; j < marks.size() - i - 1; j++) {

                            if (marks.get(j) > marks.get(j + 1)) {

                                int tempMarks = marks.get(j);
                                marks.set(j, marks.get(j + 1));
                                marks.set(j + 1, tempMarks);

                                String tempName = studentNames.get(j);
                                studentNames.set(j, studentNames.get(j + 1));
                                studentNames.set(j + 1, tempName);
                            }
                        }
                    }

                    System.out.println("\nStudents sorted from low marks to high marks.");

                    for (int i = 0; i < studentNames.size(); i++) {
                        System.out.println((i + 1) + ". " + studentNames.get(i) + " - Marks: " + marks.get(i));
                    }
                }

            } else if (choice == 5) {

                if (studentNames.isEmpty()) {
                    System.out.println("No students available to search.");
                } else {
                    System.out.print("Enter student name to search: ");
                    String searchName = sc.nextLine().toLowerCase();

                    boolean found = false;

                    System.out.println("\n----- Search Result -----");

                    for (int i = 0; i < studentNames.size(); i++) {
                        if (studentNames.get(i).toLowerCase().contains(searchName)) {
                            System.out.println("Student Found");
                            System.out.println("Name: " + studentNames.get(i));
                            System.out.println("Marks: " + marks.get(i));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                }

            } else if (choice == 6) {

                System.out.println("Exiting Sort Students by Marks...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 6);

        sc.close();
    }
}