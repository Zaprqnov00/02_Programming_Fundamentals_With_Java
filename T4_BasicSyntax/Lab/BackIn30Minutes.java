package Programming_f.BasicSyntax.BasicSyntax;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalTimeMinutes = hours * 60 + minutes;
        int timeAfter30Min = totalTimeMinutes + 30;

        int finalHours = timeAfter30Min / 60;
        int finalMinutes = timeAfter30Min % 60;

        if (finalHours >= 24){
            finalHours = 0;
        }
        System.out.printf("%d:%02d", finalHours, finalMinutes);
    }
}
