package Programming_f.BasicSyntax.ArraysExercices;

import java.util.Scanner;

public class ZigZagSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] array1 = new String[n];
        String[] array2 = new String[n];

        for (int index = 0; index < n; index++) {
            String[] input = scanner.nextLine().split(" ");
            String firstElement = input[0];
            String secondElement = input[1];

            if ((index + 1) % 2 == 0){
                array2[index] = firstElement;
                array1[index] = secondElement;
            }else {
                array1[index] = firstElement;
                array2[index] = secondElement;
            }
        }
        System.out.println(String.join(" ",array1));
        System.out.println(String.join(" ",array2));
    }
}
