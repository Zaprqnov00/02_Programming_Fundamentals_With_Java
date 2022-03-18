package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grades = Double.parseDouble(scanner.nextLine());

        textGrades(grades);
    }

    public static void textGrades (double grades){
        if (grades >= 2 && grades <= 2.99){
            System.out.println("Fail");
        }else if (grades >= 3 && grades <= 3.49){
            System.out.println("Poor");
        }else if (grades >= 3.50 && grades <= 4.49){
            System.out.println("Good");
        }else if (grades >= 4.50 && grades <= 5.49){
            System.out.println("Very good");
        }else {
            System.out.println("Excellent");
        }
    }
}
