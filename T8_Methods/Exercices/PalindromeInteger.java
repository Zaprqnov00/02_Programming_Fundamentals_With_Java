package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class PalindromeInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")){
            if (!palindromeNum(input)){
                System.out.println("false");
            }else {
                System.out.println("true");
            }

            input = scanner.nextLine();
        }
    }
    public static boolean palindromeNum(String input){

        String reversed = "";
        for (int i = input.length() - 1; i >= 0 ; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }
}
