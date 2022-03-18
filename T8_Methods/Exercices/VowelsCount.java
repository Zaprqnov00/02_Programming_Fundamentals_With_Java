package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        vowelsLetters(text);

    }
    public static void vowelsLetters(String text){

        int counter = 0;
        for (int index = 0; index <= text.length() - 1; index++) {
            char vowelsSymbol = text.charAt(index);
            if (vowelsSymbol == 'a' || vowelsSymbol == 'o' || vowelsSymbol == 'i'
            || vowelsSymbol == 'e' || vowelsSymbol == 'u'){
                counter++;
            }

        }
        System.out.println(counter);
    }
}
