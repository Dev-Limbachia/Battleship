package com.battlefleetsystems.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * The GameUtilsTest class provides unit tests for the GameUtils class.
 */
public class GameUtilsTest {

    /**
     * Tests the checkHit method with a scenario where a ship is present at the specified location.
     */
    @Test
    void testCheckHit() {
        char[][] board = new char[10][10];
        board[5][5] = 'S';  // Place ship at (5,5)
        assertTrue(GameUtils.checkHit(board, 5, 5), "Should return true when hitting a ship.");
    }

    /**
     * Tests the checkHit method with a scenario where no ship is present at the specified location.
     */
    @Test
    void testCheckMiss() {
        char[][] board = new char[10][10];
        assertFalse(GameUtils.checkHit(board, 5, 5), "Should return false when no ship is at location.");
    }

    /**
     * Tests the checkAllShipsSunk method with a scenario where all ships on the board are sunk.
     */
    @Test
    void testAllShipsSunk() {
        char[][] board = new char[10][10];
        for (char[] chars : board) {
            // Simulate all ships being hit
            Arrays.fill(chars, '*');
        }
        assertTrue(GameUtils.checkAllShipsSunk(board), "Should return true when all ships are sunk.");
    }
}
