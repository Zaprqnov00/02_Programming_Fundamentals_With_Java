package Programming_f.BasicSyntax.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] condensed = new int[numbers.length - 1];

        for (int index = 0; index < numbers.length; index++) {
            if (numbers.length == 1){
                break;
            }
            if (index != numbers.length - 1){
                condensed[index] = numbers[index] + numbers[index + 1];
            }else {
                int[] condensedNew = new int[condensed.length - 1];
                index = -1;
                numbers = condensed;
                condensed = condensedNew;
            }
        }
        System.out.println(numbers[0]);
    }
}
