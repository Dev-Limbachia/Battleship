package com.battlefleetsystems.battleship;

/**
 * The GameUtils class provides utility methods for checking hits and sinking ships in Battleship.
 */
public class GameUtils {

    /**
     * Checks if a hit occurs at the specified position on the game board.
     *
     * @param board The game board
     * @param row The row of the position to check
     * @param col The column of the position to check
     * @return true if a ship is hit, false otherwise
     */
    public static boolean checkHit(char[][] board, int row, int col) {
        // Check if the position contains a ship ('S')
        if (board[row][col] == 'S') {
            board[row][col] = '*';  // Mark hit on the board
            return true; // Return true if a ship is hit
        }
        return false; // Return false if no ship is hit
    }

    /**
     * Checks if all ships on the game board are sunk.
     *
     * @param board The game board
     * @return true if all ships are sunk, false otherwise
     */
    public static boolean checkAllShipsSunk(char[][] board) {
        // Loop through each cell of the board
        for (char[] chars : board) {
            for (char aChar : chars) {
                // Check if any ship ('S') still exists
                if (aChar == 'S') return false;  // Ship still exists
            }
        }
        return true;  // All ships sunk if no ship is found
    }
}
