package Programming_f.BasicSyntax.ArraysExercices;

import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int[] numbers = Arrays
                       .stream(scanner.nextLine().split(" "))
                       .mapToInt(Integer::parseInt)
                       .toArray();

       // 1 4 3 2
        for (int index = 0; index <= numbers.length - 1 ; index++) {
            int myNumber = numbers[index];
            if (index == numbers.length - 1){
                System.out.print(myNumber + " ");
                break;
            }
            boolean isBigger = false;
            for (int i = index + 1; i <= numbers.length - 1 ; i++) {
                if (myNumber > numbers[i]){
                    isBigger = true;
                }else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger){
                System.out.print(myNumber + " ");
            }
        }
    }
}
