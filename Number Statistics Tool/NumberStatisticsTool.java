import java.util.Scanner;

public class NumberStatisticsTool {

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

        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];
        int evenCount = 0;
        int oddCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {

            sum = sum + numbers[i];

            if (numbers[i] > max) {
                max = numbers[i];
            }

            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if (numbers[i] > 0) {
                positiveCount++;
            } else if (numbers[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        double average = (double) sum / n;

        System.out.println("\n----- Number Statistics Report -----");

        System.out.println("Numbers entered:");

        for (int i = 0; i < n; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Maximum Number: " + max);
        System.out.println("Minimum Number: " + min);
        System.out.println("Even Numbers Count: " + evenCount);
        System.out.println("Odd Numbers Count: " + oddCount);
        System.out.println("Positive Numbers Count: " + positiveCount);
        System.out.println("Negative Numbers Count: " + negativeCount);
        System.out.println("Zero Count: " + zeroCount);

        sc.close();
    }
}