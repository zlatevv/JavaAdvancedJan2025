import java.util.Scanner;

public class ReverseDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int[][] matrix = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        printReversedDiagonals(matrix, R, C);
    }

    private static void printReversedDiagonals(int[][] matrix, int R, int C) {
        String[][] diagonals = new String[R + C - 1][];

        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                int diagKey = (R - 1 - i) + (C - 1 - j);
                if (diagonals[diagKey] == null) {
                    diagonals[diagKey] = new String[0];
                }

                diagonals[diagKey] = append(diagonals[diagKey], String.valueOf(matrix[i][j]));
            }
        }


        for (String[] diagonal : diagonals) {
            if (diagonal != null) {

                System.out.println(String.join(" ", diagonal));
            }
        }
    }
    private static String[] append(String[] array, String value) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}