package Programming_f.BasicSyntax.TextProcessingExercices;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbols = text.charAt(i);
            char symbolEncrypted = (char) (symbols + 3);

            decryptedText.append(symbolEncrypted);
        }
        System.out.println(decryptedText);
    }
}
