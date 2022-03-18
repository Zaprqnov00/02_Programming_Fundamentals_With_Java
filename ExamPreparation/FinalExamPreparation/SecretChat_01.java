package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Reveal")){
            List<String> input = Arrays
                    .stream(command.split("[: |]+"))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);

            switch (firstCommand){
                case "InsertSpace":
                    int indexInsert = Integer.parseInt(input.get(1));
                    String first = text.substring(0,indexInsert);
                    String second = text.substring(first.length());
                    text = first + " " + second;
                    System.out.println(text);
                    break;
                case "Reverse":
                    String reverseString = input.get(1);
                    StringBuilder newString = new StringBuilder();
                    if (text.contains(reverseString)){
                        for (int i = reverseString.length() - 1; i >= 0 ; i--) {
                            char symbol = reverseString.charAt(i);
                            newString.append(symbol);
                        }
                        text = text.replace(reverseString, newString.toString());
                        System.out.println(text);
                    }else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substring = input.get(1);
                    String replacement = input.get(2);
                    if (text.contains(substring)) {
                        text = text.replace(substring, replacement);
                        System.out.println(text);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + text);
    }
}
