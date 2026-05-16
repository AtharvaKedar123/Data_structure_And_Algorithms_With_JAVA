import java.io.File;
import java.util.Scanner;

public class FileFolderTreeViewer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----- File Folder Tree Viewer -----");
        System.out.print("Enter folder path: ");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);

        if (!folder.exists()) {
            System.out.println("Folder path does not exist.");
            sc.close();
            return;
        }

        if (!folder.isDirectory()) {
            System.out.println("The given path is not a folder.");
            sc.close();
            return;
        }

        System.out.println("\nFolder Tree:");
        System.out.println(folder.getName());

        displayTree(folder, "");

        sc.close();
    }

    public static void displayTree(File folder, String indent) {

        File[] files = folder.listFiles();

        if (files == null) {
            return;
        }

        for (int i = 0; i < files.length; i++) {

            File file = files[i];

            if (file.isDirectory()) {
                System.out.println(indent + "|-- " + file.getName() + "/");
                displayTree(file, indent + "|   ");
            } else {
                System.out.println(indent + "|-- " + file.getName());
            }
        }
    }
}