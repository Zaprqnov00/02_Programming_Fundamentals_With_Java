package Programming_f.BasicSyntax.Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int numberSteps = Integer.parseInt(scanner.nextLine());

        DecimalFormat decimalFormat = new DecimalFormat("0.###");
        System.out.println(decimalFormat.format(mathPower(number,numberSteps)));


    }
    public static double mathPower(double number, int numberSteps){
        double sum = 1;
        for (int rotation = 1; rotation <= numberSteps; rotation++) {
            sum *= number;
        }
        return sum;
    }
}
