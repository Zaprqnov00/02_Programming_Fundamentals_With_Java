package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.*;
import java.util.stream.Collectors;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Integer> rarityMap = new LinkedHashMap<>();
        Map<String,List<Double>> ratingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> input = Arrays
                    .stream(scanner.nextLine().split("<->"))
                    .collect(Collectors.toList());
            String namePlant = input.get(0);
            int rarity = Integer.parseInt(input.get(1));

            if (!rarityMap.containsKey(namePlant)){
                rarityMap.put(namePlant,rarity);
                ratingMap.put(namePlant,new ArrayList<>());
            }else {
                int currentRarity = rarityMap.get(namePlant);
                rarityMap.put(namePlant,rarity + currentRarity);
                ratingMap.put(namePlant,new ArrayList<>());
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")){
            List<String> input = Arrays
                    .stream(command.split(": "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);
            List<String> plantRating = Arrays.stream(input.get(1).split(" - ")).collect(Collectors.toList());
            String plant = plantRating.get(0);

            if (!rarityMap.containsKey(plant)){
                System.out.println("error");
                continue;
            }

            switch (firstCommand){
                case "Rate":
                double addRating = Integer.parseInt(plantRating.get(1));
                if (ratingMap.containsKey(plant)){
                    ratingMap.get(plant).add(addRating);
                }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(plantRating.get(1));
                    if (rarityMap.containsKey(plant)){
                        rarityMap.put(plant,newRarity);
                    }
                    break;
                case "Reset":
                    if (ratingMap.containsKey(plant)){
                        for (Map.Entry<String, List<Double>> entry : ratingMap.entrySet()) {
                            List<Double> all = entry.getValue();
                            for (int i = 0; i < all.size(); i++) {
                                double sum = all.get(i);
                                sum = 0.0;
                                ratingMap.put(plant, Collections.singletonList(sum));
                            }
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        Map<String,Double> allNewRatings = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : ratingMap.entrySet()) {
            double averageSum = 0;
            List<Double> allRating = entry.getValue();
            for (int i = 0; i < allRating.size(); i++) {
                averageSum += allRating.get(i);
            }
            double sum = averageSum / allRating.size();
            allNewRatings.put(entry.getKey(), sum);
        }

        System.out.println("Plants for the exhibition:");
        rarityMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f\n"
                ,entry.getKey(),entry.getValue(),allNewRatings.get(entry.getKey())));




    }
}
