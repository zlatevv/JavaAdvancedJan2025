import java.util.Scanner;

public class Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        matrixFill(matrix, scanner, size);

        int[] beePosition = findBee(matrix);
        int beeRow = beePosition[0];
        int beeCol = beePosition[1];

        int energy = 15;
        int nectar = 0;
        boolean energyRestortion = false;

        while (energy > 0){
            String command = scanner.nextLine();
            int newRow = beeRow;
            int newCol = beeCol;
            switch (command){
                case "up":
                    newRow = getNewValue(beeRow - 1, matrix);
                    break;
                case "down":
                    newRow = getNewValue(beeRow + 1, matrix);
                    break;
                case "left":
                    newCol = getNewValue(beeCol - 1, matrix);
                    break;
                case "right":
                    newCol = getNewValue(beeCol + 1, matrix);
            }
            energy--;
            if (Character.isDigit(matrix[newRow][newCol])){
                nectar += Integer.parseInt(String.valueOf(matrix[newRow][newCol]));
            }if (matrix[newRow][newCol] == 'H'){
                matrix[newRow][newCol] = 'B';
                matrix[beeRow][beeCol] = '-';
                if (nectar >= 30){
                    System.out.printf("Great job, Beesy! The hive is full. Energy left: %d\n", energy);
                }else{
                    System.out.println("Beesy did not manage to collect enough nectar.");
                }
                printMatrix(matrix);
                return;
            }
            matrix[newRow][newCol] = 'B';
            matrix[beeRow][beeCol] = '-';
            beeRow = newRow;
            beeCol = newCol;

            if (energy == 0 && nectar > 30){
                if (!energyRestortion) {
                    energy = nectar - 30;
                    energyRestortion = true;
                }
            }
        }
        System.out.println("This is the end! Beesy ran out of energy.");
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    private static int getNewValue(int i, char[][] matrix) {
        if (i < 0){
            i = matrix.length - 1;
        }else if(i >= matrix.length){
            i = 0;
        }
        return i;
    }

    private static int[] findBee(char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'B'){
                    position[0] = i;
                    position[1] = j;
                }
            }
        }return position;
    }

    private static void matrixFill(char[][] matrix, Scanner scanner, int row) {
        for (int i = 0; i < row; i++) {
            String currentRow = scanner.nextLine();
            matrix[i] = currentRow.toCharArray();
        }
    }
}
