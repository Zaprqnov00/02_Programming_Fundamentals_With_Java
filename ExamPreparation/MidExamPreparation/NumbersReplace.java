package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumbersReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Finish")){
            List<String> input = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);
            int value = Integer.parseInt(input.get(1));

            switch (firstCommand){
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    int indexRemove = numbers.indexOf(value);
                    numbers.remove(indexRemove);
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(input.get(2));
                    int indexValue = numbers.indexOf(value);
                    numbers.set(indexValue,replacement);
                    break;
                case "Collapse":
                    for (int i = 0; i < numbers.size(); i++) {
                        if (i < value){
                            numbers.remove(i);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
