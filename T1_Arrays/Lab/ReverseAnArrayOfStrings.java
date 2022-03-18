package Programming_f.BasicSyntax.Arrays;

import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] letters = scanner.nextLine().split(" ");

        for (int i = letters.length - 1; i >= 0 ; i--) {
            System.out.print(letters[i] + " ");
        }
    }
}
