import java.util.Scanner;

public class MovieRatingAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of movies must be greater than 0.");
            sc.close();
            return;
        }

        String[] movieNames = new String[n];
        double[] ratings = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for movie " + (i + 1));

            System.out.print("Enter movie name: ");
            movieNames[i] = sc.nextLine();

            System.out.print("Enter rating out of 10: ");
            ratings[i] = sc.nextDouble();
            sc.nextLine();

            if (ratings[i] < 0 || ratings[i] > 10) {
                System.out.println("Invalid rating. Rating must be between 0 and 10.");
                sc.close();
                return;
            }
        }

        double totalRating = 0;
        double highestRating = ratings[0];
        double lowestRating = ratings[0];

        int highestRatingIndex = 0;
        int lowestRatingIndex = 0;

        int excellentCount = 0;
        int goodCount = 0;
        int averageCount = 0;
        int poorCount = 0;

        for (int i = 0; i < n; i++) {

            totalRating = totalRating + ratings[i];

            if (ratings[i] > highestRating) {
                highestRating = ratings[i];
                highestRatingIndex = i;
            }

            if (ratings[i] < lowestRating) {
                lowestRating = ratings[i];
                lowestRatingIndex = i;
            }

            if (ratings[i] >= 8) {
                excellentCount++;
            } else if (ratings[i] >= 6) {
                goodCount++;
            } else if (ratings[i] >= 4) {
                averageCount++;
            } else {
                poorCount++;
            }
        }

        double averageRating = totalRating / n;

        System.out.println("\n----- Movie Rating Report -----");

        System.out.println("\nMovie Details:");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + movieNames[i] + " - Rating: " + ratings[i]);
        }

        System.out.println("\nTotal Rating: " + totalRating);
        System.out.println("Average Rating: " + averageRating);

        System.out.println("Highest Rated Movie: " + movieNames[highestRatingIndex]);
        System.out.println("Highest Rating: " + highestRating);

        System.out.println("Lowest Rated Movie: " + movieNames[lowestRatingIndex]);
        System.out.println("Lowest Rating: " + lowestRating);

        System.out.println("Excellent Movies: " + excellentCount);
        System.out.println("Good Movies: " + goodCount);
        System.out.println("Average Movies: " + averageCount);
        System.out.println("Poor Movies: " + poorCount);

        sc.close();
    }
}