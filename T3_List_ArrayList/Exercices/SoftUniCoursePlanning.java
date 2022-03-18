package Programming_f.BasicSyntax.ListsExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")){
            List<String> listCommand = Arrays
                    .stream(command.split(":"))
                    .collect(Collectors.toList());
            String putCommand = listCommand.get(0);
            String lessonTitle = listCommand.get(1);

            switch (putCommand){
                case "Add":
                    if (!lessons.contains(lessonTitle)){
                        lessons.add(lessonTitle);
                    }
                    break;

                case "Insert":
                    int index = Integer.parseInt(listCommand.get(2));
                    if (!lessons.contains(lessonTitle)){
                        lessons.add(index,lessonTitle);
                    }
                    break;

                case "Remove":
                    if (lessons.contains(lessonTitle)){
                        lessons.remove(lessonTitle);
                    }
                    break;

                case "Swap":
                    String lessonsTitle = listCommand.get(1);
                    String lessonsTitle2 = listCommand.get(2);
                    if (lessons.contains(lessonsTitle) && lessons.contains(lessonsTitle2)) {
                        int index1 = lessons.indexOf(lessonsTitle);
                        int index2 = lessons.indexOf(lessonsTitle2);
                        lessons.set(index1,lessonsTitle2);
                        lessons.set(index2,lessonsTitle);
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < lessons.size(); i++) {
            System.out.printf("%d.%s\n",i + 1,lessons.get(i));
        }
    }
}
