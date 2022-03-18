package Programming_f.BasicSyntax.RegularExpressionsExercices;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racers = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        String nameRegex = "[A-Za-z]+";
        Pattern namePattern = Pattern.compile(nameRegex);

        String distanceRegex = "[0-9]";
        Pattern distancePattern = Pattern.compile(distanceRegex);

        Map<String,Integer> racersList = new LinkedHashMap<>();


        while (!command.equals("end of race")){
            Matcher nameMatcher = namePattern.matcher(command);
            Matcher distanceMatcher = distancePattern.matcher(command);

            StringBuilder names = new StringBuilder();
            while (nameMatcher.find()) {
                names.append(nameMatcher.group());
            }

            int distance = 0;
            while (distanceMatcher.find()) {
                distance += Integer.parseInt(distanceMatcher.group());
            }

            if (racers.contains(names.toString())){
                if (!racersList.containsKey(names.toString())){
                    racersList.put(names.toString(),distance);
                }else {
                    int currentDistance = racersList.get(names.toString());
                    racersList.put(names.toString(),currentDistance + distance);
                }
            }

            command = scanner.nextLine();
        }
        List<String> top3Racers = new ArrayList<>();

        racersList.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(3)
                .forEach(entry -> top3Racers.add(entry.getKey()));

        String firstRacer = top3Racers.get(0);
        String secondRacer = top3Racers.get(1);
        String thirdRacer = top3Racers.get(2);

        System.out.println("1st place: " + firstRacer);
        System.out.println("2nd place: " + secondRacer);
        System.out.println("3rd place: " + thirdRacer);
    }
}
