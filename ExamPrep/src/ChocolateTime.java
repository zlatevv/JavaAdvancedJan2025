import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] milkInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] chocolateInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        ArrayDeque<Double> milkQuantity = new ArrayDeque<>();
        ArrayDeque<Double> cacaoQuantity = new ArrayDeque<>();
        QueueFiller(milkQuantity, milkInput);
        StackFiller(cacaoQuantity, chocolateInput);

        int milkChocolateCount = 0;
        int darkChocolateCount = 0;
        int bakingChocolateCount = 0;
        Map<String, Integer> chocolates = new TreeMap<>();

        while (!milkQuantity.isEmpty() && !cacaoQuantity.isEmpty()){
            double currentMilk = milkQuantity.poll();
            double currentCacao = cacaoQuantity.pop();

            double cacaoPercentage = (currentCacao / (currentMilk + currentCacao)) * 100;

            if (cacaoPercentage == 30){
                milkChocolateCount++;
                chocolates.put("Milk Chocolate", milkChocolateCount);
            }else if(cacaoPercentage == 50){
                darkChocolateCount++;
                chocolates.put("Dark Chocolate", darkChocolateCount);
            }else if(cacaoPercentage == 100){
                bakingChocolateCount++;
                chocolates.put("Baking Chocolate", bakingChocolateCount);
            }else{
                currentMilk += 10;
                milkQuantity.offer(currentMilk);
            }
        }

        if (milkChocolateCount >= 1 && darkChocolateCount >= 1 && bakingChocolateCount >= 1){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolates.forEach((name,count) -> System.out.printf("# %s --> %d%n", name, count));
    }

    private static void StackFiller(ArrayDeque<Double> beeKillers, double[] eaters) {
        for (double eater : eaters) {
            beeKillers.push(eater);
        }
    }

    private static void QueueFiller(ArrayDeque<Double> beeGroups, double[] groups) {
        for (double group : groups) {
            beeGroups.offer(group);
        }
    }
}
