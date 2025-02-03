package Generics.Exercise.CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!command.equals("END")){
            String[] tokens = command.split("\\s+");
            String currentCommand = tokens[0];
            switch (currentCommand){
                case "Add" ->{
                    String element = tokens[1];
                    customList.add(element);
                }
                case "Remove" -> {
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                }
                case "Contains" -> {
                    String element = tokens[1];
                    System.out.println(customList.contains(element));
                }
                case "Swap" -> {
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    customList.swap(index1, index2);
                }
                case "Greater" -> {
                    String element = tokens[1];
                    System.out.println(customList.countGreaterThan(element));
                }
                case "Max" -> System.out.println(customList.getMax());
                case "Min" -> System.out.println(customList.getMin());
                case "Print"-> customList.print();
                case "Sort" -> customList.sort();

            }
            command = scanner.nextLine();
        }
    }
}
