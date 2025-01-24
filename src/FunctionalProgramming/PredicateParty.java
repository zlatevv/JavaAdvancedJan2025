package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial guest list
        List<String> guests = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));

        // Process commands
        String command;
        while (!(command = scanner.nextLine()).equals("Party!")) {
            String[] parts = command.split("\\s+");
            String action = parts[0];
            String conditionType = parts[1];
            String conditionValue = parts[2];
            
            Predicate<String> condition = getPredicate(conditionType, conditionValue);
            
            if (action.equals("Remove")) {
                guests.removeIf(condition);
            } else if (action.equals("Double")) {
                List<String> toAdd = new ArrayList<>();
                for (String guest : guests) {
                    if (condition.test(guest)) {
                        toAdd.add(guest);
                    }
                }
                guests.addAll(toAdd);
            }
        }
        
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            guests.sort(String::compareTo);
            System.out.print(String.join(", ", guests));
            System.out.print(" are going to the party!");
        }
    }
    private static Predicate<String> getPredicate(String conditionType, String conditionValue) {
        return switch (conditionType) {
            case "StartsWith" -> name -> name.startsWith(conditionValue);
            case "EndsWith" -> name -> name.endsWith(conditionValue);
            case "Length" -> name -> name.length() == Integer.parseInt(conditionValue);
            default -> throw new IllegalStateException("Unexpected value: " + conditionType);
        };
    }
}
