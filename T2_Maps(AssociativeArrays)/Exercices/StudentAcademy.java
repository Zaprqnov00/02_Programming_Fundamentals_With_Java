package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,List<Double>> mapStudentsGrade = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!mapStudentsGrade.containsKey(studentName)){
                mapStudentsGrade.put(studentName,new ArrayList<>());
                mapStudentsGrade.get(studentName).add(grade);
            }else {
                mapStudentsGrade.get(studentName).add(grade);
            }
        }

        Map<String,Double> mapAverageGrade = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : mapStudentsGrade.entrySet()) {
            List<Double> allGrades = entry.getValue();
            int countGrade = entry.getValue().size();
            double sumGrades = 0;
            for (int i = 0; i < allGrades.size(); i++) {
                sumGrades += allGrades.get(i);
            }
            double averageGrade = sumGrades / countGrade;
            if (averageGrade >= 4.50){
                mapAverageGrade.put(entry.getKey(), averageGrade);
            }
        }
        mapAverageGrade.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%s -> %.2f\n",entry.getKey(),entry.getValue()));

    }
}
