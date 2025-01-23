import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the damage done to Heigan each turn
        double damageToHeigan = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        // Initialize player and Heigan's hit points
        double playerHitPoints = 18500;
        double heiganHitPoints = 3000000;

        // Player's starting position
        int playerRow = 7;
        int playerCol = 7;

        // Damage tracking
        double plagueCloudDamage = 0;
        boolean isPlagueCloudActive = false;

        // Variable to store the last spell that hit the player
        String lastSpell = "";

        // Process spells
        while (heiganHitPoints > 0 && playerHitPoints > 0) {
            String input = scanner.nextLine();
            String[] spellInfo = input.split(" ");
            String spell = spellInfo[0];
            int spellRow = Integer.parseInt(spellInfo[1]);
            int spellCol = Integer.parseInt(spellInfo[2]);

            // Apply damage from the previous turn's Plague Cloud if active
            if (isPlagueCloudActive) {
                playerHitPoints -= 3500;
                isPlagueCloudActive = false; // Plague Cloud expires after one turn
            }

            // Check if the player is hit by the spell
            if (isPlayerHit(playerRow, playerCol, spellRow, spellCol)) {
                lastSpell = spell; // Store the last spell that hit the player
                if (spell.equals("Cloud")) {
                    plagueCloudDamage = 3500;
                    isPlagueCloudActive = true;
                } else if (spell.equals("Eruption")) {
                    playerHitPoints -= 6000;
                }

                // Try to move the player
                if (!tryMove(playerRow, playerCol, spellRow, spellCol)) {
                    // If the player cannot move, they take damage
                    if (isPlagueCloudActive) {
                        playerHitPoints -= plagueCloudDamage;
                    }
                }
            }

            // Apply damage to Heigan
            heiganHitPoints -= damageToHeigan;

            // Check if Heigan is defeated
            if (heiganHitPoints <= 0) {
                break;
            }
        }

        // Output results
        if (heiganHitPoints <= 0) {
            System.out.printf("Heigan: Defeated!%n");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        }

        if (playerHitPoints <= 0) {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %.2f%n", playerHitPoints);
        }

        System.out.printf("Final position: {%d, %d}%n", playerRow, playerCol);
    }

    private static boolean isPlayerHit(int playerRow, int playerCol, int spellRow, int spellCol) {
        return (playerRow >= spellRow - 1 && playerRow <= spellRow + 1) &&
                (playerCol >= spellCol - 1 && playerCol <= spellCol + 1);
    }

    private static boolean tryMove(int playerRow, int playerCol, int spellRow, int spellCol) {
        // Define possible moves: up, right, down, left
        int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] move : moves) {
            int newRow = playerRow + move[0];
            int newCol = playerCol + move[1];
            if (isValidMove(newRow, newCol, spellRow, spellCol)) {
                return true; // Successfully moved
            }
        }
        return false; // No valid move
    }

    private static boolean isValidMove(int row, int col, int spellRow, int spellCol) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }
}