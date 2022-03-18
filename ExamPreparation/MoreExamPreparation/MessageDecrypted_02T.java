package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypted_02T {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "([$%])(?<name>[A-Z][a-z]{2,})\\1: \\[(?<first>[0-9]+)]\\|\\[(?<second>[0-9]+)]\\|\\[(?<third>[0-9]+)]\\|";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){

                String name = matcher.group("name");
                char first = (char) Integer.parseInt(matcher.group("first"));
                char second = (char) Integer.parseInt(matcher.group("second"));
                char third = (char) Integer.parseInt(matcher.group("third"));

                System.out.printf("%s: %s%s%s\n",name,first,second,third);
            }else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
