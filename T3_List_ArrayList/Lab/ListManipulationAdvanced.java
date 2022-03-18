package Programming_f.BasicSyntax.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){
            List<String> listCommand = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            switch (listCommand.get(0)){
                case "Contains":
                    int numberContains = Integer.parseInt(listCommand.get(1));
                    if (numbers.contains(numberContains)){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No such number");
                    }
                    break;

                case "Print":
                    String commandPrint = listCommand.get(1);
                    if (commandPrint.equals("even")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    if (commandPrint.equals("odd")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;

                case "Get":
                    String secondGetIndex = listCommand.get(1);
                    int sum = 0;
                    if (secondGetIndex.equals("sum")){
                        for (int i = 0; i < numbers.size(); i++) {
                            sum += numbers.get(i);
                        }
                    }
                    System.out.println(sum);
                    break;

                case "Filter":
                    String conditional = listCommand.get(1);
                    int numberFilter = Integer.parseInt(listCommand.get(2));
                    if (conditional.equals(">=")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) >= numberFilter){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    if (conditional.equals("<")){
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < numberFilter){
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                 }
                    if (conditional.equals("<=")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) <= numberFilter){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    if (conditional.equals(">")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) > numberFilter){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;

            }
            command = scanner.nextLine();
        }
    }
}
