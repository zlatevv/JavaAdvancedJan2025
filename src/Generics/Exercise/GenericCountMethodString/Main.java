package Generics.Exercise.GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            Box<String> box = new Box<>(value);

            boxes.add(box);
        }
        String comparingElement = scanner.nextLine();
        int count = compare(boxes, comparingElement);
        System.out.println(count);
    }
    public static int compare(List<Box<String>> boxes, String comparingElement){
        int count = 0;
        for (Box<String> box : boxes) {
            if (box.getValue().compareTo(comparingElement) > 0){
                count++;
            }
        }
        return count;
    }
}
