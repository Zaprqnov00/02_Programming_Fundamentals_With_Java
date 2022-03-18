package Programming_f.BasicSyntax.TextProcessing;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        while (!word.equals("end")){

            StringBuilder reverseWords = new StringBuilder();
            for (int i = word.length() - 1; i >= 0 ; i--) {
                reverseWords.append(word.charAt(i));
            }
            System.out.printf("%s = %s\n",word, reverseWords.toString());
            word = scanner.nextLine();

        }
    }
}
