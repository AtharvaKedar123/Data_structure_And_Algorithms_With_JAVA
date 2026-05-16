import java.util.Scanner;
import java.util.ArrayList;

public class BinarySearchNumberFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n----- Binary Search Number Finder -----");
            System.out.println("1. Add Number");
            System.out.println("2. View Numbers");
            System.out.println("3. Sort Numbers");
            System.out.println("4. Search Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter number: ");
                int number = sc.nextInt();

                numbers.add(number);

                System.out.println("Number added successfully.");

            } else if (choice == 2) {

                if (numbers.isEmpty()) {
                    System.out.println("No numbers available.");
                } else {
                    System.out.println("\n----- Numbers -----");

                    for (int i = 0; i < numbers.size(); i++) {
                        System.out.println((i + 1) + ". " + numbers.get(i));
                    }
                }

            } else if (choice == 3) {

                if (numbers.isEmpty()) {
                    System.out.println("No numbers available to sort.");
                } else {

                    for (int i = 0; i < numbers.size() - 1; i++) {
                        for (int j = 0; j < numbers.size() - i - 1; j++) {

                            if (numbers.get(j) > numbers.get(j + 1)) {

                                int temp = numbers.get(j);
                                numbers.set(j, numbers.get(j + 1));
                                numbers.set(j + 1, temp);
                            }
                        }
                    }

                    System.out.println("Numbers sorted successfully.");

                    System.out.println("\nSorted Numbers:");

                    for (int i = 0; i < numbers.size(); i++) {
                        System.out.println((i + 1) + ". " + numbers.get(i));
                    }
                }

            } else if (choice == 4) {

                if (numbers.isEmpty()) {
                    System.out.println("No numbers available to search.");
                } else {

                    for (int i = 0; i < numbers.size() - 1; i++) {
                        for (int j = 0; j < numbers.size() - i - 1; j++) {

                            if (numbers.get(j) > numbers.get(j + 1)) {

                                int temp = numbers.get(j);
                                numbers.set(j, numbers.get(j + 1));
                                numbers.set(j + 1, temp);
                            }
                        }
                    }

                    System.out.print("Enter number to search: ");
                    int searchNumber = sc.nextInt();

                    int left = 0;
                    int right = numbers.size() - 1;
                    int foundIndex = -1;

                    while (left <= right) {

                        int mid = left + (right - left) / 2;

                        if (numbers.get(mid) == searchNumber) {
                            foundIndex = mid;
                            break;
                        } else if (numbers.get(mid) < searchNumber) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }

                    System.out.println("\n----- Search Result -----");

                    if (foundIndex != -1) {
                        System.out.println(searchNumber + " found.");
                        System.out.println("Sorted Position: " + (foundIndex + 1));
                        System.out.println("ArrayList Index: " + foundIndex);
                    } else {
                        System.out.println(searchNumber + " not found.");
                    }
                }

            } else if (choice == 5) {

                System.out.println("Exiting Binary Search Number Finder...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 5);

        sc.close();
    }
}