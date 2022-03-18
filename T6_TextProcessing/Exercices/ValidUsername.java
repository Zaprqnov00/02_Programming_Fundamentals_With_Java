package Programming_f.BasicSyntax.TextProcessingExercices;

import java.util.Arrays;
import java.util.List;


import java.util.Scanner;
        import java.util.stream.Collectors;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> usernames = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        for (String username : usernames)
            if (isValidUsername(username)) {
                System.out.println(username);
            }
    }

    private static boolean isValidUsername(String usernames) {

        if (usernames.length() < 3 || usernames.length() > 16) {
            return false;
        }
        for (char symbol :usernames.toCharArray()) {
            if (!(symbol == '-' || symbol == '_' || Character.isLetterOrDigit(symbol))){
                return false;
            }
        }
        return true;
    }
}