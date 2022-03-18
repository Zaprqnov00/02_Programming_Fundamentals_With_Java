package Programming_f.BasicSyntax.MidExamExercices;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double totalBonus;
        double maxTotalBonus = 0;
        double maxTotalAttendance = 0;
        for (int index = 0; index < students; index++) {
            int attendanceStudents = Integer.parseInt(scanner.nextLine());

            totalBonus = attendanceStudents * 1.0 / lectures * (5 + additionalBonus);

            if (totalBonus > maxTotalBonus){
                maxTotalBonus = totalBonus;
                maxTotalAttendance = attendanceStudents;
            }


        }
        System.out.printf("Max Bonus: %.0f.\n",maxTotalBonus);
        System.out.printf("The student has attended %.0f lectures.",maxTotalAttendance);
    }
}
