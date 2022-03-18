package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Scanner;

public class BlagFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double dailyPlunder = Double.parseDouble(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double total = 0;

        for (int i = 1; i <= days; i++) {
            total += dailyPlunder;

            if (i % 3 == 0){
               total += dailyPlunder * 0.50;
            }
            if (i % 5 == 0){
                total -= total * 0.30;
            }
        }
        if (total >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.\n",total);
        }else {
            System.out.printf("Collected only %.2f%% of the plunder.",total / expectedPlunder * 100);
        }

    }
}
