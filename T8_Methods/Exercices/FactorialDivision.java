package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        long firstFactorial = factorialSum(firstNumber);
        long secondFactorial = factorialSum(secondNumber);
        double factorialSum = firstFactorial * 1.0 / secondFactorial;
        System.out.printf("%.2f",factorialSum );

    }
    public static long factorialSum(int firstNumber){

        long fact = 1;
        for (int index = 1; index <= firstNumber; index++) {
            fact *= index;
        }
        return fact;
    }
}
