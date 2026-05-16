import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingCartSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n----- Shopping Cart System -----");
            System.out.println("1. Add Item");
            System.out.println("2. View Cart");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Remove Item");
            System.out.println("5. Search Item");
            System.out.println("6. Generate Bill");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter item name: ");
                String itemName = sc.nextLine();

                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Enter price per item: ");
                double price = sc.nextDouble();
                sc.nextLine();

                if (quantity <= 0 || price <= 0) {
                    System.out.println("Quantity and price must be greater than 0.");
                } else {
                    itemNames.add(itemName);
                    quantities.add(quantity);
                    prices.add(price);

                    System.out.println("Item added successfully.");
                }

            } else if (choice == 2) {

                if (itemNames.isEmpty()) {
                    System.out.println("Cart is empty.");
                } else {
                    System.out.println("\n----- Cart Items -----");

                    for (int i = 0; i < itemNames.size(); i++) {
                        double itemTotal = quantities.get(i) * prices.get(i);

                        System.out.println((i + 1) + ". " + itemNames.get(i));
                        System.out.println("   Quantity: " + quantities.get(i));
                        System.out.println("   Price: " + prices.get(i));
                        System.out.println("   Total: " + itemTotal);
                    }
                }

            } else if (choice == 3) {

                if (itemNames.isEmpty()) {
                    System.out.println("Cart is empty. Nothing to update.");
                } else {
                    System.out.print("Enter item number to update quantity: ");
                    int itemNumber = sc.nextInt();

                    if (itemNumber < 1 || itemNumber > itemNames.size()) {
                        System.out.println("Invalid item number.");
                    } else {
                        System.out.print("Enter new quantity: ");
                        int newQuantity = sc.nextInt();

                        if (newQuantity <= 0) {
                            System.out.println("Quantity must be greater than 0.");
                        } else {
                            quantities.set(itemNumber - 1, newQuantity);
                            System.out.println("Quantity updated successfully.");
                        }
                    }
                }

            } else if (choice == 4) {

                if (itemNames.isEmpty()) {
                    System.out.println("Cart is empty. Nothing to remove.");
                } else {
                    System.out.print("Enter item number to remove: ");
                    int itemNumber = sc.nextInt();
                    sc.nextLine();

                    if (itemNumber < 1 || itemNumber > itemNames.size()) {
                        System.out.println("Invalid item number.");
                    } else {
                        String removedItem = itemNames.remove(itemNumber - 1);
                        quantities.remove(itemNumber - 1);
                        prices.remove(itemNumber - 1);

                        System.out.println("Removed item: " + removedItem);
                    }
                }

            } else if (choice == 5) {

                if (itemNames.isEmpty()) {
                    System.out.println("Cart is empty. Nothing to search.");
                } else {
                    System.out.print("Enter item name to search: ");
                    String searchItem = sc.nextLine().toLowerCase();

                    boolean found = false;

                    System.out.println("\n----- Search Results -----");

                    for (int i = 0; i < itemNames.size(); i++) {
                        if (itemNames.get(i).toLowerCase().contains(searchItem)) {
                            double itemTotal = quantities.get(i) * prices.get(i);

                            System.out.println((i + 1) + ". " + itemNames.get(i));
                            System.out.println("   Quantity: " + quantities.get(i));
                            System.out.println("   Price: " + prices.get(i));
                            System.out.println("   Total: " + itemTotal);

                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching item found.");
                    }
                }

            } else if (choice == 6) {

                if (itemNames.isEmpty()) {
                    System.out.println("Cart is empty. No bill to generate.");
                } else {
                    double grandTotal = 0;

                    System.out.println("\n========== Final Bill ==========");

                    for (int i = 0; i < itemNames.size(); i++) {
                        double itemTotal = quantities.get(i) * prices.get(i);
                        grandTotal = grandTotal + itemTotal;

                        System.out.println((i + 1) + ". " + itemNames.get(i));
                        System.out.println("   Quantity: " + quantities.get(i));
                        System.out.println("   Price: " + prices.get(i));
                        System.out.println("   Total: " + itemTotal);
                    }

                    System.out.println("--------------------------------");
                    System.out.println("Grand Total: " + grandTotal);
                    System.out.println("================================");
                }

            } else if (choice == 7) {

                System.out.println("Exiting Shopping Cart System...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);

        sc.close();
    }
}