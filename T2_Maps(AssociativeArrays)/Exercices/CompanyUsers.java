package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> mapCompany = new TreeMap<>();

        while (!command.equals("End")) {
            List<String> inputList = Arrays
                    .stream(command.split(" -> "))
                    .collect(Collectors.toList());
            String companyName = inputList.get(0);
            String id = inputList.get(1);

            if (!mapCompany.containsKey(companyName)) {
                mapCompany.put(companyName,new ArrayList<>());
                mapCompany.get(companyName).add(id);
            } else {
                List<String> employ = mapCompany.get(companyName);
                if (!employ.contains(id)){
                    employ.add(id);
                }

            }

                command = scanner.nextLine();
            }

           mapCompany.entrySet().stream()
                   .sorted((Map.Entry.comparingByKey()))
                   .forEach(company -> {
                       System.out.println(company.getKey());
                       company.getValue().forEach(employ -> System.out.println("-- " + employ));
                   });

    }
}