import java.util.Scanner;
import java.util.LinkedList;

public class PlaylistManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<String> playlist = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n----- Playlist Manager -----");
            System.out.println("1. Add Song");
            System.out.println("2. View Playlist");
            System.out.println("3. Add Song at Beginning");
            System.out.println("4. Add Song at Specific Position");
            System.out.println("5. Remove Song");
            System.out.println("6. Search Song");
            System.out.println("7. Play First Song");
            System.out.println("8. Play Last Song");
            System.out.println("9. Clear Playlist");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter song name: ");
                String song = sc.nextLine();

                playlist.add(song);

                System.out.println("Song added successfully.");

            } else if (choice == 2) {

                if (playlist.isEmpty()) {
                    System.out.println("Playlist is empty.");
                } else {
                    System.out.println("\n----- Your Playlist -----");

                    for (int i = 0; i < playlist.size(); i++) {
                        System.out.println((i + 1) + ". " + playlist.get(i));
                    }
                }

            } else if (choice == 3) {

                System.out.print("Enter song name: ");
                String song = sc.nextLine();

                playlist.addFirst(song);

                System.out.println("Song added at beginning.");

            } else if (choice == 4) {

                System.out.print("Enter song name: ");
                String song = sc.nextLine();

                System.out.print("Enter position: ");
                int position = sc.nextInt();
                sc.nextLine();

                if (position < 1 || position > playlist.size() + 1) {
                    System.out.println("Invalid position.");
                } else {
                    playlist.add(position - 1, song);
                    System.out.println("Song added at position " + position);
                }

            } else if (choice == 5) {

                if (playlist.isEmpty()) {
                    System.out.println("Playlist is empty. Nothing to remove.");
                } else {
                    System.out.print("Enter song number to remove: ");
                    int songNumber = sc.nextInt();
                    sc.nextLine();

                    if (songNumber < 1 || songNumber > playlist.size()) {
                        System.out.println("Invalid song number.");
                    } else {
                        String removedSong = playlist.remove(songNumber - 1);
                        System.out.println("Removed song: " + removedSong);
                    }
                }

            } else if (choice == 6) {

                if (playlist.isEmpty()) {
                    System.out.println("Playlist is empty. Nothing to search.");
                } else {
                    System.out.print("Enter song name to search: ");
                    String searchSong = sc.nextLine().toLowerCase();

                    boolean found = false;

                    System.out.println("\n----- Search Results -----");

                    for (int i = 0; i < playlist.size(); i++) {
                        if (playlist.get(i).toLowerCase().contains(searchSong)) {
                            System.out.println((i + 1) + ". " + playlist.get(i));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching song found.");
                    }
                }

            } else if (choice == 7) {

                if (playlist.isEmpty()) {
                    System.out.println("Playlist is empty.");
                } else {
                    System.out.println("Now Playing: " + playlist.getFirst());
                }

            } else if (choice == 8) {

                if (playlist.isEmpty()) {
                    System.out.println("Playlist is empty.");
                } else {
                    System.out.println("Now Playing: " + playlist.getLast());
                }

            } else if (choice == 9) {

                playlist.clear();
                System.out.println("Playlist cleared successfully.");

            } else if (choice == 10) {

                System.out.println("Exiting Playlist Manager...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 10);

        sc.close();
    }
}