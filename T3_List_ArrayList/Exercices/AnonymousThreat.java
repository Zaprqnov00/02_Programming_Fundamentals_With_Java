package Programming_f.BasicSyntax.ListsExercices;

import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        List<String> finishText = new ArrayList<>();

        while (!command.equals("3:1")){
            List<String> input = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String firstInput = input.get(0);

            switch (firstInput){
                case "merge":
                    int startIndex = Integer.parseInt(input.get(1));
                    int endIndex = Integer.parseInt(input.get(2));
                    String newText = "";
                    for (int i = startIndex; i <= endIndex ; i++) {
                        newText += text.get(i);
                    }
                    finishText.add(newText);
                    break;
                case "divide":
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
