package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input){
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                System.out.println(getInt(firstNum,secondNum));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getChar(firstChar,secondChar));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(getString(firstString,secondString));
                break;
        }
    }

    public static int getInt(int firstNum,int secondNum){
        if (firstNum > secondNum){
            return firstNum;
        }
        return secondNum;

    }

    public static char getChar(char firstChar,char secondChar){
        if (firstChar > secondChar){
            return firstChar;
        }
        return secondChar;
    }

    public static String getString(String firstString,String secondString){
        if (firstString.compareTo(secondString) >= 0){
            return firstString;
        }
        return secondString;
    }
}
