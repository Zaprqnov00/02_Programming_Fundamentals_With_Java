package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String,List<String>> mapInformation = new LinkedHashMap<>();

        while (!command.equals("end")){
            List<String> inputList = Arrays
                    .stream(command.split(" : "))
                    .collect(Collectors.toList());
            String courseName = inputList.get(0);
            String studentName = inputList.get(1);

            if (!mapInformation.containsKey(courseName)){
                mapInformation.put(courseName,new ArrayList<>());
                mapInformation.get(courseName).add(studentName);
            }else {
                mapInformation.get(courseName).add(studentName);
            }


            command = scanner.nextLine();
        }

        mapInformation.entrySet().stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue().size(),e1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d\n",entry.getKey(),entry.getValue().size());
                    List<String> students = entry.getValue();
                    for (String student :students) {
                        System.out.printf("-- %s\n",student);
                    }
                });

    }
}
