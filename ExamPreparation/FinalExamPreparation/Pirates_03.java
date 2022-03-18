package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.*;
import java.util.stream.Collectors;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> populationMap = new TreeMap<>();
        Map<String,Integer> resourceMap = new TreeMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Sail")){
            List<String> input = Arrays
                    .stream(command.split("\\|\\|"))
                    .collect(Collectors.toList());
            String city = input.get(0);
            int population = Integer.parseInt(input.get(1));
            int gold = Integer.parseInt(input.get(2));

            if (!populationMap.containsKey(city)){
                populationMap.put(city,population);
            }else {
                int currentPopulation = populationMap.get(city);
                populationMap.put(city,currentPopulation + population);
            }
            if (!resourceMap.containsKey(city)){
                resourceMap.put(city,gold);
            }else {
                int currentResource = resourceMap.get(city);
                resourceMap.put(city,currentResource + gold);
            }
            command = scanner.nextLine();
        }

        String secondCommand = scanner.nextLine();
        while (!secondCommand.equals("End")){
            List<String> secondInput = Arrays
                    .stream(secondCommand.split("=>"))
                    .collect(Collectors.toList());
            String firstCommand = secondInput.get(0);
            String town = secondInput.get(1);

            switch (firstCommand){
                case "Plunder":
                    int peoplePlunder = Integer.parseInt(secondInput.get(2));
                    int goldPlunder = Integer.parseInt(secondInput.get(3));
                    int currentPeople = populationMap.get(town);
                    int currentGold = resourceMap.get(town);
                    currentPeople -= peoplePlunder;
                    currentGold -= goldPlunder;
                    populationMap.put(town,currentPeople);
                    resourceMap.put(town,currentGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, goldPlunder, peoplePlunder);
                    if (currentGold <= 0 || currentPeople <= 0) {
                        populationMap.remove(town);
                        resourceMap.remove(town);
                        System.out.printf("%s has been wiped off the map!\n", town);
                        break;
                    }
                    break;
                case "Prosper":
                    int goldAdded = Integer.parseInt(secondInput.get(2));
                    int cityGold = resourceMap.get(town);
                    if (goldAdded > 0) {
                        cityGold += goldAdded;
                        resourceMap.put(town,cityGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",goldAdded,town,cityGold);
                    }else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            secondCommand = scanner.nextLine();
        }
        int countCity = 0;
        for (Map.Entry<String, Integer> entry : populationMap.entrySet()) {
            countCity++;
        }
        if (countCity == 0){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",countCity);
            resourceMap.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                            entry.getKey(),populationMap.get(entry.getKey()),entry.getValue()));
        }
    }
}
