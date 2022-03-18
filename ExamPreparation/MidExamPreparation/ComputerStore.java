package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sumWithoutTaxes = 0;

        while (!input.equals("regular") && !input.equals("special")) {
            double partPricesWithoutTaxes = Double.parseDouble(input);

            if (partPricesWithoutTaxes < 0) {
                System.out.println("Invalid price!");
            } else{
                sumWithoutTaxes += partPricesWithoutTaxes;
            }

            input = scanner.nextLine();
        }
        double taxes = sumWithoutTaxes * 0.2;
        double finalPrice = sumWithoutTaxes + taxes;

        if (input.equals("special")){
            finalPrice = finalPrice * 0.9;
        }

        if (sumWithoutTaxes == 0){
            System.out.println("Invalid order!");
            return;
        }

        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$\n",sumWithoutTaxes);
        System.out.printf("Taxes: %.2f$\n",taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$",finalPrice);
    }
}
