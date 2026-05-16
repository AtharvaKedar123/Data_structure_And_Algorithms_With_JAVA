import java.util.Scanner;
import java.util.HashMap;

public class SimpleDictionaryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dictionary = new HashMap<>();

        int choice;

        do {
            System.out.println("\n----- Simple Dictionary App -----");
            System.out.println("1. Add Word");
            System.out.println("2. Search Word");
            System.out.println("3. Display All Words");
            System.out.println("4. Remove Word");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter word: ");
                String word = sc.nextLine().toLowerCase();

                System.out.print("Enter meaning: ");
                String meaning = sc.nextLine();

                dictionary.put(word, meaning);

                System.out.println("Word added successfully.");

            } else if (choice == 2) {
                System.out.print("Enter word to search: ");
                String searchWord = sc.nextLine().toLowerCase();

                if (dictionary.containsKey(searchWord)) {
                    System.out.println("Word Found");
                    System.out.println("Word: " + searchWord);
                    System.out.println("Meaning: " + dictionary.get(searchWord));
                } else {
                    System.out.println("Word not found in dictionary.");
                }

            } else if (choice == 3) {
                if (dictionary.isEmpty()) {
                    System.out.println("Dictionary is empty.");
                } else {
                    System.out.println("\n----- All Words -----");

                    for (String word : dictionary.keySet()) {
                        System.out.println(word + " : " + dictionary.get(word));
                    }
                }

            } else if (choice == 4) {
                System.out.print("Enter word to remove: ");
                String removeWord = sc.nextLine().toLowerCase();

                if (dictionary.containsKey(removeWord)) {
                    dictionary.remove(removeWord);
                    System.out.println("Word removed successfully.");
                } else {
                    System.out.println("Word not found.");
                }

            } else if (choice == 5) {
                System.out.println("Exiting Dictionary App...");

            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}