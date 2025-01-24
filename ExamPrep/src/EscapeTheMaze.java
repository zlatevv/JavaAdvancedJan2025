import java.util.Scanner;

public class EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int playerHealth = 100;
        boolean defeated = false;
        boolean escaped = false;

        char[][] matrix = new char[size][size];
        matrixFill(matrix, scanner, size);

        int[] playerPosition = FindPlayerPosition(matrix);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        while (true){
            String command = scanner.nextLine();
            int newRow = playerRow;
            int newCol = playerCol;
            switch (command){
                case "up":
                    newRow = getNewValue(newRow - 1, matrix);
                    break;
                case "down":
                    newRow = getNewValue(newRow + 1, matrix);
                    break;
                case "right":
                    newCol = getNewValue(newCol + 1, matrix);
                    break;
                case "left":
                    newCol = getNewValue(newCol - 1, matrix);
                    break;
            }
            if (matrix[newRow][newCol] == 'M'){
                playerHealth -= 40;
                if (playerHealth <= 0){
                    playerHealth = 0;
                    defeated = true;
                    matrix[newRow][newCol] = 'P';
                    matrix[playerRow][playerCol] = '-';
                    break;
                }
            }else if(matrix[newRow][newCol] == 'H'){
                playerHealth += 15;
                if (playerHealth > 100){
                    playerHealth = 100;
                }
            }else if(matrix[newRow][newCol] == 'X'){
                escaped = true;
                matrix[newRow][newCol] = 'P';
                matrix[playerRow][playerCol] = '-';
                break;
            }
            matrix[newRow][newCol] = 'P';
            matrix[playerRow][playerCol] = '-';
            playerRow = newRow;
            playerCol = newCol;
        }
        if (defeated){
            System.out.println("Player is dead. Maze over!");
            System.out.printf("Player's health: %d units", playerHealth);
        }if(escaped){
            System.out.println("Player escaped the maze. Danger passed!");
            System.out.printf("Player's health: %d units", playerHealth);
        }
        System.out.println();
        printMatrix(matrix);
    }

    private static void matrixFill(char[][] matrix, Scanner scanner, int row) {
        for (int i = 0; i < row; i++) {
            String currentRow = scanner.nextLine();
            matrix[i] = currentRow.toCharArray();
        }
    }

    private static int[] FindPlayerPosition(char[][] matrix) {
        int[] playerPosition = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'P') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }
        return playerPosition;
    }
    private static int getNewValue(int i, char[][] matrix) {
        if (i < 0){
            i++;
        }else if(i == matrix.length){
            i--;
        }
        return i;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}
