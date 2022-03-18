package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptedMessage_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "([A-z#!@$%^&*()_\\-+]+)>(?<number>[0-9]+)\\|(?<lowerCase>[a-z]+)\\" +
                "|(?<upperCase>[A-Z]+)\\|(?<symbol>[A-z!@#$%^&*()_+\\-]+)<\\1";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();

            Matcher matcher = pattern.matcher(password);

            if (matcher.find()){
                String number = matcher.group("number");
                String lowerCase = matcher.group("lowerCase");
                String upperCase = matcher.group("upperCase");
                String symbol = matcher.group("symbol");

                String decryptedPassword = number + lowerCase + upperCase + symbol;
                System.out.printf("Password: %s\n",decryptedPassword);

            }else {
                System.out.println("Try another password!");
            }

        }
    }
}
