package Programming_f.BasicSyntax.FinalExamExercices;

import java.util.*;
import java.util.stream.Collectors;

public class NeedForSpeed_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> mileageMap = new TreeMap<>();
        Map<String,Integer> fuelMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            List<String> input = Arrays
                    .stream(scanner.nextLine().split("\\|"))
                    .collect(Collectors.toList());
            String car = input.get(0);
            int mileage = Integer.parseInt(input.get(1));
            int fuel = Integer.parseInt(input.get(2));

            mileageMap.put(car,mileage);
            fuelMap.put(car,fuel);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            List<String> input = Arrays
                    .stream(command.split(" : "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);
            String car = input.get(1);

            switch (firstCommand){
                case "Drive":
                    int distanceDrive = Integer.parseInt(input.get(2));
                    int fuel = Integer.parseInt(input.get(3));
                    int currentMileage = mileageMap.get(car);
                    int currentFuel = fuelMap.get(car);
                    if (currentFuel < fuel){
                        System.out.println("Not enough fuel to make that ride");
                    }else {
                        currentMileage += distanceDrive;
                        currentFuel -= fuel;
                        mileageMap.put(car,currentMileage);
                        fuelMap.put(car,currentFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",car,distanceDrive,fuel);
                    }
                    if (currentMileage >= 100000){
                        mileageMap.remove(car);
                        fuelMap.remove(car);
                        System.out.printf("Time to sell the %s!\n",car);
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(input.get(2));
                    int currentFuelCar = fuelMap.get(car);
                    currentFuelCar += refuel;
                    if (currentFuelCar <= 75){
                        fuelMap.put(car,currentFuelCar);
                        System.out.printf("%s refueled with %d liters\n",car,refuel);
                    }else {
                        int firstFuel = fuelMap.get(car);
                        firstFuel = 75;
                        int ref = firstFuel + refuel - currentFuelCar;
                        fuelMap.put(car,firstFuel);
                        System.out.printf("%s refueled with %d liters\n",car,ref);
                    }
                    break;
                case "Revert":
                    int kilometres = Integer.parseInt(input.get(2));
                    int currentMileages = mileageMap.get(car);
                    currentMileages -= kilometres;
                    if (currentMileages <= 10000){
                        mileageMap.put(car,10000);
                    }else {
                        mileageMap.put(car,currentMileages);
                        System.out.printf("%s mileage decreased by %d kilometers\n",car,kilometres);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        mileageMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                        entry.getKey(),entry.getValue(),fuelMap.get(entry.getKey())));
    }
}
