package Programming_f.BasicSyntax.AssociativeArraysMoreExercices.DragonArmyClasses;

import java.util.*;

class Dragons {
    private String dragonName;
    private int damage;
    private int health;
    private int armor;

    public Dragons(String dragonName, int damage, int health, int armor) {
        this.dragonName = dragonName;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public String getDragonName() {
        return dragonName;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Dragons>> dragonsMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String colour = input[0];
            String dragonName = input[1];
            int damage = 0;
            int health = 0;
            int armor = 0;
            if (input[2].equals("null")){
                damage = 45;
            }else {
                damage = Integer.parseInt(input[2]);
            }
            if (input[3].equals("null")){
                health = 250;
            }else {
                health = Integer.parseInt(input[3]);
            }
            if (input[4].equals("null")){
                armor = 10;
            }else {
                armor = Integer.parseInt(input[4]);
            }
            Dragons dragons = new Dragons(dragonName,damage,health,armor);
            if (!dragonsMap.containsKey(colour)){
                dragonsMap.put(colour,new ArrayList<>());
                dragonsMap.get(colour).add(dragons);
            }else {
                dragonsMap.get(colour).add(dragons);
            }
        }


        for (Map.Entry<String, List<Dragons>> entry : dragonsMap.entrySet()) {
            double allDamage = 0;
            double allHealth = 0;
            double allArmor = 0;
            for (Dragons dragon : entry.getValue()) {
                allDamage += dragon.getDamage();
                allHealth += dragon.getHealth();
                allArmor += dragon.getArmor();
            }
            double averageDamage = allDamage / entry.getValue().size();
            double averageHealth = allHealth / entry.getValue().size();
            double averageArmor = allArmor / entry.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",entry.getKey(),averageDamage,averageHealth,averageArmor);
            entry.getValue().sort(Comparator.comparing(Dragons::getDragonName));
            for (Dragons dragon :entry.getValue()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",dragon.getDragonName(),dragon.getDamage(),dragon.getHealth()
                ,dragon.getArmor());
            }

        }

    }
}
