package Programming_f.BasicSyntax.BasicSyntax;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sum = 0;

        while (!command.equals("Start")) {
            double coins = Double.parseDouble(command);

            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                System.out.printf("Cannot accept %.2f\n", coins);
            } else {
                sum += coins;
            }
            command = scanner.nextLine();
            }

            String product = scanner.nextLine();
            while (!product.equals("End")){

                if (product.equals("Nuts")){
                    if (sum < 2){
                        System.out.println("Sorry, not enough money");
                    }else {
                        sum -= 2;
                        System.out.printf("Purchased %s\n",product);
                    }
                }
                if (product.equals("Water")){
                    if (sum < 0.7){
                        System.out.println("Sorry, not enough money");
                    }else {
                        sum -= 0.7;
                        System.out.printf("Purchased %s\n",product);
                    }
                }
                if (product.equals("Crisps")){
                    if (sum < 1.5){
                        System.out.println("Sorry, not enough money");
                    }else {
                        sum -= 1.5;
                        System.out.printf("Purchased %s\n",product);
                    }
                }
                if (product.equals("Soda")){
                    if (sum < 0.8){
                        System.out.println("Sorry, not enough money");
                    }else {
                        sum -= 0.8;
                        System.out.printf("Purchased %s\n",product);
                    }
                }
                if (product.equals("Coke")){
                    if (sum < 1){
                        System.out.println("Sorry, not enough money");
                    }else {
                        sum -= 1;
                        System.out.printf("Purchased %s\n",product);
                    }
                }
                if (!product.equals("Nuts") && !product.equals("Water") && !product.equals("Crisps") &&
                !product.equals("Soda") && !product.equals("Coke")){
                    System.out.println("Invalid product");
                }

                product = scanner.nextLine();
            }
        System.out.printf("Change: %.2f",sum);
        }
    }

