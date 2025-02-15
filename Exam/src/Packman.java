import java.util.Scanner;

public class Packman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] gameField = new char[size][size];
        matrixFill(gameField, scanner, size);

        int[] playerCoordinates = FindPlayerPosition(gameField);
        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];
        int health = 100;
        int totalStars = findStars(gameField);
        String command = scanner.nextLine();
        boolean isFrozen = false;

        while (!command.equals("END") && health > 0 && totalStars > 0) {
            int newRow = playerRow;
            int newCol = playerCol;
            switch (command) {
                case "up" -> newRow = getNewValue(newRow - 1, gameField);
                case "down" -> newRow = getNewValue(newRow + 1, gameField);
                case "right" -> newCol = getNewValue(newCol + 1, gameField);
                case "left" -> newCol = getNewValue(newCol - 1, gameField);
            }
            if (gameField[newRow][newCol] == '*') {
                totalStars--;
            } else if (gameField[newRow][newCol] == 'F') {
                isFrozen = true;
            } else if (gameField[newRow][newCol] == 'G') {
                if (isFrozen) {
                    isFrozen = false;
                } else {
                    health -= 50;
                }
            }
            gameField[newRow][newCol] = 'P';
            gameField[playerRow][playerCol] = '-';
            playerRow = newRow;
            playerCol = newCol;
            command = scanner.nextLine();
        }
        if (health <= 0){
            System.out.printf("Game over! Pacman last coordinates [%d,%d]%n", playerRow, playerCol);
        }else if(totalStars == 0){
            System.out.println("Pacman wins! All the stars are collected.");
        }else if(totalStars > 0){
            System.out.println("Pacman failed to collect all the stars.");
        }
        System.out.printf("Health: %d%n", health);
        if (totalStars > 0){
            System.out.printf("Uncollected stars: %d%n", totalStars);
        }
        printMatrix(gameField);
    }

    private static int getNewValue(int i, char[][] gameField) {
        if (i >= gameField.length){
            i = 0;
        }else if(i < 0){
            i = gameField.length - 1;
        }
        return i;
    }


    private static int findStars(char[][] gameField) {
        int count = 0;
        for (char[] chars : gameField) {
            for (int j = 0; j < gameField.length; j++) {
                if (chars[j] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

    private static void matrixFill(char[][] matrix, Scanner scanner, int row) {
        for (int i = 0; i < row; i++) {
            String currentRow = scanner.nextLine();
            matrix[i] = currentRow.toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
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
}
