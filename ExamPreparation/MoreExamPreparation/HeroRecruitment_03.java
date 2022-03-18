package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.*;
import java.util.stream.Collectors;

public class HeroRecruitment_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,List<String>> heroesMap = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")){
            List<String> input = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String firstInput = input.get(0);
            String name = input.get(1);

            switch (firstInput){
                case "Enroll":
                if (!heroesMap.containsKey(name)) {
                    heroesMap.put(name,new ArrayList<>());
                }else {
                    System.out.printf("%s is already enrolled!\n",name);
                }
                    break;
                case "Learn":
                    String spellName = input.get(2);
                    if (heroesMap.containsKey(name)){
                        List<String> spells = heroesMap.get(name);
                        if (spells.contains(spellName)){
                            System.out.printf("%s has already learnt %s\n",name,spellName);
                        }else {
                            heroesMap.get(name).add(spellName);
                        }
                    }else {
                        System.out.printf("%s doesn't exist.\n",name);
                    }
                    break;
                case "Unlearn":
                    String spellNames = input.get(2);
                    if (heroesMap.containsKey(name)){
                        List<String> spells = heroesMap.get(name);
                        if (spells.contains(spellNames)) {
                            spells.remove(spellNames);
                        }else {
                            System.out.printf("%s doesn't know %s.\n",name,spellNames);
                        }
                    }else {
                        System.out.printf("%s doesn't exist.\n",name);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Heroes:");
        heroesMap.entrySet().stream()
                .sorted((s1,s2) -> Integer.compare(s2.getValue().size(),s1.getValue().size()))
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    List<String> spell = entry.getValue();
                    System.out.printf("== %s: %s\n",entry.getKey(),spell.toString().replaceAll("[\\[\\]]",""));
                });
    }
}
