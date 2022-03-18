package Programming_f.BasicSyntax.BasicSyntaxExercices;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupOfPeople = Integer.parseInt(scanner.nextLine());
        java.lang.String typeGroup = scanner.nextLine();
        java.lang.String day = scanner.nextLine();

        double price = 0;

        if (day.equals("Friday")){
            if (typeGroup.equals("Students")){
                price =  8.45;
            }else if (typeGroup.equals("Business")){
                price =  10.90;
            }else {
                price =  15;
            }
        }
        if (day.equals("Saturday")){
            if (typeGroup.equals("Students")){
                price =  9.80;
            }else if (typeGroup.equals("Business")){
                price = 15.60;
            }else {
                price =  20;
            }
        }
        if (day.equals("Sunday")){
            if (typeGroup.equals("Students")){
                price =  10.46;
            }else if (typeGroup.equals("Business")){
                price =  16;
            }else {
                price =  22.50;
            }
        }
        double totalPrice = price * groupOfPeople;
        switch (typeGroup) {
            case "Students":
                if (groupOfPeople >= 30) {
                    totalPrice = totalPrice * 0.85;
                }
                break;
            case "Business":
                if (groupOfPeople >= 100) {
                    totalPrice = totalPrice - 10 * price;
                }
                break;
            case "Regular":
                if (groupOfPeople >= 10 && groupOfPeople <= 20) {
                    totalPrice = totalPrice * 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
