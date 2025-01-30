package DefiningClasses.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Car>> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Tire tire1 = new Tire(tire1Age, tire1Pressure);
            Tire tire2 = new Tire(tire2Age, tire2Pressure);
            Tire tire3 = new Tire(tire3Age, tire3Pressure);
            Tire tire4 = new Tire(tire4Age, tire4Pressure);
            List<Tire> tires = new ArrayList<>();
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Engine engine = new Engine(engineSpeed, enginePower);
            Car currentCar = new Car(model, engine, cargo, tires);
            List<Car> car = new ArrayList<>();

            if (isInRange(tire1Pressure, tire2Pressure, tire3Pressure, tire4Pressure, enginePower, cargoType)){
                if (cars.containsKey(cargoType)) {
                    car = cars.get(cargoType);

                }
                car.add(currentCar);
                cars.put(cargoType, car);
            }
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")){
            cars.remove("flamable");

        }else if (command.equals("flamable")){
            cars.remove("fragile");

        }

        cars.forEach((key, value) -> value.forEach(e -> System.out.println(e.getModel())));


    }

    private static boolean isInRange(double tirePress1, double tirePress2, double tirePress3, double tirePress4, int enginePower, String cargoType) {

        if (cargoType.equals("fragile")){
            return tirePress1 < 1 || tirePress2 < 1 || tirePress3 < 1 || tirePress4 < 1;
        }else if (cargoType.equals("flamable")){
            return enginePower > 250;
        }

        return false;
    }
}
