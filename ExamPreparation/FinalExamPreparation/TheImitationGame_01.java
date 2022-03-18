package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Decode")){
            List<String> input = Arrays
                    .stream(command.split("\\|"))
                    .collect(Collectors.toList());

            String firstCommand = input.get(0);
            switch (firstCommand){
                case "Move":
                    int moveNumbers = Integer.parseInt(input.get(1));
                    String addSymbols = "";
                    for (int i = 0; i < moveNumbers ; i++) {
                        char symbol = encryptedMessage.charAt(i);
                        addSymbols += symbol;
                    }
                    encryptedMessage = encryptedMessage.replace(addSymbols,"");
                    encryptedMessage = encryptedMessage.concat(addSymbols);
//                    String first = encryptedMessage.substring(0,moveNumbers);
//                    String second = encryptedMessage.substring(first.length());
//                    encryptedMessage = second.concat(first);
                    break;
                case "Insert":
                    int indexInsert = Integer.parseInt(input.get(1));
                    String value = input.get(2);
                    StringBuilder insertBuilder = new StringBuilder(encryptedMessage);
                    insertBuilder.insert(indexInsert,value);
                    encryptedMessage = insertBuilder.toString();
                    break;
                case "ChangeAll":
                    String substring = input.get(1);
                    String replace = input.get(2);
                    encryptedMessage = encryptedMessage.replace(substring,replace);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}
