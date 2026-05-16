import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        sentence = sentence.trim();

        if (sentence.isEmpty()) {
            System.out.println("\nWord Count: 0");
            sc.close();
            return;
        }

        String[] words = sentence.split("\\s+");

        int wordCount = words.length;
        int characterCountWithoutSpaces = 0;
        int characterCountWithSpaces = sentence.length();

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                characterCountWithoutSpaces++;
            }
        }

        System.out.println("\n----- Word Counter Report -----");

        System.out.println("Sentence: " + sentence);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Characters With Spaces: " + characterCountWithSpaces);
        System.out.println("Characters Without Spaces: " + characterCountWithoutSpaces);

        System.out.println("\nWords entered:");

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ". " + words[i]);
        }

        sc.close();
    }
}