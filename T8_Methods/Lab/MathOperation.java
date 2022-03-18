package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class MathOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.println(operationDigits(firstNum,operator,secondNum));

    }
    public static int operationDigits(int firstNum,String operator,int secondNum){

        int result = 0;

        switch (operator){
            case "*":
                return result = firstNum * secondNum;
            case "/":
                return result = firstNum  / secondNum;
            case "-":
                return result = firstNum - secondNum;
            case "+":
                return result = firstNum + secondNum;
        }
        return result;
    }
}
