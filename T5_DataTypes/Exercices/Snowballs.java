package Programming_f.BasicSyntax.DataTypesExercices;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double highestSnowball = Double.MIN_VALUE;
        int maxSnowballSnow = 0;
        int maxSnowballTime = 0;
        int maxSnowballQuality = 0;

        for (int i = 1; i <= n ; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow(snowballSnow * 1.0 / snowballTime,snowballQuality);

            if (snowballValue > highestSnowball){
                highestSnowball = snowballValue;
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;

            }

        }
        System.out.printf("%d : %d = %.0f (%d)",maxSnowballSnow,maxSnowballTime,highestSnowball,maxSnowballQuality);
    }
}
