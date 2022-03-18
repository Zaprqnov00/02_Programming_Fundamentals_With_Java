package Programming_f.BasicSyntax.AssociativeArraysMoreExercices;

import java.util.*;

public class DragonArmy_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, TreeMap<String, List<Integer>>> dragonsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String colour = input[0];
            String name = input[1];
            String damage = input[2];
            String health = input[3];
            String armor = input[4];

            if (damage.equals("null")) {
                int newDamage = 45;
                if (!dragonsMap.containsKey(colour)) {
                    dragonsMap.put(colour, new TreeMap<>());
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(newDamage);
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(health));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(armor));
                } else {
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(newDamage);
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(health));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(armor));
                }
            }else if (health.equals("null")) {
                int newHealth = 250;
                if (!dragonsMap.containsKey(colour)) {
                    dragonsMap.put(colour, new TreeMap<>());
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(damage));
                    dragonsMap.get(colour).get(name).add(newHealth);
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(armor));
                } else {
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(damage));
                    dragonsMap.get(colour).get(name).add(newHealth);
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(armor));
                }
            }else if (armor.equals("null")){
                int newArmor = 10;
                if (!dragonsMap.containsKey(colour)) {
                    dragonsMap.put(colour, new TreeMap<>());
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(damage));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(health));
                    dragonsMap.get(colour).get(name).add(newArmor);
                } else {
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(damage));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(health));
                    dragonsMap.get(colour).get(name).add(newArmor);
                }
            }else {
                if (!dragonsMap.containsKey(colour)) {
                    dragonsMap.put(colour, new TreeMap<>());
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(damage));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(health));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(armor));
                } else {
                    dragonsMap.get(colour).put(name, new ArrayList<>());
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(damage));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(health));
                    dragonsMap.get(colour).get(name).add(Integer.parseInt(armor));
                }
            }
        }

        Map<String,List<Double>> averageStatusDragons = new LinkedHashMap<>();

        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : dragonsMap.entrySet()) {
            String colourDragon = entry.getKey();

            double totalDamage = 0;
            int countDamages = 0;
            double totalHealth = 0;
            int countHealth = 0;
            double totalArmor = 0;
            int countArmor = 0;
            for (Map.Entry<String, List<Integer>> setEntry : entry.getValue().entrySet()) {
                List<Integer> statusDragons = setEntry.getValue();
                int damagePerDragon = statusDragons.get(0);
                int healthPerDragon = statusDragons.get(1);
                int armorPerDragon = statusDragons.get(2);
                totalDamage += damagePerDragon;
                countDamages++;
                totalHealth += healthPerDragon;
                countHealth++;
                totalArmor += armorPerDragon;
                countArmor++;
            }
            double averageDamage = totalDamage / countDamages;
            double averageHealth = totalHealth / countHealth;
            double averageArmor = totalArmor / countArmor;

            averageStatusDragons.put(colourDragon,new ArrayList<>());
            averageStatusDragons.get(colourDragon).add(averageDamage);
            averageStatusDragons.get(colourDragon).add(averageHealth);
            averageStatusDragons.get(colourDragon).add(averageArmor);
        }

        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : dragonsMap.entrySet()) {
            String colourDragon = entry.getKey();

            double damage = 0;
            double health = 0;
            double armor = 0;
            for (Map.Entry<String, List<Double>> setEntry : averageStatusDragons.entrySet()) {
                List<Double> allAverageStatusDragon = setEntry.getValue();
                    damage = allAverageStatusDragon.get(0);
                    health = allAverageStatusDragon.get(1);
                    armor = allAverageStatusDragon.get(2);
                averageStatusDragons.remove(setEntry.getKey());
                break;
            }

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",colourDragon,damage,health,armor);

            for (Map.Entry<String, List<Integer>> setEntry : entry.getValue().entrySet()) {
                String dragonName = setEntry.getKey();
                List<Integer> skillsDragon = setEntry.getValue();

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",dragonName,skillsDragon.get(0),skillsDragon.get(1)
                ,skillsDragon.get(2));
            }

        }

    }
}
