package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.*;
import java.util.stream.Collectors;

public class Pianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,String> composerMap = new LinkedHashMap<>();
        Map<String,String> keyMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> input = Arrays
                    .stream(scanner.nextLine().split("\\|"))
                    .collect(Collectors.toList());
            String pieces = input.get(0);
            String composer = input.get(1);
            String key = input.get(2);

            composerMap.put(pieces,composer);
            keyMap.put(pieces,key);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            List<String> input = Arrays
                    .stream(command.split("\\|"))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);
            String piece = input.get(1);

            switch (firstCommand){
                case "Add":
                    String composer = input.get(2);
                    String key = input.get(3);
                    if (!composerMap.containsKey(piece)){
                        composerMap.put(piece,composer);
                        keyMap.put(piece,key);
                        System.out.printf("%s by %s in %s added to the collection!\n",piece,composer,key);
                    }else {
                        System.out.printf("%s is already in the collection!\n",piece);
                    }
                    break;
                case "Remove":
                    if (composerMap.containsKey(piece)){
                        composerMap.remove(piece);
                        keyMap.remove(piece);
                        System.out.printf("Successfully removed %s!\n",piece);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = input.get(2);
                    if (keyMap.containsKey(piece)){
                        keyMap.put(piece,newKey);
                        System.out.printf("Changed the key of %s to %s!\n",piece,newKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        composerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s\n"
                        ,entry.getKey(),entry.getValue(),keyMap.get(entry.getKey())));

    }
}
