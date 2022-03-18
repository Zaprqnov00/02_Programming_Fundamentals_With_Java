package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "@#+(?<name>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();

            Matcher matcher = pattern.matcher(barcode);

            String product = "";
            if (matcher.find()){
                String name = matcher.group("name");
                for (int j = 0; j < name.length(); j++) {
                    char symbol = name.charAt(j);
                    if (Character.isDigit(symbol)){
                        product += symbol;
                    }
                }
                if (product.equals("")){
                    System.out.println("Product group: 00");
                }else {
                    System.out.println("Product group: " + product);
                }
            }else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
