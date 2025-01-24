package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        int[] divisors = parseDivisors(scanner.nextLine());

        Predicate<Integer> isDivisibleByAll = num -> {
            for (int divisor : divisors) {
                if (divisor != 0 && num % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (isDivisibleByAll.test(i)) {
                result.add(i);
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] parseDivisors(String input) {
        String[] parts = input.split("\\s+");
        int[] divisors = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            divisors[i] = Integer.parseInt(parts[i]);
        }
        return divisors;
    }
}
