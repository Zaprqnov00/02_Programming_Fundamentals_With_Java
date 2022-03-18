package Programming_f.BasicSyntax.BasicSyntaxExercices;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceLightSabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double sumLight = Math.ceil(countOfStudents * 1.1) * priceLightSabers;
        double sumRobes = countOfStudents * priceRobes;
        double sumBelts = (countOfStudents - countOfStudents / 6) * priceBelts;

        double totalSum = sumLight + sumRobes + sumBelts;

        if (totalSum > amountMoney) {
            System.out.printf("George Lucas will need %.2flv more.", totalSum - amountMoney);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        }
    }
}
