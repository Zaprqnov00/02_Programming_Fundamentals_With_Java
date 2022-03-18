package Programming_f.BasicSyntax.BasicSyntax;

import java.util.Scanner;

public class Message {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            int numbers = input.length();
            char letters = input.charAt(0);

            if (letters == '2') {
                if (numbers == 1) {
                    System.out.print("a");
                } else if (numbers == 2) {
                    System.out.print("b");
                } else if (numbers == 3) {
                    System.out.print("c");
                }
            }
            if (letters == '3') {
                if (numbers == 1) {
                    System.out.print("d");
                } else if (numbers == 2) {
                    System.out.print("e");
                } else if (numbers == 3) {
                    System.out.print("f");
                }
            }
            if (letters == '4') {
                if (numbers == 1) {
                    System.out.print("g");
                } else if (numbers == 2) {
                    System.out.print("h");
                } else if (numbers == 3) {
                    System.out.print("i");
                }
            }
            if (letters == '5') {
                if (numbers == 1) {
                    System.out.print("j");
                } else if (numbers == 2) {
                    System.out.print("k");
                } else if (numbers == 3) {
                    System.out.print("l");
                }
            }
            if (letters == '6') {
                if (numbers == 1) {
                    System.out.print("m");
                } else if (numbers == 2) {
                    System.out.print("n");
                } else if (numbers == 3) {
                    System.out.print("o");
                }
            }
            if (letters == '7') {
                if (numbers == 1) {
                    System.out.print("p");
                } else if (numbers == 2) {
                    System.out.print("q");
                } else if (numbers == 3) {
                    System.out.print("r");
                } else if (numbers == 4) {
                    System.out.print("s");
                }
            }
            if (letters == '8') {
                if (numbers == 1) {
                    System.out.print("t");
                } else if (numbers == 2) {
                    System.out.print("u");
                } else if (numbers == 3) {
                    System.out.print("v");
                }
            }
            if (letters == '9') {
                if (numbers == 1) {
                    System.out.print("w");
                } else if (numbers == 2) {
                    System.out.print("x");
                } else if (numbers == 3) {
                    System.out.print("y");
                }else if (numbers == 4){
                    System.out.print("z");
                }
            }
            if (letters == '0'){
                System.out.print(" ");
            }
        }
    }
}
