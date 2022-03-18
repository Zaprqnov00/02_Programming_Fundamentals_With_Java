package Programming_f.BasicSyntax.MidExamExercices;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        int averageNumber = sum / numbers.size();

        List<Integer> bigNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {

            if (averageNumber < numbers.get(i)){
                bigNumbers.add(numbers.get(i));
            }
        }
        Collections.sort(bigNumbers);
        Collections.reverse(bigNumbers);

            if (bigNumbers.size() > 5){
                for (int i = 0; i < 5; i++) {
                    System.out.print(bigNumbers.get(i) + " ");
                }
            }else if (bigNumbers.isEmpty()) {
                System.out.println("No");
            }else {
                System.out.println(bigNumbers.toString().replaceAll("[\\[\\],]",""));
            }

    }
}
