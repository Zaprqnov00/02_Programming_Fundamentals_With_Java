package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Scanner;

public class P01BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        for (int i = 1; i <= n; i++) {
            String nameCity = scanner.nextLine();
            double winMoney = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());

            if (i % 5 == 0){
                winMoney = winMoney - (winMoney * 0.10);
            }else if (i % 3 == 0){
                expenses = expenses + (expenses * 0.50);
            }

            double sumAllCity = winMoney - expenses;

            sum += sumAllCity;
            System.out.printf("In %s Burger Bus earned %.2f leva.\n",nameCity,sumAllCity);
        }
        System.out.printf("Burger Bus total profit: %.2f leva.\n",sum);
    }
}
