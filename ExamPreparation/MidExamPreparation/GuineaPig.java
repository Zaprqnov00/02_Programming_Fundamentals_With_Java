package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodKg = Double.parseDouble(scanner.nextLine());
        double hayKg = Double.parseDouble(scanner.nextLine());
        double coverKg = Double.parseDouble(scanner.nextLine());
        double weightPig = Double.parseDouble(scanner.nextLine());

        int days = 30;
        boolean foodEnough = true;

        for (int i = 1; i <= days; i++) {

            foodKg -= 0.3;

            if (i % 2 == 0){
                double needHay = foodKg * 0.05;
                hayKg -= needHay;
            }
            if (i % 3 == 0){
                double pigTriple = weightPig / 3;
                coverKg -= pigTriple;
            }

            if (foodKg < 0 || hayKg < 0 || coverKg < 0){
                System.out.println("Merry must go to the pet store!");
                foodEnough = false;
                break;
            }
        }

        if (foodEnough){
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",foodKg,hayKg,coverKg);
        }
    }
}
