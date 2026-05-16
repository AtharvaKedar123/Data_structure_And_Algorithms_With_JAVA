import java.util.Scanner;
import java.util.HashMap;

public class VoteCountingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int candidateCount = sc.nextInt();
        sc.nextLine();

        if (candidateCount <= 0) {
            System.out.println("Number of candidates must be greater than 0.");
            sc.close();
            return;
        }

        String[] candidates = new String[candidateCount];
        HashMap<String, Integer> voteMap = new HashMap<>();

        for (int i = 0; i < candidateCount; i++) {
            System.out.print("Enter candidate " + (i + 1) + " name: ");
            candidates[i] = sc.nextLine();
            voteMap.put(candidates[i].toLowerCase(), 0);
        }

        System.out.print("\nEnter number of voters: ");
        int voterCount = sc.nextInt();
        sc.nextLine();

        if (voterCount <= 0) {
            System.out.println("Number of voters must be greater than 0.");
            sc.close();
            return;
        }

        int invalidVotes = 0;

        for (int i = 0; i < voterCount; i++) {
            System.out.print("Enter vote " + (i + 1) + ": ");
            String vote = sc.nextLine().toLowerCase();

            if (voteMap.containsKey(vote)) {
                voteMap.put(vote, voteMap.get(vote) + 1);
            } else {
                invalidVotes++;
            }
        }

        String winner = "";
        int highestVotes = -1;
        boolean tie = false;

        for (String candidate : voteMap.keySet()) {
            int votes = voteMap.get(candidate);

            if (votes > highestVotes) {
                highestVotes = votes;
                winner = candidate;
                tie = false;
            } else if (votes == highestVotes) {
                tie = true;
            }
        }

        System.out.println("\n----- Vote Counting Report -----");

        System.out.println("\nCandidate Votes:");

        for (String candidate : voteMap.keySet()) {
            System.out.println(candidate + " received " + voteMap.get(candidate) + " vote(s)");
        }

        System.out.println("\nInvalid Votes: " + invalidVotes);

        if (tie) {
            System.out.println("Result: Election is tied.");
        } else {
            System.out.println("Winner: " + winner);
            System.out.println("Winning Votes: " + highestVotes);
        }

        sc.close();
    }
}