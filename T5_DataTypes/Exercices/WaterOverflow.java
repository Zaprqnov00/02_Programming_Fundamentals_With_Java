package Programming_f.BasicSyntax.DataTypesExercices;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int litres = Integer.parseInt(scanner.nextLine());

            sum += litres;
            if (sum > 255) {
                System.out.println("Insufficient capacity!");
                sum -= litres;
            }


        }
        System.out.println(sum);
    }
}
