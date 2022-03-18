package Programming_f.BasicSyntax.MethodsExercices;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!passwordLength(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!passwordContents(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!passwordDigits(password)){
            System.out.println("Password must have at least 2 digits");
        }
        if (passwordLength(password) && passwordContents(password) && passwordDigits(password)){
            System.out.println("Password is valid");
        }
    }
    //•	6 – 10 characters (inclusive);
    //•	Consists only of letters and digits;
    //•	Have at least 2 digits.

    public static boolean passwordLength (String password){
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        return false;
    }

    public static boolean passwordContents(String password){

        for (char symbol :password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)){
                return false;
            }
        }
        return true;
    }

    public static boolean passwordDigits (String password){

        int count = 0;
        for (char symbol :password.toCharArray()) {
            if (Character.isDigit(symbol)){
                count++;
            }
        }
        return count >= 2;
    }
}
