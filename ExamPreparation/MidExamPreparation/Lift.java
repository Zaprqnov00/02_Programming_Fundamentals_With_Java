package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        List<Integer> liftCabins = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        for (int i = 0; i < liftCabins.size(); i++) {
            if (people == 0){
                break;
            }

            while (liftCabins.get(i) < 4){
                if (people == 0){
                    break;
                }else {
                    liftCabins.set(i,liftCabins.get(i) + 1);
                    people--;
                }
            }
        }
        if (people == 0){
            System.out.println("The lift has empty spots!");
            System.out.println(liftCabins.toString().replaceAll("[\\[\\],]",""));
        }else if (people > 0){
            System.out.printf("There isn't enough space! %d people in a queue!\n",people);
            System.out.println(liftCabins.toString().replaceAll("[\\[\\],]",""));
        }else {
            System.out.println(liftCabins.toString().replaceAll("[\\[\\],]",""));
        }
    }
}
