import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] contestantsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] piesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> contestants = new ArrayDeque<>();
        ArrayDeque<Integer> pies = new ArrayDeque<>();
        QueueFiller(contestants, contestantsInput);
        StackFiller(pies, piesInput);

        while (!contestants.isEmpty() && !pies.isEmpty()){
            int currentContestant = contestants.poll();
            int currentPie = pies.pop();

            if (currentContestant >= currentPie){
                currentContestant -= currentPie;
                if (currentContestant > 0){
                    contestants.offer(currentContestant);
                }
            }else {
                currentPie -= currentContestant;
                if (currentPie == 1){
                    if (!pies.isEmpty()) {
                        int secondToLastPie = pies.pop();
                        secondToLastPie += currentPie;
                        pies.push(secondToLastPie);
                    }else{
                        pies.push(currentPie);
                    }
                }else{
                    pies.push(currentPie);
                }
            }
        }
        if (pies.isEmpty() && !contestants.isEmpty()){
            System.out.println("We will have to wait for more pies to be baked!");
            String result = contestants.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Contestants left: " +result);
        }
        else if(pies.isEmpty()){
            System.out.println("We have a champion!");
        }else{
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: ");
            while (!pies.isEmpty()){
                int currentPie = pies.pollLast();
                if (pies.isEmpty()){
                    System.out.print(currentPie);
                }else{
                    System.out.print(currentPie + ", ");
                }
            }
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
