package Programming_f.BasicSyntax.TextProcessing;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removeWord = scanner.nextLine();
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            if (text.contains(removeWord)){
                text = text.replace(removeWord,"");
            }
        }
        System.out.println(text);
    }
}
