import java.util.ArrayDeque;
import java.util.Scanner;

public class RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> packages = new ArrayDeque<>();
        ArrayDeque<Integer> couriers = new ArrayDeque<>();
        String[] packageInput = scanner.nextLine().split("\\s+");
        String[] courierInput = scanner.nextLine().split("\\s+");

        stackFill(packages, packageInput);
        queueFill(couriers, courierInput);
        int totalWeight = 0;

        while (!packages.isEmpty() && !couriers.isEmpty()){
            int currentCourier = couriers.poll();
            int currentPackage = packages.pop();

            if (currentCourier >= currentPackage){
                if (currentCourier > currentPackage){
                    currentCourier -= currentPackage * 2;
                    if (currentCourier > 0){
                        couriers.offer(currentCourier);
                    }
                }totalWeight += currentPackage;
            }else{
                currentPackage -= currentCourier;
                packages.push(currentPackage);
                totalWeight += currentCourier;
            }
        }

        System.out.printf("Total weight: %d kg\n", totalWeight);
        if (packages.isEmpty() && couriers.isEmpty()){
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }else if(!packages.isEmpty() && couriers.isEmpty()){
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            while (!packages.isEmpty()){
                int currentPackage = packages.pollLast();
                if (packages.isEmpty()){
                    System.out.print(currentPackage + " ");
                }else{
                    System.out.print(currentPackage + ", ");
                }
            }
        }else{
            System.out.println("Couriers are still on duty: ");
            while (!couriers.isEmpty()){
                int currentCourier = couriers.pollLast();
                if (couriers.isEmpty()){
                    System.out.print(currentCourier + " ");
                }else{
                    System.out.print(currentCourier + ", ");
                }
            }
            System.out.println("but there are no more packages to deliver.");
        }
    }




    private static void queueFill(ArrayDeque<Integer> couriers, String[] courierInput) {
        for (String courier : courierInput) {
            couriers.offer(Integer.parseInt(courier));
        }
    }

    private static void stackFill(ArrayDeque<Integer> packages, String[] packageInput) {
        for (String currentPackage : packageInput) {
            packages.push(Integer.parseInt(currentPackage));
        }
    }
}