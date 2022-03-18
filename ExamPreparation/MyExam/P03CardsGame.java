package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cards = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            List<String> commandList = Arrays
                    .stream(scanner.nextLine().split(", "))
                    .collect(Collectors.toList());

            String firstCommand = commandList.get(0);
            String cardName = commandList.get(1);
            switch (firstCommand){

                case "Add":
                    if (!cards.contains(cardName)){
                        cards.add(cardName);
                        System.out.println("Card successfully added");
                    }else {
                        System.out.println("Card is already in the deck");
                    }
                    break;
                case "Remove":
                    if (cards.contains(cardName)){
                        cards.remove(cardName);
                        System.out.println("Card successfully removed");
                    }else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int indexCard = Integer.parseInt(commandList.get(1));
                    if (indexCard >= 0 && indexCard <= cards.size()){
                        cards.remove(indexCard);
                        System.out.println("Card successfully removed");
                    }else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int indexInsert = Integer.parseInt(commandList.get(1));
                    String insertCard = commandList.get(2);
                    if (indexInsert >= 0 && indexInsert <= cards.size() && !cards.contains(insertCard)){
                        cards.add(indexInsert,insertCard);
                        System.out.println("Card successfully added");
                    }else if (indexInsert >= 0 && indexInsert <= cards.size() && cards.contains(insertCard)){
                        System.out.println("Card is already added");
                    }else if (indexInsert < 0 || indexInsert > cards.size()){
                        System.out.println("Index out of range");
                    }
            }
        }
        System.out.println(cards.toString().replaceAll("[\\[\\]]",""));
    }
}
