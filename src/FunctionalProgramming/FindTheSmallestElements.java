package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Function<List<Integer>, Integer> findIndex = index -> index.lastIndexOf(Collections.min(numbers));

        System.out.println(findIndex.apply(numbers));
    }
}
