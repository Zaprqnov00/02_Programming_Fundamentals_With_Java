package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collectingItems = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")){
            List<String> input = Arrays
                    .stream(command.split(" - "))
                    .collect(Collectors.toList());

            String commandCraft = input.get(0);
            String item = input.get(1);

            switch (commandCraft){
                case "Collect":
                    if (!collectingItems.contains(item)){
                        collectingItems.add(item);
                    }
                    break;

                case "Drop":
                    if (collectingItems.contains(item)){
                        collectingItems.remove(item);
                    }
                    break;

                case "Combine Items":
                    List<String> oldNewItem = Arrays.stream(input.get(1).split(":")).collect(Collectors.toList());
                    String oldItem = oldNewItem.get(0);
                    String newItem = oldNewItem.get(1);
                    int indexOldItem = collectingItems.indexOf(oldItem);
                    if (collectingItems.contains(oldItem)){
                        collectingItems.add(indexOldItem + 1,newItem);
                    }
                    break;

                case "Renew":
                    if (collectingItems.contains(item)){
                        collectingItems.remove(item);
                        collectingItems.add(item);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(collectingItems.toString().replaceAll("[\\[\\]]",""));
    }
}
