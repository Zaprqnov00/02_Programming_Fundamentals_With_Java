package Programming_f.BasicSyntax.AssociativeArraysMoreExercices;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Integer>> judgeStudentMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("no more time")){
            String[] input = command.split(" -> ");
            String username = input[0];
            String contest = input[1];
            int points = Integer.parseInt(input[2]);

            if (!judgeStudentMap.containsKey(contest)){
                judgeStudentMap.put(contest,new LinkedHashMap<>());
                judgeStudentMap.get(contest).put(username,points);
            }else {
                if (!judgeStudentMap.get(contest).containsKey(username)){
                    judgeStudentMap.get(contest).put(username,points);
                }else {
                    int currentPoint = judgeStudentMap.get(contest).get(username);
                    if (currentPoint < points){
                        judgeStudentMap.get(contest).put(username,points);
                    }
                }
            }


            command = scanner.nextLine();
        }

        Map<String,Integer> individualMap = new TreeMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : judgeStudentMap.entrySet()) {
            Map<String,Integer> peopleMap = entry.getValue();
            for (Map.Entry<String, Integer> entry2 : peopleMap.entrySet()) {
                String name = entry2.getKey();
                int points = entry2.getValue();

                if (!individualMap.containsKey(name)){
                    individualMap.put(name,points);
                }else {
                    int currentPoints = individualMap.get(name);
                    individualMap.put(name,currentPoints + points);
                }
            }
        }


        AtomicInteger countAllStudent = new AtomicInteger();
        for (Map.Entry<String, Map<String, Integer>> entry : judgeStudentMap.entrySet()) {
            String contestName = entry.getKey();
            System.out.printf("%s: %d participants\n",contestName,entry.getValue().size());
            countAllStudent.set(1);
            Map<String,Integer> allStudentWithPoints = entry.getValue();

            allStudentWithPoints.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(student -> {
                            System.out.printf("%d. %s <::> %d\n",countAllStudent.getAndIncrement(),student.getKey(),student.getValue());
                    });
        }

        AtomicInteger countIndividualStudent = new AtomicInteger();
        System.out.println("Individual standings:");
        countIndividualStudent.set(1);

        individualMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%d. %s -> %d\n",countIndividualStudent.getAndIncrement(),entry.getKey(),entry.getValue()));
    }
}
