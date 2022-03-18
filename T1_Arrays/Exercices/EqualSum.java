package Programming_f.BasicSyntax.ArraysExercices;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        boolean search = true;
        //Първо обхождам индексите!
        for (int index = 0; index < numbers.length; index++) {
            //сумата от ляво на индекса
            int sumLeft = 0;//от 0 до индекса - 1
            int sumRight = 0;//от индекса + 1 до последния индекс
            for (int indexLeft = 0; indexLeft <= index - 1; indexLeft++) {
                sumLeft += numbers[indexLeft];
            }
            for (int indexRight = index + 1; indexRight < numbers.length; indexRight++) {
                sumRight += numbers[indexRight];
            }
            if (sumLeft == sumRight){
                System.out.println(index);
                search = false;
            }
        }
        if (search){
            System.out.println("no");
        }
    }
}
