package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MUOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        int roomsCounter = 0;
        boolean notDead = true;

            List<String> fightRooms = Arrays
                    .stream(scanner.nextLine()
                            .split("\\|")).collect(Collectors.toList());

        for (int i = 0; i < fightRooms.size(); i++) {
            List<String> firstCommand = Arrays
                    .stream(fightRooms.get(i).split(" "))
                    .collect(Collectors.toList());
            String firstInput = firstCommand.get(0);
            String secondInput = firstCommand.get(1);

            if ("potion".equals(firstInput)) {
                int healCommand = Integer.parseInt(secondInput);
                if (health <= 100) {
                    health += healCommand;
                    if (health > 100) {
                        healCommand = Math.abs((health - 100) - healCommand);
                        health = 100;
                    }
                }
                System.out.printf("You healed for %d hp.\n", healCommand);
                System.out.printf("Current health: %d hp.\n", health);
                roomsCounter++;
            } else if ("chest".equals(firstInput)) {
                int bitcoinsAmount = Integer.parseInt(secondInput);
                bitcoins += bitcoinsAmount;
                System.out.printf("You found %d bitcoins.\n",bitcoinsAmount);
                roomsCounter++;
            }else {
                roomsCounter++;
                int monsterAttack = Integer.parseInt(secondInput);
                health -= monsterAttack;
                if (health > 0){
                    System.out.printf("You slayed %s.\n",firstInput);
                }else {
                    System.out.printf("You died! Killed by %s.\n",firstInput);
                    System.out.printf("Best room: %d\n",roomsCounter);
                    notDead = false;
                    break;
                }
            }
        }
        if (notDead){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n",bitcoins);
            System.out.printf("Health: %d",health);
        }
    }
}
