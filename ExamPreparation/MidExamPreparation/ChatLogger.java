package Programming_f.BasicSyntax.MidExamExercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<String> inputMessages = new ArrayList<>();
        while (!command.equals("end")){
            List<String> commandList = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            String firstCommand = commandList.get(0);
            String message = commandList.get(1);
            switch (firstCommand){
                case "Chat":
                    inputMessages.add(message);
                    break;

                case "Delete":
                    if (inputMessages.contains(message)){
                        inputMessages.remove(message);
                    }
                    break;

                case "Edit":
                    String editMessage = commandList.get(2);
                    int index = inputMessages.indexOf(message);
                    if (inputMessages.contains(message)){
                        inputMessages.set(index,editMessage);
                    }
                    break;

                case "Pin":
                    int indexPin = inputMessages.size() - 1;
                    if (inputMessages.contains(message)){
                        inputMessages.add(indexPin,message);
                    }
                    break;

                case "Spam":
                    for (int i = 1; i < commandList.size(); i++) {
                        String messageSpam = commandList.get(i);
                        inputMessages.add(messageSpam);
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        for (String message :inputMessages) {
            System.out.println(message + " ");
        }
    }
}

