package Programming_f.BasicSyntax.ListsExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){
            List<String> commandList = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            String firstElement = commandList.get(0);

            switch (firstElement){
                case "Delete":
                    int numbersDelete = Integer.parseInt(commandList.get(1));
                    numbers.removeAll(Arrays.asList(numbersDelete));
                    break;

                case "Insert":
                    int numbersInsert = Integer.parseInt(commandList.get(1));
                    int indexInsert = Integer.parseInt(commandList.get(2));
                    numbers.add(indexInsert,numbersInsert);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int num :numbers) {
            System.out.print(num + " ");
        }
    }
}
