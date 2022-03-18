package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String thresholdRegex = "[0-9]";
        Pattern thresholdPattern = Pattern.compile(thresholdRegex);
        Matcher thresholdMatcher = thresholdPattern.matcher(text);

        String emojiRegex = "(?<separator>[:*])\\1(?<name>[A-Z][a-z]{2,})\\1\\1";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(text);

        int sum = 1;
        while (thresholdMatcher.find()) {

            int numbers = Integer.parseInt(thresholdMatcher.group());
            sum *= numbers;
        }

        List<String> coolEmoji = new ArrayList<>();
        int count = 0;
        while (emojiMatcher.find()) {
            count++;
            String separator = emojiMatcher.group("separator");
            String name = emojiMatcher.group("name");

            int emojiSum = 0;
            for (int i = 0; i < name.length(); i++) {
                char symbol = name.charAt(i);
                emojiSum += symbol;
            }
            if (emojiSum >= sum){
                String addEmoji = separator + separator + name + separator + separator;
                coolEmoji.add(addEmoji);
            }

        }
        System.out.println("Cool threshold: " + sum);
        System.out.printf("%d emojis found in the text. The cool ones are:\n",count);
        for (String emojis:coolEmoji) {
            System.out.printf("%s\n",emojis);
        }


    }
}
