package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.*;
import java.util.stream.Collectors;

public class BattleManager_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> healthMap = new LinkedHashMap<>();
        Map<String,Integer> energyMap = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Results")){
            List<String> input = Arrays
                    .stream(command.split(":"))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);

            switch (firstCommand){
                case "Add":
                    String name = input.get(1);
                    int health = Integer.parseInt(input.get(2));
                    int energy = Integer.parseInt(input.get(3));
                    if (!healthMap.containsKey(name) && !energyMap.containsKey(name)){
                        healthMap.put(name,health);
                        energyMap.put(name,energy);
                    }else {
                        int currentHealth = healthMap.get(name);
                        healthMap.put(name,currentHealth + health);
                    }
                    break;
                case "Attack":
                    String attacker = input.get(1);
                    String defender = input.get(2);
                    int damage = Integer.parseInt(input.get(3));
                    if (healthMap.containsKey(attacker) && healthMap.containsKey(defender) && energyMap.containsKey(attacker)
                    && energyMap.containsKey(defender)){
                    int currentHealth = healthMap.get(defender);
                    currentHealth -= damage;
                    int currentEnergy = energyMap.get(attacker);
                    currentEnergy -= 1;
                    if (currentHealth <= 0){
                        healthMap.remove(defender);
                        energyMap.remove(defender);
                        System.out.printf("%s was disqualified!\n",defender);
                    }else {
                        healthMap.put(defender,currentHealth);
                    }
                    if (currentEnergy <= 0){
                        healthMap.remove(attacker);
                        energyMap.remove(attacker);
                        System.out.printf("%s was disqualified!\n",attacker);
                    }else {
                        energyMap.put(attacker,currentEnergy);
                    }
                    }
                    break;
                case "Delete":
                    String username = input.get(1);
                    if (username.equals("All")){
                        healthMap.clear();
                        energyMap.clear();
                    }else {
                        if (healthMap.containsKey(username) && energyMap.containsKey(username)){
                            healthMap.remove(username);
                            energyMap.remove(username);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("People count: %d\n",healthMap.size());

        healthMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%s - %d - %d\n",entry.getKey(),entry.getValue(),energyMap.get(entry.getKey())));
    }
}
