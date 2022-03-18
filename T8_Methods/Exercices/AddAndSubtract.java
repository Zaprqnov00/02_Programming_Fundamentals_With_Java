package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        sumDigits(firstNumber,secondNumber,thirdNumber);
    }

    public static void sumDigits(int firstNumber, int secondNumber, int thirdNumber){
        int sum = 0;
        sum = (firstNumber + secondNumber) - thirdNumber;
        System.out.println(sum);
    }
}
