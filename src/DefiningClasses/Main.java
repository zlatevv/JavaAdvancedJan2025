package DefiningClasses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car();
            if (input.length >= 1) {
                car.brand = input[0];
            }if (input.length >= 2) {
                car.model = input[1];
            }if (input.length == 3) {
                car.horsePower = Integer.parseInt(input[2]);
            }
            System.out.printf("The car is: %s %s - %d HP.\n", car.brand, car.model, car.horsePower);
        }
    }
}
