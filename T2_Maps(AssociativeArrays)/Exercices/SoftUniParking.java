package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,String> mapInformation = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> command = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
            String firstCommand = command.get(0);
            String username = command.get(1);

            switch (firstCommand){
                case "register":
                    String licensePlateNumber = command.get(2);
                    if (!mapInformation.containsKey(username)){
                        mapInformation.put(username,licensePlateNumber);
                        System.out.printf("%s registered %s successfully\n",username,licensePlateNumber);
                    }else {
                        System.out.printf("ERROR: already registered with plate number %s\n",licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!mapInformation.containsKey(username)){
                        System.out.printf("ERROR: user %s not found\n",username);
                    }else {
                        mapInformation.remove(username);
                        System.out.printf("%s unregistered successfully\n",username);
                    }
                    break;

            }
        }
        for (Map.Entry<String, String> entry : mapInformation.entrySet()) {
            System.out.printf("%s => %s\n",entry.getKey(),entry.getValue());
        }

    }
}
