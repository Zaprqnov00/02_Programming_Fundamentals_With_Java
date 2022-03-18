package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productsList = Arrays
                .stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")){
            List<String> commandList = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());
            String commandName = commandList.get(0);
            String product = commandList.get(1);

            switch (commandName){
                case "Urgent":
                    if (!productsList.contains(product)){
                        productsList.add(0,product);
                    }
                    break;

                case "Unnecessary":
                    if (productsList.contains(product)){
                        productsList.remove(product);
                    }
                    break;

                case "Correct":
                    String newProduct = commandList.get(2);
                    int index1 = productsList.indexOf(product);
                    if (productsList.contains(product)){
                        productsList.add(index1,newProduct);
                        productsList.remove(product);
                    }
                    break;

                case "Rearrange":
                    if (productsList.contains(product)){
                        productsList.remove(product);
                        productsList.add(product);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(productsList.toString().replaceAll("[\\[\\]]",""));
    }
}
