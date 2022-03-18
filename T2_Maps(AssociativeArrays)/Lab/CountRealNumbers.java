package Programming_f.BasicSyntax.AssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        Map<Integer,Integer> numbersMap = new TreeMap<>();

        for (int i = 0; i < numbers.size(); i++) {

            if (!numbersMap.containsKey(numbers.get(i))){
                numbersMap.put(numbers.get(i),1);
            }else {
                numbersMap.put(numbers.get(i),numbersMap.get(numbers.get(i)) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%s -> %d\n",entry.getKey(),entry.getValue());
        }

    }
}
