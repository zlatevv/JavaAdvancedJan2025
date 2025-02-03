package Generics.Exercise.GenericSwapMethodStrings;

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
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();
        swap(boxes, index1, index2);

        for (Box<String> box : boxes) {
            System.out.println(box);
        }
    }
    public static <T> void swap(List<T> list, int index1, int index2){
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
