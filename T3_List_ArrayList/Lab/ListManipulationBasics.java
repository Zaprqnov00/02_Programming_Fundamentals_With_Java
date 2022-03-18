package Programming_f.BasicSyntax.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){
            List<String> line = Arrays
                            .stream(command.split(" "))
                    .collect(Collectors.toList());

           switch (line.get(0)){
               case "Add":
                   int numberAdd = Integer.parseInt(line.get(1));
                   numbers.add(numberAdd);
                   break;
               case "Remove":
                   int numberRemoveValue = Integer.parseInt(line.get(1));
                   numbers.remove(Integer.valueOf(numberRemoveValue));
                   break;
               case "RemoveAt":
                   int numberRemove = Integer.parseInt(line.get(1));
                   numbers.remove(numberRemove);
                   break;
               case "Insert":
                   int numberInsert = Integer.parseInt(line.get(1));
                   int indexInsert = Integer.parseInt(line.get(2));
                   numbers.add(indexInsert,numberInsert);
                   break;
           }

            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
