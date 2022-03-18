package Programming_f.BasicSyntax.DataTypesExercices;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxNum = Double.MIN_VALUE;
        String maxKeg = "";

        for (int i = 1; i <= n; i++) {
            String modelKeg = scanner.nextLine();
            double radiusKeg = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double calculate = Math.PI * Math.pow(radiusKeg,2) * height;

            if (calculate > maxNum){
                maxNum = calculate;
                maxKeg = modelKeg;
            }
        }
        System.out.println(maxKeg);
    }
}
