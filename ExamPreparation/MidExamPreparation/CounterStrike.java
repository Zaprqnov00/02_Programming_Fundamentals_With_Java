package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int wonBattle = 0;
        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (energy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattle, energy);
                return;
            }

            wonBattle++;
            energy -= distance;

            if (wonBattle % 3 == 0) {
                energy += wonBattle;
            }

            command = scanner.nextLine();
        }
            System.out.printf("Won battles: %d. Energy left: %d",wonBattle,energy);

    }
}
