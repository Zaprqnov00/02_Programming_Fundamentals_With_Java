package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++) {

            if (isSumDigits(i) && haveOneOddDigits(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isSumDigits (int number){

        int sum = 0;
        while (number > 0){
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        return sum % 8 == 0;
    }

    public static boolean haveOneOddDigits (int number){
        while (number > 0){
            int lastDigits = number % 10;

            if (lastDigits % 2 != 0 ){
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
