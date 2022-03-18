package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Map<String,String> mirrorWords = new LinkedHashMap<>();

        boolean noMirrorWord = true;
        int count = 0;
        while (matcher.find()) {
            count++;

            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");

            String first = "";
            for (int i = 0; i < firstWord.length(); i++) {
                char symbol = firstWord.charAt(i);
                first += symbol;
            }

            String second = "";
            for (int i = secondWord.length() - 1; i >= 0; i--) {
                char symbol = secondWord.charAt(i);
                second += symbol;
            }

            if (first.equals(second)){
                mirrorWords.put(firstWord,secondWord);
                noMirrorWord = false;
            }
        }
        if (count > 0){
            System.out.printf("%d word pairs found!\n",count);
        }else {
            System.out.println("No word pairs found!");
        }

        List<String> words = new ArrayList<>();

        for (Map.Entry<String, String> entry : mirrorWords.entrySet()) {
            String first = entry.getKey();
            String reverseWord = entry.getValue();
            words.add(first + " <=> " + reverseWord);
        }

        if (noMirrorWord){
            System.out.println("No mirror words!");
        }else {
            System.out.println("The mirror words are:");
            System.out.print(words.toString().replaceAll("[\\[\\]]",""));
        }
    }
}
