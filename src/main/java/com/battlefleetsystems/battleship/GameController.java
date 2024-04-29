package com.battlefleetsystems.battleship;

import java.util.Scanner;

/**
 * The GameController class manages the gameplay of the Battleship game.
 * It handles player turns, computer turns, and the overall flow of the game.
 */
public class GameController {

    /** The scanner object used for user input */
    private static final Scanner scanner = new Scanner(System.in);

    /** The size of the game board */
    private static final int BOARD_SIZE = 10;

    /**
     * Starts the Battleship game.
     * Initializes player and computer boards, and manages the turns until the game is over.
     */
    public static void startGame() {
        // Initialize player and computer boards
        char[][] playerBoard = BoardGenerator.generateBoard(BOARD_SIZE);
        char[][] computerBoard = BoardGenerator.generateBoard(BOARD_SIZE);

        // Display welcome message
        System.out.println("Welcome to Battleship!");

        // Initialize flag for player's turn
        boolean playerTurn = true;

        // Main game loop
        while (true) {
            if (playerTurn) {
                // Player's turn
                if (handlePlayerTurn(computerBoard)) break; // Exit loop if player wins
            } else {
                // Computer's turn
                if (handleComputerTurn(playerBoard)) break; // Exit loop if computer wins
            }
            playerTurn = !playerTurn; // Toggle player's turn
        }
        scanner.close(); // Close scanner to release resources
    }

    /**
     * Handles a player's turn in the game.
     * Displays the player's board, prompts for a move, and processes the move.
     *
     * @param board The opponent's board to attack
     * @return true if the player wins, false otherwise
     */
    static boolean handlePlayerTurn(char[][] board) {
        BoardGenerator.printBoard(board); // Display opponent's board
        System.out.print("Enter your move (e.g., B2): ");
        String move = scanner.nextLine().toUpperCase().trim(); // Get user input

        // Validate user input format
        if (!move.matches("[A-J][1-9]0?")) {
            System.out.println("Invalid input. Please use the format 'ColumnRow' (e.g., B2).");
            return false; // Invalid move, continue the game
        }

        // Convert user input to row and column indices
        int col = move.charAt(0) - 'A';
        int row = Integer.parseInt(move.substring(1)) - 1;

        return processMove(board, row, col, "Player"); // Process the player's move
    }

    /**
     * Handles a computer's turn in the game.
     * Generates a random move for the computer and processes it.
     *
     * @param board The opponent's board to attack
     * @return true if the computer wins, false otherwise
     */
    static boolean handleComputerTurn(char[][] board) {
        int row = (int) (Math.random() * BOARD_SIZE); // Generate random row index
        int col = (int) (Math.random() * BOARD_SIZE); // Generate random column index
        System.out.printf("Computer's move: %c%d%n", col + 'A', row + 1); // Display computer's move

        return processMove(board, row, col, "Computer"); // Process the computer's move
    }

    /**
     * Processes a move on the game board.
     * Checks if the move hits or misses the opponent's ships and updates the board accordingly.
     *
     * @param board The opponent's board to attack
     * @param row The row of the move
     * @param col The column of the move
     * @param mover The player or computer making the move
     * @return true if the opponent's ships are all sunk, false otherwise
     */
    private static boolean processMove(char[][] board, int row, int col, String mover) {
        if (GameUtils.checkHit(board, row, col)) {
            System.out.println(mover + " hits!"); // Display hit message
            if (GameUtils.checkAllShipsSunk(board)) {
                System.out.println("All ships sunk! " + mover + " wins!"); // Display winning message
                return true; // Return true if all opponent's ships are sunk
            }
        } else {
            System.out.println(mover + " misses!"); // Display miss message
        }
        return false; // Return false if opponent's ships are not all sunk
    }
}
