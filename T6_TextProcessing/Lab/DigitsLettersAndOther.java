package Programming_f.BasicSyntax.TextProcessing;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder digitSB = new StringBuilder();
        StringBuilder letterSB = new StringBuilder();
        StringBuilder otherSB = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isDigit(symbol)){
                digitSB.append(symbol);
            }else if (Character.isLetter(symbol)){
                letterSB.append(symbol);
            }else {
                otherSB.append(symbol);
            }
        }
        System.out.println(digitSB);
        System.out.println(letterSB);
        System.out.println(otherSB);
    }
}
