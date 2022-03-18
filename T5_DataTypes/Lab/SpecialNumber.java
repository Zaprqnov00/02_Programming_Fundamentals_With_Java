package Programming_f.BasicSyntax.DataTypes;

import java.util.Scanner;

public class SpecialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
         int sum = 0;
         int numbers = i;
            while (numbers > 0){
                sum += numbers % 10;
                numbers = numbers / 10;
        }
            if ( sum == 5 || sum == 7 || sum == 11){
                System.out.printf("%d -> True\n",i);
            }else {
                System.out.printf("%d -> False\n",i);
            }
        }
    }
}
