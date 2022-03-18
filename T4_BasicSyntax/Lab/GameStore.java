package Programming_f.BasicSyntax.BasicSyntax;

import java.util.Scanner;

public class GameStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double OutFall4 = 39.99;
        double CSGO = 15.99;
        double ZplinterZell = 19.99;
        double Honored2 = 59.99;
        double RoverWatch = 29.99;
        double RoverWatchOriginsEdition = 39.99;

        double budget = Double.parseDouble(scanner.nextLine());

        double totalSpent = 0;
        boolean noMoney = true;

        String command = scanner.nextLine();
        while (!command.equals("Game Time")){
            switch (command){
                case "RoverWatch":
                    if (budget < RoverWatch){
                        System.out.println("Too Expensive");
                    }else {
                        budget -= RoverWatch;
                        totalSpent += RoverWatch;
                        System.out.println("Bought RoverWatch");
                    }
                    if (budget <= 0){
                        System.out.println("Out of money!");
                        noMoney = false;
                        break;
                    }
                    break;
                case "Honored 2":
                    if (budget < Honored2){
                        System.out.println("Too Expensive");
                    }else {
                        budget -= Honored2;
                        totalSpent += Honored2;
                        System.out.println("Bought Honored 2");
                    }
                    if (budget <= 0){
                        System.out.println("Out of money!");
                        noMoney = false;
                        break;
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if (budget < RoverWatchOriginsEdition){
                        System.out.println("Too Expensive");
                    }else {
                        budget -= RoverWatchOriginsEdition;
                        totalSpent += RoverWatchOriginsEdition;
                        System.out.println("Bought RoverWatch Origins Edition");
                    }
                    if (budget <= 0){
                        System.out.println("Out of money!");
                        noMoney = false;
                        break;
                    }
                    break;
                case "Zplinter Zell":
                    if (budget < ZplinterZell){
                        System.out.println("Too Expensive");
                    }else {
                        budget -= ZplinterZell;
                        totalSpent += ZplinterZell;
                        System.out.println("Bought Zplinter Zell");
                    }
                    if (budget <= 0){
                        System.out.println("Out of money!");
                        noMoney = false;
                        break;
                    }
                    break;
                case "CS: OG":
                    if (budget < CSGO){
                        System.out.println("Too Expensive");
                    }else {
                        budget -= CSGO;
                        totalSpent += CSGO;
                        System.out.println("Bought CS: OG");
                    }
                    if (budget <= 0){
                        System.out.println("Out of money!");
                        noMoney = false;
                        break;
                    }
                    break;
                case "OutFall 4":
                    if (budget < OutFall4){
                        System.out.println("Too Expensive");
                    }else {
                        budget -= OutFall4;
                        totalSpent += OutFall4;
                        System.out.println("Bought OutFall 4");
                    }
                    if (budget <= 0){
                        System.out.println("Out of money!");
                        noMoney = false;
                        break;
                    }
                    break;
                default:
                    System.out.println("Not Found");
            }
            command = scanner.nextLine();
        }
        if (noMoney){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f\n",totalSpent,budget);
        }
    }
}
