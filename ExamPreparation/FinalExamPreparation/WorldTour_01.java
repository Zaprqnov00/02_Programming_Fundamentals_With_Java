package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Travel")){
            List<String> input = Arrays
                    .stream(command.split(":"))
                    .collect(Collectors.toList());

            String firstCommand = input.get(0);
            switch (firstCommand){
                case "Add Stop":
                    int index = Integer.parseInt(input.get(1));
                    String insertCity = input.get(2);
                    StringBuilder stringBuilderInsert = new StringBuilder(text);
                    if (index >= 0 && index <= text.length()) {
                        stringBuilderInsert.insert(index, insertCity);
                        text = stringBuilderInsert.toString();
                    }
                    System.out.println(text);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input.get(1));
                    int endIndex = Integer.parseInt(input.get(2));
                    if (startIndex >= 0 && endIndex <= text.length()){
                        StringBuilder removeWords = new StringBuilder();
                        for (int i = startIndex; i <= endIndex ; i++) {
                            char symbol = text.charAt(i);
                            removeWords.append(symbol);
                        }
                        text = text.replace(removeWords.toString(),"");
                    }
                    System.out.println(text);
                    break;
                case "Switch":
                    String oldCity = input.get(1);
                    String newCity = input.get(2);
                    if (text.contains(oldCity)){
                        text = text.replace(oldCity,newCity);
                    }
                    System.out.println(text);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + text);
    }
}
