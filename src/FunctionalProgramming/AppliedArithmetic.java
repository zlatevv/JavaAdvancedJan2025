package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        Function<Integer, Integer> funcAdd = number -> number + 1;
        Function<Integer, Integer> funcMultiply = number -> number * 2;
        Function<Integer, Integer> funcSubtract= number -> number-1;
        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command) {
                case "add" -> numbers = numbers.stream().map(funcAdd).collect(Collectors.toList());
                case "multiply" -> numbers = numbers.stream().map(funcMultiply).toList();
                case "subtract" -> numbers = numbers.stream().map(funcSubtract).toList();
                case "print" -> {
                    for (Integer number : numbers) {
                        System.out.print(number + " ");
                    }System.out.println();
                }
            }command = scanner.nextLine();
        }
    }
}
