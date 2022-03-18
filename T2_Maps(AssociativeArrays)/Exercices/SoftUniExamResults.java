package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String,Integer> mapStudents = new HashMap<>();
        Map<String,Integer> mapLanguage = new HashMap<>();

        while (!command.equals("exam finished")){
                List<String> studentList = Arrays
                        .stream(command.split("-"))
                        .collect(Collectors.toList());
                String username = studentList.get(0);

                if (studentList.size() == 3) {
                    String programmingLanguage = studentList.get(1);
                    int points = Integer.parseInt(studentList.get(2));
                    if (!mapStudents.containsKey(username)) {
                        mapStudents.put(username, points);
                    } else {
                        int currentPoints = mapStudents.get(username);
                        if (points > currentPoints) {
                            mapStudents.put(username, points);
                        }
                    }

                    if (!mapLanguage.containsKey(programmingLanguage)) {
                        mapLanguage.put(programmingLanguage, 1);
                    } else {
                        mapLanguage.put(programmingLanguage, mapLanguage.get(programmingLanguage) + 1);
                    }
                }else {
                    mapStudents.remove(username);
                }

            command = scanner.nextLine();
        }
        System.out.println("Results: ");
        mapStudents.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%s | %d\n",entry.getKey(),entry.getValue()));
        System.out.println("Submissions: ");
        mapLanguage.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .sorted((Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.printf("%s - %d\n",entry.getKey(),entry.getValue()));
    }
}
