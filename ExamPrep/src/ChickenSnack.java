import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> money = new ArrayDeque<>();
        ArrayDeque<Integer> prices = new ArrayDeque<>();
        int[] moneyInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] pricesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        StackFiller(money, moneyInput);
        QueueFiller(prices, pricesInput);
        int foods = 0;

        while (!money.isEmpty() && !prices.isEmpty()){
            int currentPrice = prices.poll();
            int currentMoney = money.pop();
            if (currentMoney == currentPrice){
                foods++;
            }else if(currentMoney > currentPrice){
                foods++;
                int change = currentMoney - currentPrice;
                if (money.size() > 1) {
                    int lastElement = money.pop();
                    lastElement += change;
                    money.push(lastElement);
                }else{
                    money.push(change);
                }
            }
        }
        if (foods >= 4){
            System.out.printf("Gluttony of the day! Henry ate %d foods.", foods);
        }else if(foods > 1){
            System.out.printf("Henry ate: %d foods.", foods);
        }else if (foods == 1){
            System.out.println("Henry ate: 1 food.");
        }else{
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }

    private static void QueueFiller(ArrayDeque<Integer> beeGroups, int[] groups) {
        for (int group : groups) {
            beeGroups.offer(group);
        }
    }

    private static void StackFiller(ArrayDeque<Integer> beeKillers, int[] eaters) {
        for (int eater : eaters) {
            beeKillers.push(eater);
        }
    }
}
