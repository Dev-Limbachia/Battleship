# Battleship Game

## Overview
Battleship is a classic two-player strategy game where each player tries to sink the opponent's fleet of ships. The game is played on a grid-based board.

## How to Play
### Setup
1. **Board Creation**: Each player is given a grid-based board. Typically, the board consists of 10x10 cells, but this can vary depending on the version of the game.
2. **Fleet Placement**: Each player secretly arranges their fleet of ships on their own board. The ships cannot overlap or be placed diagonally. The standard fleet consists of:
    - 1 Aircraft Carrier (5 cells)
    - 1 Battleship (4 cells)
    - 1 Cruiser (3 cells)
    - 1 Submarine (3 cells)
    - 1 Destroyer (2 cells)

### Gameplay
1. **Turns**: Players take turns firing shots at their opponent's board by calling out coordinates (e.g., "B3", "H8").
2. **Hit or Miss**: If a player's shot lands on a cell occupied by an opponent's ship, it's a hit. Otherwise, it's a miss.
3. **Sinking Ships**: When all cells of a ship are hit, that ship is sunk.
4. **Winning**: The game continues until one player sinks all of their opponent's ships. The player who sinks all opponent's ships first wins the game.

### Example Gameplay
1. Player 1 chooses a cell to target on Player 2's board by calling out coordinates.
2. Player 2 responds with "hit" or "miss".
3. If it's a hit, Player 1 continues their turn until they miss or sink a ship.
4. Players alternate turns until one player wins by sinking all of their opponent's ships.

## Technologies Used
- Java
- JUnit (for testing)

## How to Run
1. Clone the repository to your local machine.
2. Compile the Java code using your preferred IDE or build tool.
3. Run the main class to start the game.

