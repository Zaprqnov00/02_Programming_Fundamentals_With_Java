package Programming_f.BasicSyntax.DataTypes;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.2f",n / 1000);
    }
}
