package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class SquareArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int result = squareArea(width,length);

        System.out.println(result);
    }

    public static int squareArea(int width,int length){
       return width * length;

    }
}
