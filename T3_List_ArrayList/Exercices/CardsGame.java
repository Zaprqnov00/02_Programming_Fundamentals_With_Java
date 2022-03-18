package Programming_f.BasicSyntax.ListsExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstCardsPlayer = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondCardsPlayer = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstCardsPlayer.size() != 0 && secondCardsPlayer.size() != 0) {
            int firstCard = firstCardsPlayer.get(0);
            int secondCard = secondCardsPlayer.get(0);
            firstCardsPlayer.remove(0);
            secondCardsPlayer.remove(0);

            if (firstCard > secondCard) {
                firstCardsPlayer.add(firstCard);
                firstCardsPlayer.add(secondCard);
            } else if (secondCard > firstCard) {
                secondCardsPlayer.add(secondCard);
                secondCardsPlayer.add(firstCard);
            }
        }
            if (secondCardsPlayer.size() == 0){
                System.out.printf("First player wins! Sum: %d",getSumCards(firstCardsPlayer));
            }else {
                System.out.printf("Second player wins! Sum: %d",getSumCards(secondCardsPlayer));
            }
        }

    private static int getSumCards(List<Integer> secondCardsPlayer) {
        int sum = 0;
        for (int card :secondCardsPlayer) {
            sum += card;
        }
        return sum;
    }
}
