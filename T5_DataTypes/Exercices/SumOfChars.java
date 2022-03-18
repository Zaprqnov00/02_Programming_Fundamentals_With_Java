package Programming_f.BasicSyntax.DataTypesExercices;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int symbol = 0; symbol < n; symbol++) {
            String letters = scanner.nextLine();

           sum += letters.charAt(0);

        }
        System.out.println("The sum equals: " + sum);
    }
}
