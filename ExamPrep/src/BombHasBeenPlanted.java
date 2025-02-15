import java.util.Arrays;
import java.util.Scanner;

public class BombHasBeenPlanted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = dimensions[0];
        int col = dimensions[1];

        char[][] matrix = new char[row][col];
        matrixFill(matrix, scanner, row);

        int[] playerCoordinates = FindPlayerPosition(matrix);
        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];
        int seconds = 16;
        boolean terrostKill = false;
        String command = scanner.nextLine();

        while (seconds > 0){
            int newRow = playerRow;
            int newCol = playerCol;
            switch (command){
                case "up"->{
                    if (getNewValue(newRow - 1, matrix)){
                        newRow--;
                    }
                }case "down"-> {
                    if (getNewValue(newRow + 1, matrix)) {
                        newRow++;
                    }
                }case "right"->{
                    if (getNewValue(newCol + 1, matrix)) {
                        newCol++;
                    }
                }case "left"->{
                    if (getNewValue(newCol - 1, matrix)) {
                        newCol--;
                    }
                } case "defuse"-> seconds--;
            }
            if (matrix[newRow][newCol] == 'B'){
                command = scanner.nextLine();
                if (command.equals("defuse")){
                    seconds -= 4;
                    if (seconds > 0){
                        matrix[newRow][newCol] = 'D';
                    }else{
                        matrix[newRow][newCol] = 'X';
                    }
                    break;
                }else{
                    switch (command){
                        case "up"->{
                            if (getNewValue(newRow - 1, matrix)){
                                newRow--;
                            }
                        }case "down"-> {
                            if (getNewValue(newRow + 1, matrix)) {
                                newRow++;
                            }
                        }case "right"->{
                            if (getNewValue(newCol + 1, matrix)) {
                                newCol++;
                            }
                        }case "left"->{
                            if (getNewValue(newCol - 1, matrix)) {
                                newCol--;
                            }
                        }
                    }
                }
            }else if(matrix[newRow][newCol] == 'T'){
                matrix[newRow][newCol] = '*';
                terrostKill = true;
            }
            playerRow = newRow;
            playerCol = newCol;
            command = scanner.nextLine();
            seconds--;
        }
        if (seconds < 0 && !terrostKill){
            System.out.println("Terrorists win!");
            System.out.println("Bomb was not defused successfully!");
            System.out.printf("Time needed: %d second/s.", 4 + Math.abs(seconds));
        }
        else if(terrostKill){
            System.out.println("Terrorists win!");
        }
        else{
            System.out.println("Counter-terrorist wins!");
            System.out.printf("Bomb has been defused: %d second/s remaining.", seconds);
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

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    private static int[] FindPlayerPosition(char[][] matrix) {
        int[] playerPosition = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'C') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }
        return playerPosition;
    }
    private static boolean getNewValue(int value, char[][] matrix){
        return value >= 0 && value < matrix.length && value < matrix[0].length;
    }
}
