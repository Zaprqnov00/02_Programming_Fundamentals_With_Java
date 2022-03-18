package Programming_f.BasicSyntax.RegularExpressionsExercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String regex = "\\b[a-z0-9._-]+@[a-z.-]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherEmail = pattern.matcher(email);

        List<String> correctEmails = new ArrayList<>();
        while (matcherEmail.find()){
            String emails = matcherEmail.group();

            correctEmails.add(emails);
        }
        for (int i = 0; i < correctEmails.size(); i++) {
            System.out.println(correctEmails.get(i));
        }
    }
}
