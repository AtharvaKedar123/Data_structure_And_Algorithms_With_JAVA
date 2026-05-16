import java.util.Scanner;
import java.util.Stack;

public class UndoRedoTextEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        String text = "";

        int choice;

        do {
            System.out.println("\n----- Undo/Redo Text Editor -----");
            System.out.println("Current Text: " + text);
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Clear Text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                undoStack.push(text);

                System.out.print("Enter text to add: ");
                String newText = sc.nextLine();

                text = text + newText;

                redoStack.clear();

                System.out.println("Text added successfully.");

            } else if (choice == 2) {

                if (undoStack.isEmpty()) {
                    System.out.println("Nothing to undo.");
                } else {
                    redoStack.push(text);
                    text = undoStack.pop();

                    System.out.println("Undo successful.");
                }

            } else if (choice == 3) {

                if (redoStack.isEmpty()) {
                    System.out.println("Nothing to redo.");
                } else {
                    undoStack.push(text);
                    text = redoStack.pop();

                    System.out.println("Redo successful.");
                }

            } else if (choice == 4) {

                undoStack.push(text);
                text = "";
                redoStack.clear();

                System.out.println("Text cleared successfully.");

            } else if (choice == 5) {

                System.out.println("Exiting Text Editor...");

            } else {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 5);

        sc.close();
    }
}