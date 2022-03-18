package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class SighOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        signNumber(number);
    }
    public static void signNumber (int number){

        if (number > 0){
            System.out.printf("The number %d is positive.",number);
        }else if (number < 0){
            System.out.printf("The number %d is negative.",number);
        }else {
            System.out.println("The number 0 is zero.");
        }
    }
}
