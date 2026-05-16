import java.util.Scanner;
import java.util.HashMap;

public class FrequencyOfNumbersApp {

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

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (frequencyMap.containsKey(numbers[i])) {
                frequencyMap.put(numbers[i], frequencyMap.get(numbers[i]) + 1);
            } else {
                frequencyMap.put(numbers[i], 1);
            }
        }

        System.out.println("\n----- Number Frequency Report -----");

        System.out.println("\nNumbers entered:");

        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\n\nFrequency of each number:");

        for (int number : frequencyMap.keySet()) {
            System.out.println(number + " appears " + frequencyMap.get(number) + " time(s)");
        }

        sc.close();
    }
}