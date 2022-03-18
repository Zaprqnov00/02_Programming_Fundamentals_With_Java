package Programming_f.BasicSyntax.Methods;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        sumProducts(product,quantity);

    }
    public static void sumProducts(String product, double quantity){

        double sum = 0;
        if (product.equals("coffee")){
            sum = 1.50;
        }else if (product.equals("water")){
            sum = 1.00;
        }else if (product.equals("coke")){
            sum = 1.40;
        }else if (product.equals("snacks")){
            sum = 2.00;
        }
        double allSum = sum * quantity;
        System.out.printf("%.2f",allSum);
    }
}
