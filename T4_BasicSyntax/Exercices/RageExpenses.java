package Programming_f.BasicSyntax.BasicSyntaxExercices;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loseGame = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int trashedHeadset = loseGame / 2;
        int trashedMouse = loseGame / 3;
        int trashedKeyboard = loseGame / 6;
        int trashedDisplay = loseGame / 12;

        double expenses = (headsetPrice * trashedHeadset) + (mousePrice * trashedMouse) + (keyboardPrice * trashedKeyboard) +
                (displayPrice * trashedDisplay);

        System.out.printf("Rage expenses: %.2f lv.",expenses);
    }
}
