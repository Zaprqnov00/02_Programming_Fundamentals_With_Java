package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String newText = newText(text,n);
        System.out.print(newText);
    }
    public static String newText(String text, int n){

        String add = "";
        for (int i = 0; i < n ; i++) {
            add += text;
        }
        return add;
    }
}
