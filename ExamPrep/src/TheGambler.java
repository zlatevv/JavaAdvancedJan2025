import java.util.Scanner;

public class TheGambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] gameBoard = new char[n][n];
        matrixFill(gameBoard, scanner, n);

        int[] playerPosition = FindPlayerPosition(gameBoard);
        int row = playerPosition[0];
        int col = playerPosition[1];
        int money = 100;
        boolean lost = false;
        boolean won = false;

        String command = scanner.nextLine();
        label:
        while (!command.equals("end")){
            int newRow = row;
            int newCol = col;
            switch (command) {
                case "up" -> {
                    if (getNewValue(newRow - 1, gameBoard)) {
                        newRow--;
                    } else {
                        lost = true;
                        break label;
                    }
                }
                case "down" -> {
                    if (getNewValue(newRow + 1, gameBoard)) {
                        newRow++;
                    } else {
                        lost = true;
                        break label;
                    }
                }
                case "right" -> {
                    if (getNewValue(newCol + 1, gameBoard)) {
                        newCol++;
                    } else {
                        lost = true;
                        break label;
                    }
                }
                default -> {
                    if (getNewValue(newCol - 1, gameBoard)) {
                        newCol--;
                    } else {
                        lost = true;
                        break label;
                    }
                }
            }

            if (gameBoard[newRow][newCol] == 'W'){
                money += 100;
            }else if(gameBoard[newRow][newCol] == 'P'){
                money -= 200;
                if (money <= 0){
                    lost = true;
                    break;
                }
            }else if(gameBoard[newRow][newCol] == 'J'){
                money += 100000;
                won = true;
                gameBoard[row][col] = '-';
                gameBoard[newRow][newCol] = 'G';
                break;
            }
            gameBoard[row][col] = '-';
            gameBoard[newRow][newCol] = 'G';
            row = newRow;
            col = newCol;

            command = scanner.nextLine();
        }
        if (won){
            System.out.println("You win the Jackpot!");
            System.out.printf("End of the game. Total amount: %d$%n", money);
            printMatrix(gameBoard);
        }else if(!lost){
            System.out.printf("End of the game. Total amount: %d$%n", money);
            printMatrix(gameBoard);
        }else{
            System.out.println("Game over! You lost everything!");
        }
    }

    private static boolean getNewValue(int i, char[][] gameBoard) {
        return i >= 0 && i < gameBoard.length;
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
                if (matrix[i][j] == 'G') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }
        return playerPosition;
    }

}
