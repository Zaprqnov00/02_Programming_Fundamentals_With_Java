package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> mapMaterials = new TreeMap<>();
        mapMaterials.put("shards",0);
        mapMaterials.put("fragments",0);
        mapMaterials.put("motes",0);
        Map<String,Integer> junks = new TreeMap<>();
        boolean gameLose = false;

        while (!gameLose){
            List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            for (int i = 0; i < input.size(); i += 2) {
                int quantity = Integer.parseInt(input.get(i));
                String material = input.get(i + 1).toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")){
                    int currentQuantity = mapMaterials.get(material);
                    mapMaterials.put(material,currentQuantity + quantity);
                    if (mapMaterials.get(material) >= 250){
                        if (material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else if (material.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }else if (material.equals("motes")){
                            System.out.println("Dragonwrath obtained!");
                        }
                        mapMaterials.put(material,mapMaterials.get(material) - 250);
                        gameLose = true;
                        break;
                    }
                }else {
                    if (!junks.containsKey(material)) {
                        junks.put(material,quantity);
                    }else {
                        int currentQuantity = junks.get(material);
                        junks.put(material,currentQuantity + quantity);
                    }
                }
            }
        }
        mapMaterials.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%s: %d\n",entry.getKey(),entry.getValue()));
        junks.entrySet().stream()
                .forEach(entry -> System.out.printf("%s: %d\n",entry.getKey(),entry.getValue()));
    }
}
