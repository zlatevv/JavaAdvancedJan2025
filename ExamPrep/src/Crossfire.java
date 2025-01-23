import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        matrixFill(matrix, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")){
            String[] tokens = command.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)){
                    matrix.get(row).remove(i);
                }
            }
            matrix.removeIf(List::isEmpty);

            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void matrixFill(List<List<Integer>> matrix, int row, int col){
        int counter = 1;
        for (int i = 0; i < row; i++) {
            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                currentList.add(counter);
                counter++;
            }
            matrix.add(currentList);
        }
    }
    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}