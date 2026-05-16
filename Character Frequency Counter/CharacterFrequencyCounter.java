import java.util.Scanner;
import java.util.HashMap;

public class CharacterFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        if (text.isEmpty()) {
            System.out.println("Input cannot be empty.");
            sc.close();
            return;
        }

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            } else {
                frequencyMap.put(ch, 1);
            }
        }

        System.out.println("\n----- Character Frequency Report -----");

        for (char ch : frequencyMap.keySet()) {
            System.out.println(ch + " = " + frequencyMap.get(ch));
        }

        sc.close();
    }
}