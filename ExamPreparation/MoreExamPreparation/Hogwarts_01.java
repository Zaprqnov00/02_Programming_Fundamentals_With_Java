package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hogwarts_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String spell = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Abracadabra")){
            List<String> input = Arrays
                    .stream(command.split(" "))
                    .collect(Collectors.toList());

            String firstCommand = input.get(0);
            switch (firstCommand){
                case "Abjuration":
                    spell = spell.toUpperCase();
                    System.out.println(spell);
                    break;
                case "Necromancy":
                    spell = spell.toLowerCase();
                    System.out.println(spell);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(input.get(1));
                    String letter = input.get(2);
                    if (index >= 0 && index < spell.length()){
                        String replacement = "";
                       char symbol = spell.charAt(index);
                       replacement += symbol;
                       spell = spell.replace(replacement,letter);
                        System.out.println("Done!");
                    }else {
                        System.out.println("The spell was to weak!");
                    }
                    break;
                case "Divination":
                    String firstSub = input.get(1);
                    String secondSub = input.get(2);
                    if (spell.contains(firstSub)){
                        spell = spell.replaceAll(firstSub,secondSub);
                        System.out.println(spell);
                    }
                    break;
                case "Alteration":
                    String removeSub = input.get(1);
                    if (spell.contains(removeSub)){
                        spell = spell.replace(removeSub,"");
                        System.out.println(spell);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
                break;
            }
            command = scanner.nextLine();
        }
    }
}
