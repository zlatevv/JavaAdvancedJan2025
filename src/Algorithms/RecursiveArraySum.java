package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = recursiveSum(array, 0);
        System.out.println(sum);
    }

    private static int recursiveSum(int[] array, int index) {
        if (index == array.length){
            return 0;
        }
        return array[index] + recursiveSum(array, index + 1);
    }
}
