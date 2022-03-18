package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([#|])(?<item>[A-z ]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>[0-9]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> itemList = new ArrayList<>();

        int days = 0;
        while (matcher.find()) {

            String item = matcher.group("item");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            itemList.add(String.format("Item: %s, Best before: %s, Nutrition: %d",item,date,calories));

            days += calories;
        }
        days = days / 2000;
        if (days > 0) {
            System.out.printf("You have food to last you for: %d days!\n", days);
            itemList.forEach(System.out::println);
        }else {
            System.out.printf("You have food to last you for: %d days!",days);
        }


    }
}
