package Programming_f.BasicSyntax.RegularExpressionsExercices;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "@(?<planet>[A-z]+)[^-@!:>]*:(?<population>[0-9]+)[^-@!:>]*!(?<type>[AD])!->[^-@!:>]*?(?<soldier>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        int attack = 0;
        List<String> attackPlanet = new ArrayList<>();
        int destroy = 0;
        List<String> destroyPlanet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();

            int counter = 0;
            for (int j = 0; j < message.length(); j++) {
                char symbol = message.charAt(j);
                    if (symbol == 's' || symbol == 't' || symbol == 'a' || symbol == 'r' ||
                    symbol == 'S' || symbol == 'T' || symbol == 'A' || symbol == 'R'){
                        counter++;
                    }
            }

            StringBuilder encryptedMessage = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                char symbol = (char) (message.charAt(j) - counter);
                    encryptedMessage.append(symbol);
            }

            Matcher matcher = pattern.matcher(encryptedMessage.toString());
            while (matcher.find()) {

                String planet = matcher.group("planet");
                String type = matcher.group("type");
                if (type.equals("A")){
                    attack++;
                    attackPlanet.add(planet);
                }else {
                    destroy++;
                    destroyPlanet.add(planet);
                }
            }
        }
        Collections.sort(attackPlanet);
        Collections.sort(destroyPlanet);
        System.out.println("Attacked planets: " + attack);
        for (String planet :attackPlanet) {
            System.out.println("-> " + planet);
        }
        System.out.println("Destroyed planets: " + destroy);
        for (String dPlanet :destroyPlanet) {
            System.out.println("-> " + dPlanet);
        }
    }
}
