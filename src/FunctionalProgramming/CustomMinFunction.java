package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        System.out.println(Collections.min(numbers));
    }
}
