package Programming_f.BasicSyntax.AssociativeArraysMoreExercices;

import java.util.*;

public class SnowWhite_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Integer>> safeDwarfMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Once upon a time")){
            String[] input = command.split(" <:> ");
            String name = input[0];
            String colour = input[1];
            int points = Integer.parseInt(input[2]);

            if (!safeDwarfMap.containsKey(name)){
                safeDwarfMap.put(name,new LinkedHashMap<>());
                safeDwarfMap.get(name).put(colour,points);
            }else {
                if (!safeDwarfMap.get(name).containsKey(colour)){
                    safeDwarfMap.get(name).put(colour,points);
                }else {
                    int currentPoints = safeDwarfMap.get(name).get(colour);
                    if (currentPoints < points){
                        safeDwarfMap.get(name).put(colour,points);
                    }
                }
            }

            command = scanner.nextLine();
        }

        Map<String, Integer> print = new LinkedHashMap<>();

        for(Map.Entry<String, Map<String, Integer>> entry : safeDwarfMap.entrySet()) {
            for(Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                print.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
            }
        }
        print.entrySet().stream().sorted((pair2, pair1) -> {
            int sort = Integer.compare(pair1.getValue(), pair2.getValue());
            if (sort == 0) {
                String[] sort1 = pair1.getKey().split(" ");
                String[] sort2 = pair2.getKey().split(" ");
                sort = sort1[2].compareTo(sort2[2]);
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", printing[1], printing[0], pair.getValue());
        });


    }
}
