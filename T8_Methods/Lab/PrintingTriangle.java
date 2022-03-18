package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        triangle(n);

    }
    public static void triangle(int n){
        for (int i = 1; i <= n; i++) {
            line(1,i);
        }
        for (int i = n - 1; i >= 1 ; i--) {
            line(1,i);
        }

    }

    public static void line(int start, int end){

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
