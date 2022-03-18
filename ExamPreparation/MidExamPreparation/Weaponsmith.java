package Programming_f.BasicSyntax.MidExamExercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Weaponsmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> weaponName = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Done")){
            List<String> input = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            String firstCommand = input.get(0);

            switch (firstCommand){
                case "Add":
                    String wordsAdd = input.get(1);
                    int indexAdd = Integer.parseInt(input.get(2));
                    if (indexAdd >= 0 && indexAdd < weaponName.size()){
                        weaponName.add(indexAdd,wordsAdd);
                    }
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(input.get(1));
                    if (indexRemove >= 0 && indexRemove < weaponName.size()){
                        weaponName.remove(indexRemove);
                    }
                    break;
                case "Check":
                    String evenOrOdd = input.get(1);
                    List<String> evenName = new ArrayList<>();
                    List<String> oddName = new ArrayList<>();
                    if (evenOrOdd.equals("Even")) {
                        for (int i = 0; i < weaponName.size(); i++) {
                            if (i % 2 == 0) {
                                evenName.add(weaponName.get(i));
                            }
                        }
                        System.out.println(evenName.toString().replaceAll("[\\[\\],]",""));
                    }else if (evenOrOdd.equals("Odd")){
                        for (int i = 0; i < weaponName.size(); i++) {
                            if (i % 2 != 0) {
                                oddName.add(weaponName.get(i));
                            }
                        }
                        System.out.println(oddName.toString().replaceAll("[\\[\\],]",""));
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        System.out.println("You crafted " + String.join("",weaponName) + "!");

    }
}
