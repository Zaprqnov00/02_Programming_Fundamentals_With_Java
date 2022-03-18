package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.*;

public class ArcheryChampion_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> infoList = new ArrayList<>();

        int totalPoints = 0;

        int [] inputed = Arrays.stream(scanner.nextLine().split("\\|")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < inputed.length; i++) {
            infoList.add(inputed[i]);
        }
        String input  = scanner.nextLine();

        while (!input.equals("Game over")){
            String [] commandArr = input.split("@");
            String command = commandArr[0];
            if (command.equals("Shoot Left")){
                int startIndex = Integer.parseInt(commandArr[1]);
                int lenght = Integer.parseInt(commandArr[2]);
                if (startIndex<0 || startIndex> infoList.size()-1){
                    input= scanner.nextLine();
                    continue;
                }else {
                    while (lenght > 0) {
                        for (int i = startIndex; i >= 0; i--) {
                            if (lenght == 0) {
                                infoList.set((i), infoList.get(i)-5);
                                totalPoints+=5;
                                break;
                            } else {
                                if (i == 0) {
                                    i = infoList.size();
                                    lenght--;
                                } else {
                                    lenght--;
                                }
                            }
                        }
                    }
                }

            }else if (command.equals("Shoot Right")) {
                int startIndex = Integer.parseInt(commandArr[1]);
                int lenght = Integer.parseInt(commandArr[2]);
                if (startIndex<0 || startIndex> infoList.size()-1){
                    input= scanner.nextLine();
                    continue;
                }else {
                    while (lenght > 0) {
                        for (int i = startIndex; i < infoList.size(); i++) {
                            if (lenght == 0) {
                                infoList.set((i), infoList.get(i)-5);
                                totalPoints+=5;
                                break;
                            } else {
                                if (i == infoList.size() - 1) {
                                    i = -1;
                                    lenght--;
                                } else {
                                    lenght--;
                                }
                            }

                        }
                    }
                }
            }else {
                Collections.reverse(infoList);
            }
            input=scanner.nextLine();
        }
        StringBuilder finalArr = new StringBuilder(infoList.toString());
        System.out.println();

        System.out.println(infoList.toString().replaceAll("[\\[\\],]",""));

        System.out.printf("John finished the archery tournament with %d points!", totalPoints);
    }
}
