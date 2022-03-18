package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        charSequence(firstChar,secondChar);

    }
    public static void charSequence(char firstChar, char secondChar){

        if (firstChar < secondChar){
            for (int symbol = firstChar + 1; symbol < secondChar; symbol++) {
                System.out.print((char)symbol + " ");
            }
        }else {
            for (int symbol = secondChar + 1; symbol < firstChar ; symbol++) {
                System.out.print((char)symbol + " ");
            }
        }
    }

}
