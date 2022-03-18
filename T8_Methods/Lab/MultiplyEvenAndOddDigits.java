package Programming_f.BasicSyntax.Methods;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvenAndOddDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(multiplyDigits(numbers));

    }

    public static int multiplyDigits(int numbers){
        int evenSum = evenDigitsSum(numbers);
        int oddSum = oddDigitsSum(numbers);

        return evenSum * oddSum;
    }

    public static int evenDigitsSum(int numbers){

        String intToString = Integer.toString(numbers);

        int[] arrays = Arrays
                .stream(intToString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenSum = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] % 2 == 0){
                evenSum += arrays[i];
            }
        }
        return evenSum;
    }

    public static int oddDigitsSum(int numbers){

        String intToString = Integer.toString(numbers);

        int[] arrays = Arrays
                .stream(intToString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int oddSum = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] % 2 != 0){
                oddSum += arrays[i];
            }
        }
        return oddSum;
    }
}
