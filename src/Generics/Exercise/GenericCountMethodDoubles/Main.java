package Generics.Exercise.GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double value = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(value);

            boxes.add(box);
        }
        double comparingElement = Double.parseDouble(scanner.nextLine());
        int count = compare(boxes, comparingElement);
        System.out.println(count);
    }
    public static int compare(List<Box<Double>> boxes, double comparingElement){
        int count = 0;
        for (Box<Double> box : boxes) {
            if (box.getValue() > comparingElement){
                count++;
            }
        }
        return count;
    }
}
