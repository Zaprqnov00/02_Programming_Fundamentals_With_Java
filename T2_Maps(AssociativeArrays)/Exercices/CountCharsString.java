package Programming_f.BasicSyntax.AssociativeArraysExercices;

import java.util.*;

public class CountCharsString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String text = scanner.nextLine();

      Map<Character,Integer> mapSymbolCount = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (symbol == ' '){
                continue;
            }
            if (!mapSymbolCount.containsKey(symbol)){
                mapSymbolCount.put(symbol,1);
            }else {
                int currentSymbolSum = mapSymbolCount.get(symbol);
                mapSymbolCount.put(symbol,currentSymbolSum + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : mapSymbolCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
