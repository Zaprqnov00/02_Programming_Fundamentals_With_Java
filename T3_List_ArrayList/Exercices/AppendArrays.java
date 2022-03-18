package Programming_f.BasicSyntax.ListsExercices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> numbers = Arrays
                        .stream(input.split("\\|"))
                        .collect(Collectors.toList());

        Collections.reverse(numbers);

        System.out.println(numbers.toString()
                .replace("[","")
                .replace("]","")
                .trim()
                .replaceAll(",","")
                .replaceAll("\\s+"," "));
    }
}
