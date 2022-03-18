package Programming_f.BasicSyntax.RegularExpressionsExercices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String regex = "%(?<name>[A-Z][a-z]+)%[^$%|.]*<(?<product>[A-z]+)>[^$%|.]*\\|(?<count>[0-9]+)\\|[^$%|.]*?(?<price>[0-9.]+)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalSum = 0;
        while (!command.equals("end of shift")){
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {

                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double sum = count * price;
                totalSum += sum;

                System.out.printf("%s: %s - %.2f\n",name,product,sum);
            }

            command = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalSum);
    }
}
