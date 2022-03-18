package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String location = scanner.nextLine();
        List<String> townList = new ArrayList<>();

        String regex = "([=\\/])(?<town>[A-z]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(location);

        while (matcher.find()) {

            String town = matcher.group("town");

            if (town.length() >= 3){
                townList.add(town);
            }
        }
        int count = 0;
        for (int i = 0; i < townList.size(); i++) {
            count += townList.get(i).length();
        }
        System.out.printf("Destinations: %s\n",townList.toString().replaceAll("[\\[\\]]",""));
        System.out.println("Travel Points: " + count);
    }
}
