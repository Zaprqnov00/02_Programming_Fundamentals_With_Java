package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.*;
import java.util.stream.Collectors;

public class Concert_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String,List<String>> membersMap = new LinkedHashMap<>();
        Map<String,Integer> timeMap = new LinkedHashMap<>();

        while (!command.equals("Start!")){
            List<String> input = Arrays
                    .stream(command.split("; "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);
            String bandName = input.get(1);

            switch (firstCommand){
                case "Add":
                    List<String> members = Arrays.stream(input.get(2).split(", ")).collect(Collectors.toList());
                    for (int i = 0; i < members.size(); i++) {
                    if (!membersMap.containsKey(bandName)){
                        membersMap.put(bandName,new ArrayList<>());
                        membersMap.get(bandName).add(members.get(i));
                    }else {
                        if (!membersMap.get(bandName).contains(members.get(i))){
                            membersMap.get(bandName).add(members.get(i));
                        }
                    }
                    }
                    break;
                case "Play":
                    int time = Integer.parseInt(input.get(2));
                    if (!timeMap.containsKey(bandName)){
                        timeMap.put(bandName,time);
                    }else {
                        int currentTime = timeMap.get(bandName);
                        timeMap.put(bandName,currentTime + time);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        int totalTime = 0;
        for (Map.Entry<String, Integer> entry : timeMap.entrySet()) {
            int time = entry.getValue();
            totalTime += time;
        }
        System.out.printf("Total time: %d\n",totalTime);

        timeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%s -> %d\n",entry.getKey(),entry.getValue()));


        timeMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(1)
                .forEach(entry -> {
                    System.out.printf("%s\n",entry.getKey());
                    List<String> member = membersMap.get(entry.getKey());
                    for (int i = 0; i < member.size(); i++) {
                        System.out.printf("=> %s\n", member.get(i));
                    }
                });
    }
}
