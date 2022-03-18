package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;
import java.util.stream.Collectors;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String,Double> productMap = new LinkedHashMap<>();
        Map<String,Integer> quantityMap = new LinkedHashMap<>();

        while (!command.equals("buy")){
            List<String> orderList = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            String drink = orderList.get(0);
            double price = Double.parseDouble(orderList.get(1));
            int quantity = Integer.parseInt(orderList.get(2));

                productMap.put(drink,price);

                if (!quantityMap.containsKey(drink)){
                    quantityMap.put(drink,quantity);
                }else {
                    quantityMap.put(drink,quantityMap.get(drink) + quantity);
                }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productMap.entrySet()) {
            double totalSum = entry.getValue() * quantityMap.get(entry.getKey());
                System.out.printf("%s -> %.2f\n",entry.getKey(),totalSum);
        }

    }
}
