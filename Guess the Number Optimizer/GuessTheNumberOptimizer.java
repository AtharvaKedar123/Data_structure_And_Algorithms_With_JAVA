import java.util.Scanner;

public class GuessTheNumberOptimizer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        int attempts = 0;

        System.out.println("----- Guess The Number Optimizer -----");
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it using Binary Search.");
        System.out.println("Reply with:");
        System.out.println("1 = Correct Guess");
        System.out.println("2 = Your number is Higher");
        System.out.println("3 = Your number is Lower");

        while (low <= high) {

            int mid = low + (high - low) / 2;
            attempts++;

            System.out.println("\nMy guess is: " + mid);
            System.out.print("Enter your response: ");
            int response = sc.nextInt();

            if (response == 1) {

                System.out.println("\nI guessed your number correctly!");
                System.out.println("Number: " + mid);
                System.out.println("Attempts used: " + attempts);
                break;

            } else if (response == 2) {

                low = mid + 1;

            } else if (response == 3) {

                high = mid - 1;

            } else {

                System.out.println("Invalid response. Please enter 1, 2, or 3.");
                attempts--;
            }

            if (low > high) {
                System.out.println("\nYour answers were inconsistent.");
                System.out.println("No valid number exists in the remaining range.");
            }
        }

        sc.close();
    }
}