package Generics.Exercise.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            Box box = new Box<>(value);
            System.out.println(box);
        }
    }
}
