import java.util.Scanner;
import java.util.HashSet;

public class DuplicateNumberFinder {

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

        HashSet<Integer> seenNumbers = new HashSet<>();
        HashSet<Integer> duplicateNumbers = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (seenNumbers.contains(numbers[i])) {
                duplicateNumbers.add(numbers[i]);
            } else {
                seenNumbers.add(numbers[i]);
            }
        }

        System.out.println("\n----- Duplicate Number Report -----");

        System.out.println("Numbers entered:");

        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        if (duplicateNumbers.isEmpty()) {
            System.out.println("\nNo duplicate numbers found.");
        } else {
            System.out.println("\nDuplicate numbers:");

            for (int number : duplicateNumbers) {
                System.out.println(number);
            }
        }

        sc.close();
    }
}