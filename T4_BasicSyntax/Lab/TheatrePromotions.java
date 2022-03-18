package Programming_f.BasicSyntax.BasicSyntax;

import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int cost = 0;

        if (age >= 0 && age <= 18){
            if (day.equals("Weekday")){
                cost = 12;
            }else if (day.equals("Weekend")){
                cost = 15;
            }else {
                cost = 5;
            }
        }
        if (age > 18 && age <= 64){
            if (day.equals("Weekday")){
                cost = 18;
            }else if (day.equals("Weekend")){
                cost = 20;
            }else {
                cost = 12;
            }
        }
        if (age > 64 && age <= 122){
            if (day.equals("Weekday")){
                cost = 12;
            }else if (day.equals("Weekend")){
                cost = 15;
            }else {
                cost = 10;
            }
        }
        if (age < 0 || age > 122){
            System.out.println("Error!");
        }else {
            System.out.println(cost + "$");
        }
    }
}
