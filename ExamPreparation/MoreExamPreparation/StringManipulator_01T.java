package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringManipulator_01T {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("End")){
            List<String> input = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);

            switch (firstCommand){
                case "Translate":
                    String symbol = input.get(1);
                    String replacement = input.get(2);
                    text = text.replace(symbol,replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String checkText = input.get(1);
                    if (text.contains(checkText)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String checkText2 = input.get(1);
                    String startText = text.substring(0,checkText2.length());
                    if (startText.contains(checkText2)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String find = input.get(1);
                    if (text.contains(find)){
                        int word = text.lastIndexOf(find);
                        System.out.println(word);
                    }
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(input.get(1));
                    int count = Integer.parseInt(input.get(2));
                    String substring = text.substring(startIndex,startIndex + count);
                    text = text.replace(substring,"");
                    System.out.println(text);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
