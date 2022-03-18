package Programming_f.BasicSyntax.TextProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.size(); i++) {
            String count = text.get(i);
            for (int j = 0; j < count.length(); j++) {
                stringBuilder.append(text.get(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
