package Programming_f.BasicSyntax.DataTypes;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String symbol = scanner.nextLine();

        if (symbol.equals(symbol.toUpperCase())){
            System.out.println("upper-case");
        }else {
            System.out.println("lower-case");
        }
    }
}
