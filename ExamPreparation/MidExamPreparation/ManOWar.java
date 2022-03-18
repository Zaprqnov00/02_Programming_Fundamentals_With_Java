package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays
                        .stream(scanner.nextLine().split(">"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> warship = Arrays
                        .stream(scanner.nextLine().split(">"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());
        boolean pirateLoseBattle = true;

        String command = scanner.nextLine();

        while (!command.equals("Retire")){
            List<String> commandList = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            switch (commandList.get(0)){
                case "Fire":
                    int fireIndex = Integer.parseInt(commandList.get(1));
                    int damage = Integer.parseInt(commandList.get(2));
                    if (fireIndex >= 0 && fireIndex <= warship.size()) {
                        int sectionHealth = warship.get(fireIndex);
                        sectionHealth -= damage;
                        warship.set(fireIndex, sectionHealth);
                        if (sectionHealth <= 0){
                            System.out.println("You won! The enemy ship has sunken.");
                            pirateLoseBattle = false;
                            break;
                        }
                    }
                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(commandList.get(1));
                    int endIndex = Integer.parseInt(commandList.get(2));
                    int damagePirate = Integer.parseInt(commandList.get(3));
                    if (startIndex >= 0 && endIndex <= pirateShip.size()){
                        for (int i = startIndex; i <= endIndex; i++) {
                            int pirateHealth = pirateShip.get(i);
                            pirateHealth -= damagePirate;
                            pirateShip.set(i,pirateHealth);
                            if (pirateHealth <= 0){
                                System.out.println("You lost! The pirate ship has sunken.");
                                pirateLoseBattle = false;
                                break;
                            }
                        }
                    }
                    break;

                case "Repair":
                    int index = Integer.parseInt(commandList.get(1));
                    int health = Integer.parseInt(commandList.get(2));
                    if (index >= 0 && index <= pirateShip.size()) {
                        int healthRepair = pirateShip.get(index);
                        healthRepair += health;
                        pirateShip.set(index,healthRepair);
                        if (healthRepair > maxHealth){
                            break;
                        }
                    }
                    break;

                case "Status":
                    int counter = 0;
                    for (int currentSection :pirateShip) {
                        if (currentSection < 0.2 * maxHealth){
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.\n",counter);
                    break;

            }
            command = scanner.nextLine();
        }
        int sumPirate = 0;
        int sumWarship = 0;
        for (int pirate :pirateShip) {
            sumPirate += pirate;
        }
        for (int ship :warship) {
            sumWarship += ship;
        }

        if (pirateLoseBattle) {
            System.out.printf("Pirate ship status: %d\n", sumPirate);
            System.out.printf("Warship status: %d", sumWarship);
        }
    }
}
