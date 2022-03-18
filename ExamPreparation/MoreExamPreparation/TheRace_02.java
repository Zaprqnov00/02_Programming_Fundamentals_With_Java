package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheRace_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "([#%*&$])(?<name>[A-Za-z]+)\\1=(?<code>[0-9]+)!!(?<encryptedCode>[A-Za-z0-9#'_&$%\\[(!@]+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()){

                String name = matcher.group("name");
                int code = Integer.parseInt(matcher.group("code"));
                String encryptedCode = matcher.group("encryptedCode");

                if (code == encryptedCode.length()){
                    String decryptedCode = "";
                    for (int j = 0; j < encryptedCode.length(); j++) {
                        char symbol = (char) (encryptedCode.charAt(j) + code);
                        decryptedCode += symbol;
                    }
                    System.out.printf("Coordinates found! %s -> %s\n",name,decryptedCode);
                    break;
                }else {
                    System.out.println("Nothing found!");
                }
            }else {
                System.out.println("Nothing found!");
            }

        }
    }
}
