import java.util.Scanner;
import java.util.HashSet;

public class UniqueNamesFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of names must be greater than 0.");
            sc.close();
            return;
        }

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        HashSet<String> uniqueNames = new HashSet<>();
        HashSet<String> duplicateNames = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = names[i].toLowerCase();

            if (uniqueNames.contains(name)) {
                duplicateNames.add(name);
            } else {
                uniqueNames.add(name);
            }
        }

        System.out.println("\n----- Unique Names Report -----");

        System.out.println("\nNames entered:");

        for (int i = 0; i < n; i++) {
            System.out.println(names[i]);
        }

        System.out.println("\nUnique names:");

        for (String name : uniqueNames) {
            System.out.println(name);
        }

        if (duplicateNames.isEmpty()) {
            System.out.println("\nNo duplicate names found.");
        } else {
            System.out.println("\nDuplicate names:");

            for (String name : duplicateNames) {
                System.out.println(name);
            }
        }

        sc.close();
    }
}