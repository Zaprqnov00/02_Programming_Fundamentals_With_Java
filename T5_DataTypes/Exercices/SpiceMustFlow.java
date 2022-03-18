package Programming_f.BasicSyntax.DataTypesExercices;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalAmount = 0;

            while (startingYield >= 100){

                int workedSpice = startingYield - 26;
                totalAmount += workedSpice;
                startingYield -= 10;
                days++;
            }

        System.out.println(days);
            if (totalAmount >= 26){
                totalAmount -=26;
            }
        System.out.println(totalAmount);
    }
}
