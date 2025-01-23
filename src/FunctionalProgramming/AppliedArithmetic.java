package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        Function<Integer, Integer> funcAdd = number -> number++;
        Function<Integer, Integer> funcMultiply = number -> number * 2;
        Function<Integer, Integer> funcSubtract= number -> number--;
        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    for (Integer number : numbers) {
                        funcAdd.apply(number);
                    }
                    break;
                case "multiply":
                    for (Integer number : numbers) {
                        funcMultiply.apply(number);
                    }
                    break;
                case "subtract":
                    for (Integer number : numbers) {
                        funcSubtract.apply(number);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
