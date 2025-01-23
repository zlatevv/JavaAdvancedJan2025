package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = System.out::println;
        String[] input = scanner.nextLine().split("\\s+");
        Arrays.stream(input).forEach(printer);
    }
}
