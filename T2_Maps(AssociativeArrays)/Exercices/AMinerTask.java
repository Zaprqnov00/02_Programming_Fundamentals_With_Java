package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String command = scanner.nextLine();

       Map<String,Integer> mapList = new LinkedHashMap<>();

       while (!command.equals("stop")){
           int quantity = Integer.parseInt(scanner.nextLine());


           if (mapList.containsKey(command)){
               int currentSum = mapList.get(command);
               mapList.put(command,currentSum + quantity);
           }else {
               mapList.put(command, quantity);
           }
           command = scanner.nextLine();
       }

        mapList.entrySet().forEach(entry -> System.out.printf("%s -> %d\n",entry.getKey(),entry.getValue()));
    }
}
