package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        middleCharacter(text);
    }
    public static void middleCharacter(String text){

        if (text.length() % 2 != 0){
            int middleSymbol = text.length() / 2;
            System.out.println(text.charAt(middleSymbol));
        }else {
            int firstMiddleSymbol = text.length() / 2 - 1;
            int secondMiddleSymbol = text.length() / 2;
            System.out.println(text.charAt(firstMiddleSymbol ) + "" + text.charAt(secondMiddleSymbol));
        }
    }
}
