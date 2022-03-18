package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            List<String> commandList = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String inputCommand = commandList.get(0);

            switch (inputCommand) {
                case "swap":
                    int firstIndex = Integer.parseInt(commandList.get(1));
                    int secondIndex = Integer.parseInt(commandList.get(2));
                    int firstDigit = numbers.get(firstIndex);
                    int secondDigit = numbers.get(secondIndex);
                    numbers.set(firstIndex,secondDigit);
                    numbers.set(secondIndex,firstDigit);
                  break;

                case "multiply":
                    int firstIndex1 = Integer.parseInt(commandList.get(1));
                    int secondIndex2 = Integer.parseInt(commandList.get(2));
                    int firstNumber = numbers.get(firstIndex1);
                    int secondNumber = numbers.get(secondIndex2);
                    numbers.set(firstIndex1,firstNumber * secondNumber);
                    break;

                case "decrease":

                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i,numbers.get(i) - 1);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replace("[","").replace("]",""));

    }
}
