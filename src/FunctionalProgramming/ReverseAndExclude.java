package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(scanner.nextLine());

        int[] filteredNumbers = Arrays.stream(numbers)
                .filter(number -> number % n != 0)
                .toArray();
        for (int i = 0; i < filteredNumbers.length; i++) {
            System.out.print(filteredNumbers[filteredNumbers.length - i - 1] + " ");
        }
    }
}
