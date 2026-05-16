import java.util.Scanner;

public class StudentRollNumberFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of students must be greater than 0.");
            sc.close();
            return;
        }

        String[] studentNames = new String[n];
        int[] rollNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Enter student name: ");
            studentNames[i] = sc.nextLine();

            System.out.print("Enter roll number: ");
            rollNumbers[i] = sc.nextInt();
            sc.nextLine();
        }

        System.out.print("\nEnter roll number to search: ");
        int searchRollNumber = sc.nextInt();

        boolean found = false;
        int foundIndex = -1;

        for (int i = 0; i < n; i++) {
            if (rollNumbers[i] == searchRollNumber) {
                found = true;
                foundIndex = i;
                break;
            }
        }

        System.out.println("\n----- Search Result -----");

        if (found) {
            System.out.println("Student Found");
            System.out.println("Name: " + studentNames[foundIndex]);
            System.out.println("Roll Number: " + rollNumbers[foundIndex]);
            System.out.println("Position: " + (foundIndex + 1));
            System.out.println("Array Index: " + foundIndex);
        } else {
            System.out.println("No student found with roll number " + searchRollNumber);
        }

        sc.close();
    }
}