package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.*;
import java.util.stream.Collectors;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> healthMap = new TreeMap<>();
        Map<String,Integer> manaMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            List<String> input = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
            String heroName = input.get(0);
            int hp = Integer.parseInt(input.get(1));
            int mp = Integer.parseInt(input.get(2));

            if (hp <= 100){
                healthMap.put(heroName,hp);
            }
            if (mp <= 200){
                manaMap.put(heroName,mp);
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("End")){
            List<String> playCommand = Arrays
                    .stream(command.split(" - "))
                    .collect(Collectors.toList());
            String firstCommand = playCommand.get(0);
            String heroName = playCommand.get(1);

            switch (firstCommand){
                case "CastSpell":
                    int manaNeed = Integer.parseInt(playCommand.get(2));
                    String spellName = playCommand.get(3);
                    int currentMana = manaMap.get(heroName);
                    if (currentMana >= manaNeed){
                        currentMana -= manaNeed;
                        manaMap.put(heroName,currentMana);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",heroName,spellName,currentMana);
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!\n",heroName,spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(playCommand.get(2));
                    String attacker = playCommand.get(3);
                    int currentHP = healthMap.get(heroName);
                    currentHP -= damage;
                    if (currentHP > 0){
                        healthMap.put(heroName,currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",heroName,damage,attacker,currentHP);
                    }else {
                        healthMap.remove(heroName);
                        manaMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!\n",heroName,attacker);
                    }
                    break;
                case "Recharge":
                    int manaRecharge = Integer.parseInt(playCommand.get(2));
                    int currentManaRecharge = manaMap.get(heroName);
                    currentManaRecharge += manaRecharge;
                    if (currentManaRecharge <= 200){
                        manaMap.put(heroName,currentManaRecharge);
                        System.out.printf("%s recharged for %d MP!\n",heroName,manaRecharge);
                    }
                    if (currentManaRecharge > 200){
                        manaRecharge = Math.abs((currentManaRecharge - 200) - manaRecharge);
                        manaMap.put(heroName,200);
                        System.out.printf("%s recharged for %d MP!\n",heroName,manaRecharge);
                    }
                    break;
                case "Heal":
                int healCommand = Integer.parseInt(playCommand.get(2));
                int currentHealth = healthMap.get(heroName);
                    currentHealth += healCommand;
                    if (currentHealth <= 100){
                        healthMap.put(heroName,currentHealth);
                        System.out.printf("%s healed for %d HP!\n",heroName,healCommand);
                    }
                    if (currentHealth > 100) {
                            healCommand = Math.abs((currentHealth - 100) - healCommand);
                            healthMap.put(heroName,100);
                        System.out.printf("%s healed for %d HP!\n",heroName,healCommand);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        healthMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    System.out.printf("%s\n",entry.getKey());
                    System.out.printf("  HP: %d\n",entry.getValue());
                    System.out.printf("  MP: %d\n",manaMap.get(entry.getKey()));
                });
    }
}
