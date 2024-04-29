package com.battlefleetsystems.battleship;

/**
 * The main class of the Battleship game.
 * This class contains the main method to start the game.
 */
public class BattleshipGame {

    /**
     * The main method to start the Battleship game.
     * It initializes and starts the game controller to manage the gameplay.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Start the Battleship game by invoking the startGame method of GameController
        GameController.startGame();
    }
}
