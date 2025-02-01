import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> worms = new ArrayDeque<>();
        ArrayDeque<Integer> holes = new ArrayDeque<>();

        int[] wormsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] holesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        StackFiller(worms, wormsInput);
        QueueFiller(holes, holesInput);
        int matches = 0;
        int totalWorms = worms.size();

        while (!worms.isEmpty() && !holes.isEmpty()) {
            int currentHole = holes.poll();
            int currentWorm = worms.pop();

            if (currentWorm != currentHole) {
                currentWorm -= 3;
                if (currentWorm > 0) {
                    worms.push(currentWorm);
                }
            } else {
                matches++;
            }
        }
        if (matches > 0) {
            System.out.printf("Matches: %d%n", matches);
        } else {
            System.out.println("There are no matches.");
        }
        if (matches == totalWorms) {
            System.out.println("Every worm found a suitable hole!");
        } else if (worms.isEmpty()) {
            System.out.println("Worms left: none ");
        } else {
            System.out.print("Worms left: ");
            while (!worms.isEmpty()) {
                int currentWorm = worms.pollLast();
                if (!worms.isEmpty()) {
                    System.out.print(currentWorm + ", ");
                } else {
                    System.out.print(currentWorm);
                }
            }
            System.out.println();
        }
        if (holes.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            System.out.print("Holes left: ");
            while (!holes.isEmpty()) {
                int currentHole = holes.poll();
                if (!holes.isEmpty()) {
                    System.out.print(currentHole + ", ");
                } else {
                    System.out.print(currentHole);
                }
            }
        }
    }






    private static void StackFiller(ArrayDeque<Integer> beeKillers, int[] eaters) {
        for (int eater : eaters) {
            beeKillers.push(eater);
        }
    }

    private static void QueueFiller(ArrayDeque<Integer> beeGroups, int[] groups) {
        for (int group : groups) {
            beeGroups.offer(group);
        }
    }
}
