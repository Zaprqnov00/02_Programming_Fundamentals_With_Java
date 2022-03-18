package Programming_f.BasicSyntax.AssociativeArraysMoreExercices;

import java.util.*;

public class MOBAChallenger_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Integer>> leagueOfLegendsPlayers = new TreeMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Season end")){
            String[] input = command.split(" ");
            if (input.length == 3){
                String firstPlayer = input[0];
                String secondPlayer = input[2];
                Map<String, Integer> positionFirstPlayer = leagueOfLegendsPlayers.get(firstPlayer);
                Map<String, Integer> positionSecondPlayer = leagueOfLegendsPlayers.get(secondPlayer);
                if (leagueOfLegendsPlayers.containsKey(firstPlayer) && leagueOfLegendsPlayers.containsKey(secondPlayer)){
                    for (Map.Entry<String, Integer> entry : positionSecondPlayer.entrySet()) {
                        String positionSecond = entry.getKey();
                        int skillBush = entry.getValue();
                        for (Map.Entry<String, Integer> entry2 : positionFirstPlayer.entrySet()) {
                            String positionFirst = entry2.getKey();
                            int skillFaker = entry2.getValue();
                            if (positionSecond.equals(positionFirst)){
                                if (skillFaker > skillBush){
                                    leagueOfLegendsPlayers.remove(secondPlayer);
                                }else if (skillFaker < skillBush){
                                    leagueOfLegendsPlayers.remove(firstPlayer);
                                }
                            }
                        }
                    }
                }
            }else {
                String[] secondInput = command.split(" -> ");
                String player = secondInput[0];
                String position = secondInput[1];
                int skill = Integer.parseInt(secondInput[2]);

                if (!leagueOfLegendsPlayers.containsKey(player)){
                    leagueOfLegendsPlayers.put(player,new LinkedHashMap<>());
                    leagueOfLegendsPlayers.get(player).put(position,skill);
                }else {
                    if (!leagueOfLegendsPlayers.get(player).containsKey(position)){
                        leagueOfLegendsPlayers.get(player).put(position,skill);
                    }else {
                        int currentSkill = leagueOfLegendsPlayers.get(player).get(position);
                        if (skill > currentSkill){
                            leagueOfLegendsPlayers.get(player).put(position,skill);
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }


        Map<String,Integer> totalSkillPoints = new TreeMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : leagueOfLegendsPlayers.entrySet()) {

            int totalPoints = 0;
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                int points = entry2.getValue();
                totalPoints += points;
            }

            totalSkillPoints.put(entry.getKey(),totalPoints);
        }

        leagueOfLegendsPlayers.entrySet().stream()
                .sorted((c1,c2) -> totalSkillPoints.get(c2.getKey()).compareTo(totalSkillPoints.get(c1.getKey())))
                .forEach(entry -> {
                    System.out.printf("%s: %d skill\n",entry.getKey(),totalSkillPoints.get(entry.getKey()));
                    entry.getValue().entrySet().stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .forEach(entry2 -> {
                                System.out.printf("- %s <::> %d\n",entry2.getKey(),entry2.getValue());
                            });
                });


    }
}
