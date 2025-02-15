import java.util.*;

public class MedievalAlchemy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> substances = new ArrayDeque<>();
        ArrayDeque<Integer> crystals = new ArrayDeque<>();
        int[] substancesInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] crystalsInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StackFiller(substances, substancesInput);
        QueueFiller(crystals, crystalsInput);
        List<String> craftedPotions = new ArrayList<>();
        Map<String, Integer> potions = new LinkedHashMap<>();
        potions.put("Brew of Immortality", 110);
        potions.put("Essence of Resilience", 100);
        potions.put("Draught of Wisdom", 90);
        potions.put("Potion of Agility", 80);
        potions.put("Elixir of Strength", 70);
        while (!potions.isEmpty() && !substances.isEmpty() && !crystals.isEmpty()){
            int currentCrystal = crystals.poll();
            int currentSubstance = substances.pop();
            int sum = currentSubstance + currentCrystal;
            boolean crafted = false;
            for (Map.Entry<String, Integer> entry : potions.entrySet()){
                if (entry.getValue() == sum){
                    if (!craftedPotions.contains(entry.getKey())){
                        craftedPotions.add(entry.getKey());
                        potions.remove(entry.getKey());
                        crafted = true;
                        break;
                    }
                }
            }
            if (!crafted){
                boolean matched = false;
                for (Map.Entry<String, Integer> entry : potions.entrySet()){
                    if (entry.getValue() < sum){
                        potions.remove(entry.getKey());
                        craftedPotions.add(entry.getKey());
                        currentCrystal -= 20;
                        matched = true;
                        if (currentCrystal > 0){
                            crystals.offer(currentCrystal);
                        }
                        break;
                    }
                }
                if (!matched){
                    currentCrystal -= 5;
                    if (currentCrystal > 0){
                        crystals.offer(currentCrystal);
                    }
                }
            }
        }
        if (potions.isEmpty()){
            System.out.println("Success! The alchemist has forged all potions!");
        }else{
            System.out.println("The alchemist failed to complete his quest.");
        }
        if (!craftedPotions.isEmpty()){
            System.out.print("Crafted potions: ");
            for (int i = 0; i < craftedPotions.size(); i++) {
                System.out.print(craftedPotions.get(i));
                if (i < craftedPotions.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        if(!substances.isEmpty()){
            System.out.print("Substances: ");
            while (!substances.isEmpty()){
                System.out.print(substances.pop());
                if (!substances.isEmpty()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        if (!crystals.isEmpty()){
            System.out.print("Crystals: ");
            while (!crystals.isEmpty()){
                System.out.print(crystals.poll());
                if (!crystals.isEmpty()){
                    System.out.print(", ");
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
