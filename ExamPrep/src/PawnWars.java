import java.util.Arrays;
import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];
        matrixFill(board, scanner, 8);

        boolean whiteCaptures = false;
        boolean blackCaptures = false;
        int[] whitePosition = new int[2];
        int[] blackPosition = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'w'){
                    whitePosition[0] = i;
                    whitePosition[1] = j;
                }else if(board[i][j] == 'b'){
                    blackPosition[0] = i;
                    blackPosition[1] = j;
                }
            }
        }
        int whiteRow = whitePosition[0];
        int whiteCol = whitePosition[1];
        int blackRow = blackPosition[0];
        int blackCol = blackPosition[1];

        while (true){
            whiteRow--;
            if (isCapture(blackRow, blackCol, whiteRow, whiteCol)){
                System.out.println("Game over! Black capture on " + getCoordinates(whiteRow, whiteCol) + ".");
                break;

            }if (whiteRow == 0) {
                System.out.println("Game over! White pawn is promoted to a queen at " + getCoordinates(whiteRow, whiteCol) + ".");
                break;
            }
            if (isCapture(whiteRow, whiteCol, blackRow, blackCol)){
                    System.out.println("Game over! White capture on " + getCoordinates(blackRow, blackCol) + ".");
                    break;
            }
            blackRow++;
            if (blackRow == 7) {
                System.out.println("Game over! Black pawn is promoted to a queen at " + getCoordinates(blackRow, blackCol) + ".");
                break;
            }
        }
    }

    private static String getCoordinates(int row, int col) {
        char letter = (char) ('a' + col);
        int number = 8 - row;
        return "" + letter + number;
    }

    private static boolean isCapture(int movingRow, int movingCol, int opponentRow, int opponentCol) {
        return (opponentRow == movingRow + 1 && (opponentCol == movingCol - 1 || opponentCol == movingCol + 1));
    }

    private static void matrixFill(char[][] matrix, Scanner scanner, int row) {
        for (int i = 0; i < row; i++) {
            String currentRow = scanner.nextLine();
            matrix[i] = currentRow.toCharArray();
        }
    }
}
