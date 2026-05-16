import java.util.Scanner;
import java.util.ArrayList;

public class SimpleLeaderboard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n----- Simple Leaderboard -----");
            System.out.println("1. Add Player");
            System.out.println("2. View Leaderboard");
            System.out.println("3. Search Player");
            System.out.println("4. Update Score");
            System.out.println("5. Remove Player");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter player name: ");
                String name = sc.nextLine();

                System.out.print("Enter score: ");
                int score = sc.nextInt();
                sc.nextLine();

                playerNames.add(name);
                scores.add(score);

                System.out.println("Player added successfully.");

            } else if (choice == 2) {

                if (playerNames.isEmpty()) {
                    System.out.println("Leaderboard is empty.");
                } else {

                    for (int i = 0; i < scores.size() - 1; i++) {
                        for (int j = 0; j < scores.size() - i - 1; j++) {

                            if (scores.get(j) < scores.get(j + 1)) {

                                int tempScore = scores.get(j);
                                scores.set(j, scores.get(j + 1));
                                scores.set(j + 1, tempScore);

                                String tempName = playerNames.get(j);
                                playerNames.set(j, playerNames.get(j + 1));
                                playerNames.set(j + 1, tempName);
                            }
                        }
                    }

                    System.out.println("\n----- Leaderboard -----");

                    for (int i = 0; i < playerNames.size(); i++) {
                        System.out.println((i + 1) + ". " + playerNames.get(i) + " - " + scores.get(i));
                    }
                }

            } else if (choice == 3) {

                if (playerNames.isEmpty()) {
                    System.out.println("No players available to search.");
                } else {
                    System.out.print("Enter player name to search: ");
                    String searchName = sc.nextLine().toLowerCase();

                    boolean found = false;

                    System.out.println("\n----- Search Result -----");

                    for (int i = 0; i < playerNames.size(); i++) {
                        if (playerNames.get(i).toLowerCase().contains(searchName)) {
                            System.out.println("Player Found");
                            System.out.println("Name: " + playerNames.get(i));
                            System.out.println("Score: " + scores.get(i));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Player not found.");
                    }
                }

            } else if (choice == 4) {

                if (playerNames.isEmpty()) {
                    System.out.println("No players available to update.");
                } else {
                    System.out.print("Enter player name to update score: ");
                    String updateName = sc.nextLine().toLowerCase();

                    boolean found = false;

                    for (int i = 0; i < playerNames.size(); i++) {
                        if (playerNames.get(i).toLowerCase().equals(updateName)) {

                            System.out.print("Enter new score: ");
                            int newScore = sc.nextInt();
                            sc.nextLine();

                            scores.set(i, newScore);

                            System.out.println("Score updated successfully.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Player not found.");
                    }
                }

            } else if (choice == 5) {

                if (playerNames.isEmpty()) {
                    System.out.println("No players available to remove.");
                } else {
                    System.out.print("Enter player name to remove: ");
                    String removeName = sc.nextLine().toLowerCase();

                    boolean found = false;

                    for (int i = 0; i < playerNames.size(); i++) {
                        if (playerNames.get(i).toLowerCase().equals(removeName)) {

                            String removedPlayer = playerNames.remove(i);
                            scores.remove(i);

                            System.out.println("Removed player: " + removedPlayer);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Player not found.");
                    }
                }

            } else if (choice == 6) {

                System.out.println("Exiting Simple Leaderboard...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 6);

        sc.close();
    }
}