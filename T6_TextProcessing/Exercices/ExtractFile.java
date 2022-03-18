package Programming_f.BasicSyntax.TextProcessingExercices;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String file = scanner.nextLine();
        String[] inputFile = file.split("\\\\");
        String[] endFile = inputFile[inputFile.length - 1].split("\\.");
        String name = endFile[0];
        String extension = endFile[1];

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);
    }
}
