package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Generate")){
            List<String> input = Arrays
                    .stream(command.split(">>>"))
                    .collect(Collectors.toList());

            String firstCommand = input.get(0);

            switch (firstCommand){
                case "Contains":
                    String substring = input.get(1);
                    if (key.contains(substring)){
                        System.out.printf("%s contains %s\n",key,substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = input.get(1);
                    int start = Integer.parseInt(input.get(2));
                    int end = Integer.parseInt(input.get(3));
                    if (upperOrLower.equals("Upper")){
                        String upperCase = key.substring(start,end).toUpperCase();
                        String words = key.substring(start,end);
                        key = key.replace(words,upperCase);
                        System.out.println(key);
                    }else if (upperOrLower.equals("Lower")){
                        String lowerCase = key.substring(start,end).toLowerCase();
                        String words = key.substring(start,end);
                        key = key.replace(words,lowerCase);
                        System.out.println(key);
                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(input.get(1));
                    int endIndex = Integer.parseInt(input.get(2));
                    String substringKey = key.substring(startIndex,endIndex);
                    key = key.replace(substringKey,"");
                    System.out.println(key);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + key);
    }
}
