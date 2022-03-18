package Programming_f.BasicSyntax.ListsExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")){
            List<String> listCommand = Arrays
                    .stream(command.split("\\s+"))
                    .collect(Collectors.toList());

            String firstElement = listCommand.get(0);

            switch (firstElement){
                case "Add":
                    int numberAdd = Integer.parseInt(listCommand.get(1));
                    numbers.add(numberAdd);
                    break;

                case "Insert":
                    int numberInsert = Integer.parseInt(listCommand.get(1));
                    int indexInsert = Integer.parseInt(listCommand.get(2));
                    if (isValidIndex(indexInsert,numbers.size())){
                        numbers.add(indexInsert,numberInsert);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    int indexRemove = Integer.parseInt(listCommand.get(1));
                    if (isValidIndex(indexRemove,numbers.size())){
                        numbers.remove(indexRemove);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Shift":
                    String commandShift = listCommand.get(1);
                    int countShift = Integer.parseInt(listCommand.get(2));
                    if (commandShift.equals("left")){
                        shiftLeft(numbers,countShift);
                    }else if (commandShift.equals("right")){
                        shiftRight(numbers,countShift);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        for (int num :numbers) {
            System.out.print(num + " ");
        }
    }

    private static void shiftRight(List<Integer> numbers, int countShift) {
        for (int i = 0; i < countShift; i++) {
            int lastNumber = numbers.get(numbers.size() - 1);
            numbers.add(0,lastNumber);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> numbers,int countShift) {
        for (int i = 0; i < countShift; i++) {
            int firstNumber = numbers.get(0);
            numbers.add(firstNumber);
            numbers.remove(0);
        }

    }

    public static boolean isValidIndex (int index, int size){

        return index >= 0 && index <= size - 1;
    }
}
