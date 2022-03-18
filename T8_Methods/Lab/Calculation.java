package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        if ("add".equals(input)) {
            sumAdd(firstNumber, secondNumber);
        } else if ("subtract".equals(input)) {
            sumSubtract(firstNumber, secondNumber);
        } else if ("multiply".equals(input)) {
            sumMultiply(firstNumber, secondNumber);
        } else if ("divide".equals(input)) {
            sumDivide(firstNumber, secondNumber);
        }
    }

    public static void sumAdd(int firstNumber,int secondNumber){
        System.out.println(firstNumber + secondNumber);
    }
    public static void sumSubtract(int firstNumber, int secondNumber){
        System.out.println(firstNumber - secondNumber);
    }
    public static void sumMultiply(int firstNumber, int secondNumber){
        System.out.println(firstNumber * secondNumber);
    }
    public static void sumDivide(int firstNumber, int secondNumber){
        System.out.println(firstNumber / secondNumber);
    }
}
