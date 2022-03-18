package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.*;
import java.util.stream.Collectors;

public class MessagesManager_03T {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxMessages = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> sendMap = new TreeMap<>();
        Map<String,Integer> receivedMap = new TreeMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Statistics")){
            List<String> input = Arrays
                    .stream(command.split("="))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);

            switch (firstCommand){
                case "Add":
                    String username = input.get(1);
                    int send = Integer.parseInt(input.get(2));
                    int received = Integer.parseInt(input.get(3));
                    if (!sendMap.containsKey(username) && !receivedMap.containsKey(username)){
                        sendMap.put(username,send);
                        receivedMap.put(username,received);
                    }
                    break;
                case "Message":
                    String sender = input.get(1);
                    String receiver = input.get(2);
                    if (sendMap.containsKey(sender) && sendMap.containsKey(receiver)){
                        int currentSend = sendMap.get(sender);
                        sendMap.put(sender,currentSend + 1);
                        int currentReceived = receivedMap.get(receiver);
                        receivedMap.put(receiver,currentReceived + 1);
                    }
                    int currentSend = sendMap.get(sender);
                    int currentSend2 = receivedMap.get(sender);
                    int currentReceived = receivedMap.get(receiver);
                    int currentRecieved2 = sendMap.get(receiver);
                    if (currentSend + currentSend2  >= maxMessages){
                        sendMap.remove(sender);
                        receivedMap.remove(sender);
                        System.out.printf("%s reached the capacity!\n",sender);
                    }
                    if (currentReceived + currentRecieved2 >= maxMessages){
                        sendMap.remove(receiver);
                        receivedMap.remove(receiver);
                        System.out.printf("%s reached the capacity!\n",receiver);
                    }
                    break;
                case "Empty":
                        String usernameEmpty = input.get(1);
                        if (sendMap.containsKey(usernameEmpty) && receivedMap.containsKey(usernameEmpty)){
                            sendMap.remove(usernameEmpty);
                            receivedMap.remove(usernameEmpty);
                        }
                        if (usernameEmpty.equals("All")){
                            sendMap.clear();
                            receivedMap.clear();
                        }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Users count: %d\n",sendMap.size());

        Map<String,Integer> usernames = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : sendMap.entrySet()) {
            int sum = 0;
            int sendMessage = entry.getValue();
            int receivedMessage = receivedMap.get(entry.getKey());
            sum = sendMessage + receivedMessage;

            usernames.put(entry.getKey(), sum);
        }

        usernames.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%s - %d\n",entry.getKey(),entry.getValue()));
    }
}
