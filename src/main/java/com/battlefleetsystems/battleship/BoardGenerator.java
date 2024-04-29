package com.battlefleetsystems.battleship;

import java.util.Arrays;
import java.util.Random;

/**
 * The BoardGenerator class generates the game board for Battleship.
 * It initializes the board, places ships randomly, and provides a method to print the board.
 */
public class BoardGenerator {

    /** The random number generator used for ship placement */
    private static final Random random = new Random();

    /**
     * Generates a game board for Battleship with the specified size.
     *
     * @param size The size of the square game board
     * @return The generated game board represented as a 2D char array
     */
    public static char[][] generateBoard(int size) {
        char[][] board = new char[size][size];
        initializeBoard(board);
        placeShipsRandomly(board, size);
        return board;
    }

    /**
     * Initializes the game board with empty sea cells ('.').
     *
     * @param board The game board to initialize
     */
    private static void initializeBoard(char[][] board) {
        // Loop through each row of the board
        for (char[] chars : board) {
            // Fill each row with empty sea cells
            Arrays.fill(chars, '.');
        }
    }

    /**
     * Randomly places ships of predefined sizes on the game board.
     *
     * @param board The game board on which to place the ships
     * @param size The size of the game board
     */
    private static void placeShipsRandomly(char[][] board, int size) {
        // Predefined ship sizes
        int[] shipSizes = {5, 4, 3, 3, 2};
        // Loop through each ship size
        for (int shipSize : shipSizes) {
            // Place the ship on the board
            placeShip(board, size, shipSize);
        }
    }

    /**
     * Places a ship of the specified size on the game board.
     *
     * @param board The game board on which to place the ship
     * @param size The size of the game board
     * @param shipSize The size of the ship to place
     */
    private static void placeShip(char[][] board, int size, int shipSize) {
        boolean placed = false;
        // Loop until the ship is successfully placed
        while (!placed) {
            // Randomly choose a direction (0 for horizontal, 1 for vertical)
            int direction = random.nextInt(2);
            // Randomly choose a starting row and column
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            // Check if the ship can be placed at the chosen position
            if (canPlaceShip(board, row, col, shipSize, direction, size)) {
                // Place the ship on the board
                for (int i = 0; i < shipSize; i++) {
                    if (direction == 0) board[row][col + i] = 'S'; // Place horizontally
                    else board[row + i][col] = 'S'; // Place vertically
                }
                placed = true;
            }
        }
    }

    /**
     * Checks if a ship of the specified size can be placed at the given position.
     *
     * @param board The game board
     * @param row The starting row of the ship
     * @param col The starting column of the ship
     * @param shipSize The size of the ship to place
     * @param direction The direction (0 for horizontal, 1 for vertical)
     * @param size The size of the game board
     * @return true if the ship can be placed, false otherwise
     */
    private static boolean canPlaceShip(char[][] board, int row, int col, int shipSize, int direction, int size) {
        // Loop through each cell of the ship
        for (int i = 0; i < shipSize; i++) {
            // Calculate the new row and column based on the direction
            int newRow = direction == 0 ? row : row + i;
            int newCol = direction == 0 ? col + i : col;
            // Check if the new position is within the board boundaries and not occupied
            if (newRow >= size || newCol >= size || board[newRow][newCol] != '.') return false;
            // Check if there are adjacent ships
            if (hasAdjacentShips(board, newRow, newCol, size)) return false;
        }
        return true;
    }

    /**
     * Checks if there are adjacent ships around the specified position.
     *
     * @param board The game board
     * @param row The row of the position
     * @param col The column of the position
     * @param size The size of the game board
     * @return true if there are adjacent ships, false otherwise
     */
    private static boolean hasAdjacentShips(char[][] board, int row, int col, int size) {
        // Loop through neighboring cells
        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                int checkRow = row + dRow, checkCol = col + dCol;
                // Check if the neighboring cell is within the board boundaries
                if (checkRow >= 0 && checkRow < size && checkCol >= 0 && checkCol < size) {
                    // Check if the neighboring cell contains a ship
                    if (board[checkRow][checkCol] == 'S') return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints the game board to the console.
     *
     * @param board The game board to print
     */
    public static void printBoard(char[][] board) {
        System.out.print("  ");
        // Print column labels (A, B, C, ...)
        for (int i = 0; i < board.length; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        // Print each row of the board
        for (int i = 0; i < board.length; i++) {
            System.out.print((i + 1) + " "); // Print row number
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " "); // Print cell contents
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }
}
