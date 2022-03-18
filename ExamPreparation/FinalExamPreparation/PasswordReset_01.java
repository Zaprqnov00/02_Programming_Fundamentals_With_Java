package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Done")){
            List<String> input = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);

            switch (firstCommand){
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        char symbol = password.charAt(i);
                        newPassword.append(symbol);
                    }
                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(input.get(1));
                    int length = Integer.parseInt(input.get(2));
                    StringBuilder cutWords = new StringBuilder(password);
                    cutWords.replace(startIndex,startIndex + length,"");
                    password = cutWords.toString();
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = input.get(1);
                    String replace = input.get(2);
                    if (password.contains(substring)){
                        password = password.replace(substring,replace);
                        System.out.println(password);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
