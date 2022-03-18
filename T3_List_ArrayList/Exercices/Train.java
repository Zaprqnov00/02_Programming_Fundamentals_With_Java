package Programming_f.BasicSyntax.ListsExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")){
            List<String> commandList = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            if (commandList.get(0).equals("Add")){
                int numbers = Integer.parseInt(commandList.get(1));
                wagons.add(numbers);
            }else {
                int countPassenger = Integer.parseInt(commandList.get(0));
                for (int i = 0; i < wagons.size(); i++) {
                    int wagonsPassengers = wagons.get(i);
                    if (countPassenger + wagonsPassengers <= maxCapacity){
                        wagons.set(i,countPassenger + wagonsPassengers);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]",""));
    }
}
