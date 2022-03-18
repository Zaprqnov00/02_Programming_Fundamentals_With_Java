package Programming_f.BasicSyntax.BasicSyntax;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int factorialNumber = 1;

        for (int i = 1; i <= number; i++) {
            factorialNumber *= i;
        }
        if (factorialNumber == number){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
