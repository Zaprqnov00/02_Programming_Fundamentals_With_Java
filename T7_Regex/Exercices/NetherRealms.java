package Programming_f.BasicSyntax.RegularExpressionsExercices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> players = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        Collections.sort(players);
        String regex = "(?<numbers>[0-9.\\-+]+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < players.size(); i++) {
            String demon = players.get(i);

            int health = 0;
            for (int j = 0; j < demon.length(); j++) {
            char symbol = demon.charAt(j);
            if (Character.isLetter(symbol)) {
                health += symbol;
              }
            }

            Matcher matcher = pattern.matcher(demon);

            double damage = 0.0;
            while (matcher.find()){

                double numbers = Double.parseDouble(matcher.group("numbers"));

                damage += numbers;
            }

            double count = damage;
            for (int j = 0; j < demon.length(); j++) {
                char symbol = demon.charAt(j);
                if (symbol == '*'){
                    count *= 2;
                }else if (symbol == '/'){
                    count /= 2;
                }
            }


            System.out.printf("%s - %d health, %.2f damage\n",demon,health,count);
        }
    }
}
