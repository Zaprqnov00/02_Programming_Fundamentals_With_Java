package Programming_f.BasicSyntax.AssociativeArraysMoreExercices;

import java.util.*;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> enterExamMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("end of contests")){
            String[] input = command.split(":");
            String contest = input[0];
            String passwordContest = input[1];

            if (!enterExamMap.containsKey(contest)){
                enterExamMap.put(contest,passwordContest);
            }

            command = scanner.nextLine();
        }

        Map<String,Map<String,Integer>> studentExamMap = new TreeMap<>();

        String secondCommand = scanner.nextLine();
        while (!secondCommand.equals("end of submissions")){
            String[] secondInput = secondCommand.split("=>");
            String contest = secondInput[0];
            String password = secondInput[1];
            String username = secondInput[2];
            int points = Integer.parseInt(secondInput[3]);

            if (enterExamMap.containsKey(contest) && enterExamMap.containsValue(password)){

                if (!studentExamMap.containsKey(username)){
                    studentExamMap.put(username,new LinkedHashMap<>());
                    studentExamMap.get(username).put(contest,points);
                }else {
                    if (studentExamMap.get(username).containsKey(contest)){
                        int currentPoints = studentExamMap.get(username).get(contest);
                        if (currentPoints < points){
                            studentExamMap.get(username).put(contest,points);
                        }
                    }else {
                        studentExamMap.get(username).put(contest,points);
                    }
                }
            }

            secondCommand = scanner.nextLine();
        }

        List<String> nameStudent = new ArrayList<>();
        List<Integer> pointsStudent = new ArrayList<>();
        pointsStudent.add(0);
        nameStudent.add("");

        for (Map.Entry<String, Map<String, Integer>> entry : studentExamMap.entrySet()) {
            String name = entry.getKey();
            Map<String,Integer> gradesMap = entry.getValue();
            int totalPoints = 0;
            for (Map.Entry<String, Integer> entry2 : gradesMap.entrySet()) {
                int points = entry2.getValue();
                totalPoints += points;
            }

            if (pointsStudent.get(0) < totalPoints){
                nameStudent.set(0,name);
                pointsStudent.set(0,totalPoints);
            }
        }

        System.out.printf("Best candidate is %s with total %s points.\n",nameStudent.toString().replaceAll("[\\[\\],]","")
        ,pointsStudent.toString().replaceAll("[\\[\\],]",""));
        System.out.println("Ranking: ");

        for (Map.Entry<String, Map<String, Integer>> entry : studentExamMap.entrySet()) {
            String studentName = entry.getKey();
            Map<String,Integer> pointMap = entry.getValue();
            System.out.println(studentName);
            pointMap.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(entry2 -> System.out.printf("#  %s -> %d\n",entry2.getKey(),entry2.getValue()));
        }


    }
}
