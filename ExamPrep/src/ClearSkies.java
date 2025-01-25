import java.util.Scanner;

public class ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] airspace = new char[size][size];

        matrixFill(airspace, scanner, size);

        int[] jetPosition = FindPlayerPosition(airspace);
        int jetRow = jetPosition[0];
        int jetCol = jetPosition[1];
        int health = 300;

        while (findEnemy(airspace)){
            String command = scanner.nextLine();
            int newJetRow = jetRow;
            int newJetCol = jetCol;
            switch (command){
                case "up":
                    newJetRow--;
                    break;
                case "down":
                    newJetRow++;
                    break;
                case "left":
                    newJetCol--;
                    break;
                case "right":
                    newJetCol++;
            }
            if (airspace[newJetRow][newJetCol] == 'E'){
                health -= 100;
                airspace[newJetRow][newJetCol] = 'J';
                airspace[jetRow][jetCol] = '-';
                if (health <= 0){
                    System.out.print("Mission failed, your jetfighter was shot down! ");
                    System.out.printf("Last coordinates [%d, %d]!", newJetRow, newJetCol);
                    airspace[newJetRow][newJetCol] = 'J';
                    airspace[jetRow][jetCol] = '-';
                    break;
                }
            }else if(airspace[newJetRow][newJetCol] == 'R'){
                if (health < 300){
                    health += 300;
                }
            }
            airspace[newJetRow][newJetCol] = 'J';
            airspace[jetRow][jetCol] = '-';
            jetRow = newJetRow;
            jetCol = newJetCol;

        }
        System.out.println();
        if (!findEnemy(airspace)){
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }printMatrix(airspace);
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
            }System.out.println();
        }
    }

    private static int[] FindPlayerPosition(char[][] matrix) {
        int[] playerPosition = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'J') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }return playerPosition;
    }
    private static boolean findEnemy(char[][] matrix){
        boolean hasEnemy = false;
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == 'E') {
                    hasEnemy = true;
                    break;
                }
            }
        }return hasEnemy;
    }
}
