package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffee = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            List<String> commandList = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());

            String firstCommand = commandList.get(0);

            switch (firstCommand){
                case "Include":
                    String coffeeInclude = commandList.get(1);
                    coffee.add(coffeeInclude);
                    break;

                case "Remove":
                    String commandRemove = commandList.get(1);
                    int countCoffee = Integer.parseInt(commandList.get(2));
                    if (countCoffee <= coffee.size()) {
                        if (commandRemove.equals("first")) {
                            for (int j = 0; j < countCoffee; j++) {
                                coffee.remove(0);
                            }
                        } else if (commandRemove.equals("last")) {
                            for (int j = 0; j < countCoffee; j++) {
                                coffee.remove(coffee.size() - 1);
                            }
                        }
                    }
                    break;

                case "Prefer":
                    int firstCoffeeIndex = Integer.parseInt(commandList.get(1));
                    int secondCoffeeIndex = Integer.parseInt(commandList.get(2));
                    String first = coffee.get(firstCoffeeIndex);
                    String second = coffee.get(secondCoffeeIndex);
                    if (coffee.contains(first) && coffee.contains(second)){
                        coffee.set(firstCoffeeIndex,second);
                        coffee.set(secondCoffeeIndex,first);
                    }
                    break;

                case "Reverse":
                    Collections.reverse(coffee);
                    break;


            }
        }
        System.out.println("Coffees: ");
        System.out.println(coffee.toString().replaceAll("[\\[\\],]",""));
    }
}
