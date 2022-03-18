package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")){
            List<String> commandList = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            String firstCommand = commandList.get(0);

            switch (firstCommand){
                case "Shoot":
                    int indexShoot = Integer.parseInt(commandList.get(1));
                    int power = Integer.parseInt(commandList.get(2));
                    if (indexShoot >= 0 && indexShoot <= targets.size()){
                        int sectionShoot = targets.get(indexShoot);
                        sectionShoot -= power;
                        targets.set(indexShoot,sectionShoot);
                        if (power > sectionShoot){
                            targets.remove(indexShoot);
                        }
                    }
                    break;

                case "Add":
                    int indexAdd = Integer.parseInt(commandList.get(1));
                    int valueAdd = Integer.parseInt(commandList.get(2));
                    if (indexAdd >= 0 && indexAdd <= targets.size()){
                        targets.add(indexAdd,valueAdd);
                    }else {
                        System.out.println("Invalid placement!");
                    }
                    break;

                case "Strike":
                    int indexStrike = Integer.parseInt(commandList.get(1));
                    int radius = Integer.parseInt(commandList.get(2));
                    int before = indexStrike - radius;
                    int after = indexStrike + radius;

                    if (before >= 0 && after <= targets.size()){
                        targets.remove(before);
                        targets.remove(after - 1);
                        targets.remove(before);
                    }else {
                        System.out.println("Strike missed!");
                    }
            }

            command = scanner.nextLine();
        }

        System.out.print(Arrays.toString(new List[]{targets})
                .replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "|"));
    }
}
