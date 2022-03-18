package Programming_f.BasicSyntax.DataTypes;

import java.util.Scanner;

public class RefactorSpecialNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int kolkko = Integer.parseInt(scanner.nextLine());


        for (int ch = 1; ch <= kolkko; ch++) {
            int obshto = 0;
            int takova = ch;

            while (takova > 0) {
                obshto += takova % 10;
                takova = takova / 10;
            }
            if ((obshto == 5 || obshto == 7 || obshto == 11)){
                System.out.printf("%d -> True\n", ch);
            }else {
                System.out.printf("%d -> False\n",ch);
            }

        }
    }
}