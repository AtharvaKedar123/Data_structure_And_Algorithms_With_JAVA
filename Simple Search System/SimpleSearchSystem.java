import java.util.Scanner;

public class SimpleSearchSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number count must be greater than 0.");
            sc.close();
            return;
        }

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.print("\nEnter number to search: ");
        int searchNumber = sc.nextInt();

        boolean found = false;
        int position = -1;

        for (int i = 0; i < n; i++) {
            if (numbers[i] == searchNumber) {
                found = true;
                position = i;
                break;
            }
        }

        System.out.println("\n----- Search Result -----");

        if (found) {
            System.out.println(searchNumber + " found at position " + (position + 1));
            System.out.println("Array index: " + position);
        } else {
            System.out.println(searchNumber + " not found in the list.");
        }

        sc.close();
    }
}