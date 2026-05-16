import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class SimpleRouteMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, ArrayList<String>> routeMap = new HashMap<>();

        int choice;

        do {
            System.out.println("\n----- Simple Route Map -----");
            System.out.println("1. Add Location");
            System.out.println("2. Add Route");
            System.out.println("3. View All Locations");
            System.out.println("4. View All Routes");
            System.out.println("5. Search Connected Locations");
            System.out.println("6. Check Direct Route");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter location name: ");
                String location = sc.nextLine().toLowerCase();

                if (routeMap.containsKey(location)) {
                    System.out.println("Location already exists.");
                } else {
                    routeMap.put(location, new ArrayList<>());
                    System.out.println("Location added successfully.");
                }

            } else if (choice == 2) {

                System.out.print("Enter first location: ");
                String location1 = sc.nextLine().toLowerCase();

                System.out.print("Enter second location: ");
                String location2 = sc.nextLine().toLowerCase();

                if (!routeMap.containsKey(location1)) {
                    routeMap.put(location1, new ArrayList<>());
                }

                if (!routeMap.containsKey(location2)) {
                    routeMap.put(location2, new ArrayList<>());
                }

                if (!routeMap.get(location1).contains(location2)) {
                    routeMap.get(location1).add(location2);
                }

                if (!routeMap.get(location2).contains(location1)) {
                    routeMap.get(location2).add(location1);
                }

                System.out.println("Route added successfully between " + location1 + " and " + location2);

            } else if (choice == 3) {

                if (routeMap.isEmpty()) {
                    System.out.println("No locations available.");
                } else {
                    System.out.println("\n----- All Locations -----");

                    for (String location : routeMap.keySet()) {
                        System.out.println(location);
                    }
                }

            } else if (choice == 4) {

                if (routeMap.isEmpty()) {
                    System.out.println("No routes available.");
                } else {
                    System.out.println("\n----- Route Map -----");

                    for (String location : routeMap.keySet()) {
                        System.out.println(location + " -> " + routeMap.get(location));
                    }
                }

            } else if (choice == 5) {

                if (routeMap.isEmpty()) {
                    System.out.println("No locations available.");
                } else {
                    System.out.print("Enter location name: ");
                    String location = sc.nextLine().toLowerCase();

                    if (!routeMap.containsKey(location)) {
                        System.out.println("Location not found.");
                    } else {
                        ArrayList<String> connectedLocations = routeMap.get(location);

                        if (connectedLocations.isEmpty()) {
                            System.out.println(location + " has no connected locations.");
                        } else {
                            System.out.println("\nLocations connected to " + location + ":");

                            for (String connectedLocation : connectedLocations) {
                                System.out.println(connectedLocation);
                            }
                        }
                    }
                }

            } else if (choice == 6) {

                System.out.print("Enter source location: ");
                String source = sc.nextLine().toLowerCase();

                System.out.print("Enter destination location: ");
                String destination = sc.nextLine().toLowerCase();

                if (!routeMap.containsKey(source) || !routeMap.containsKey(destination)) {
                    System.out.println("One or both locations do not exist.");
                } else if (routeMap.get(source).contains(destination)) {
                    System.out.println("Direct route exists between " + source + " and " + destination);
                } else {
                    System.out.println("No direct route exists between " + source + " and " + destination);
                }

            } else if (choice == 7) {

                System.out.println("Exiting Simple Route Map...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);

        sc.close();
    }
}