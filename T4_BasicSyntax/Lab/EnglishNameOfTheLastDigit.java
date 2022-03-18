package Programming_f.BasicSyntax.BasicSyntax;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        reverse(number);
    }
    public static void reverse(int number){

        int lastNumbers = number % 10;

        if (lastNumbers == 0){
            System.out.println("zero");
        }else if (lastNumbers == 1){
            System.out.println("one");
        }else if (lastNumbers == 2){
            System.out.println("two");
        }else if (lastNumbers == 3){
            System.out.println("three");
        }else if (lastNumbers == 4){
            System.out.println("four");
        }else if (lastNumbers == 5){
            System.out.println("five");
        }else if (lastNumbers == 6){
            System.out.println("six");
        }else if (lastNumbers == 7){
            System.out.println("seven");
        }else if (lastNumbers == 8){
            System.out.println("eight");
        }else if (lastNumbers == 9){
            System.out.println("nine");
        }
    }
}
