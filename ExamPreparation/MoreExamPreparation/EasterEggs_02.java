package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "[@#]+(?<colour>[a-z]{3,})[@#]+[*\\/$%^&]+(?<amount>[0-9]+)\\/+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){

            String colour = matcher.group("colour");
            int amount = Integer.parseInt(matcher.group("amount"));

            System.out.printf("You found %d %s eggs!\n",amount,colour);
        }

    }
}
