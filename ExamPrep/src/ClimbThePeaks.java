import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> conqueredPeaks = new ArrayList<>();
        List<String> peaks = new ArrayList<>(List.of("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        int days = 0;

        int[] portionInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] staminaInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> portionQuantity = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQuantity = new ArrayDeque<>();
        StackFiller(portionQuantity , portionInput);
        QueueFiller(staminaQuantity, staminaInput);

        while (conqueredPeaks.size() < 5 && days < 7){
            days++;

            int currentStamina = staminaQuantity.poll();
            int currentPortion = portionQuantity.pop();
            int currentSum = currentPortion + currentStamina;
            String currentPeak = peaks.getFirst();

            switch (currentPeak){
                case "Vihren" -> {
                    if (currentSum >= 80){
                        peaks.removeFirst();
                        conqueredPeaks.add("Vihren");

                    }
                }case "Kutelo" -> {
                    if (currentSum >= 90){
                        peaks.removeFirst();
                        conqueredPeaks.add("Kutelo");

                    }
                }case "Banski Suhodol" -> {
                    if (currentSum >= 100){
                        peaks.removeFirst();
                        conqueredPeaks.add("Banski Suhodol");

                    }
                }case "Polezhan" -> {
                    if (currentSum >= 60){
                        peaks.removeFirst();
                        conqueredPeaks.add("Polezhan");

                    }
                }case "Kamenitza" -> {
                    if (currentSum >= 70){
                        peaks.removeFirst();
                        conqueredPeaks.add("Kamenitza");

                    }
                }
            }
        }
        if (conqueredPeaks.size() == 5){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!conqueredPeaks.isEmpty()){
            System.out.println("Conquered peaks:");
            for (String conqueredPeak : conqueredPeaks) {
                System.out.println(conqueredPeak);
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
