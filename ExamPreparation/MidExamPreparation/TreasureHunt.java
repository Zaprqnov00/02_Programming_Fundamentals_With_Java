package Programming_f.BasicSyntax.MidExamExercices;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chestItems = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")){
            List<String> listCommand = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            String firstCommand = listCommand.get(0);

            switch (firstCommand){

                case "Loot":
                    for (int i = 1; i < listCommand.size(); i++) {
                        if (!chestItems.contains(listCommand.get(i))){
                            chestItems.add(0, listCommand.get(i));
                        }
                    }
                    break;

                case "Drop":
                    int index1 = Integer.parseInt(listCommand.get(1));
                    if (index1 >= 0 && index1 <= chestItems.size()){
                        String itemToDrop = chestItems.remove(index1);
                        chestItems.add(itemToDrop);
                    }
                    break;

                case "Steal":
                    int countItems = Integer.parseInt(listCommand.get(1));
                    List<String> stolenItems = new ArrayList<>();

                    for (int i = 0; i < countItems; i++) {
                        int stoleLastItems = chestItems.size() - 1;
                        stolenItems.add(0,chestItems.remove(stoleLastItems));

                    }
                    System.out.println(stolenItems.toString().replaceAll("[\\[\\]]",""));
                    break;
            }
            command = scanner.nextLine();
        }

        int totalSum = 0;
        for (String items :chestItems) {
            totalSum += items.length();
        }
        double averageTreasure = totalSum * 1.0 / chestItems.size();

        if (chestItems.isEmpty()){
            System.out.println("Failed treasure hunt.");
        }else {
            System.out.printf("Average treasure gain: %.2f pirate credits.",averageTreasure);
        }
    }
}
