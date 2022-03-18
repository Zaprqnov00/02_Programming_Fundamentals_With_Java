package Programming_f.BasicSyntax.ListsExercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> namePeople = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> input = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());

            String name = input.get(0);

            if (input.size() == 3){
                if (namePeople.contains(name)){
                    System.out.printf("%s is already in the list!\n",name);
                }else {
                    namePeople.add(name);
                }
            }else if (input.size() == 4){
                if (!namePeople.contains(name)){
                    System.out.printf("%s is not in the list!\n",name);
                }else {
                    namePeople.remove(name);
                }
            }
        }
        for (String name :namePeople) {
            System.out.println(name + " ");
        }
    }
}
