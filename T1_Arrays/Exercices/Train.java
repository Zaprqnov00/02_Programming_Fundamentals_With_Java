package Programming_f.BasicSyntax.ArraysExercices;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        int[] numbersArr = new int[numbers];

        int sum = 0;
        for (int i = 0; i < numbers; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            numbersArr[i] = people;
            sum += numbersArr[i];
            System.out.print(numbersArr[i] + " ");
        }

        System.out.println();
        System.out.print(sum);
    }
}
