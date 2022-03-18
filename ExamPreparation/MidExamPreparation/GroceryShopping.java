package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GroceryShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Shop!")){
            List<String> input = Arrays
                    .stream(command.split("%"))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);


            switch (firstCommand){
                case "Important":
                    String importProduct = input.get(1);
                    if (products.contains(importProduct)){
                        products.remove(importProduct);
                        products.add(0,importProduct);
                    }else {
                        products.add(0,importProduct);
                    }
                    break;
                case "Add":
                    String addProduct = input.get(1);
                    if (!products.contains(addProduct)){
                        products.add(addProduct);
                    }else {
                        System.out.println("The product is already in the list.");
                    }
                    break;
                case "Swap":
                    String firstProduct = input.get(1);
                    String secondProduct = input.get(2);
                    if (products.contains(firstProduct) && products.contains(secondProduct)){
                        int indexFirstProduct = products.indexOf(firstProduct);
                        int indexSecondProduct = products.indexOf(secondProduct);
                        products.set(indexFirstProduct,secondProduct);
                        products.set(indexSecondProduct,firstProduct);
                    }else if (!products.contains(firstProduct)){
                        System.out.printf("Product %s missing!\n",firstProduct);
                    }else if (!products.contains(secondProduct)){
                        System.out.printf("Product %s missing!\n",secondProduct);
                    }
                    break;
                case "Remove":
                    String productRemove = input.get(1);
                    if (products.contains(productRemove)){
                        products.remove(productRemove);
                    }else {
                        System.out.printf("Product %s isn't in the list.\n",productRemove);
                    }
                    break;
                case "Reversed":
                    Collections.reverse(products);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s\n",i + 1,products.get(i));
        }
    }
}
