package Programming_f.BasicSyntax.DataTypesExercices;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustion = Integer.parseInt(scanner.nextLine());
        int count = 0;

        int firstTimePower = power;
        while (power >= distance){
            power -= distance;
            count++;

            if (power == firstTimePower * 0.50 && exhaustion != 0){
                power /= exhaustion;
            }
        }
        System.out.println(power);
        System.out.println(count);
    }
}
