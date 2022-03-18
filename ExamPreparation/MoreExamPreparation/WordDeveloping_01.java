package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordDeveloping_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "";
        String command = scanner.nextLine();

        while (!command.equals("End")){
            List<String> input = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);

            switch (firstCommand){
                case "Add":
                    String substring = input.get(1);
                    text = command.replace(command,substring);
                    break;
                case "Print":
                    System.out.println(text);
                    break;
                case "Upgrade":
                    String charWord = input.get(1);
                    char symbol = charWord.charAt(0);
                    char secondSymbol = (char) (symbol + 1);
                    text = text.replace(symbol,secondSymbol);
                    break;
                case "Index":
                    String searchChar = input.get(1);
                    if (text.contains(searchChar)){
                        int firstIndex = text.indexOf(searchChar);
                        int secondIndex = text.lastIndexOf(searchChar);
                        System.out.println(firstIndex + " " + secondIndex);
                    }else {
                        System.out.println("None");
                    }
                    break;
                case "Remove":
                    String removeSubstring = input.get(1);
                    text = text.replaceAll(removeSubstring,"");
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
