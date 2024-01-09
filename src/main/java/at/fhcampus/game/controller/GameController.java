// Step 4: Update the GameController class in the controller package

package at.fhcampus.game.controller;

import at.fhcampus.game.figures.Ghost;
import at.fhcampus.game.figures.PacMan;
import at.fhcampus.game.gui.Field;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;

public class GameController {

    private static final double PACMAN_SPEED = 5.0;
    private static final double GHOST_SPEED = 3.0;

    private PacMan pacMan;
    private Field field;
    private Ghost ghost;
    private int score;
    private boolean gameOver;

    public GameController(Field field, PacMan pacMan, Ghost ghost) {
        this.field = field;
        this.pacMan = pacMan;
        this.ghost = ghost;
        initialize();
    }

    private void initialize() {
        // Set up event handlers and initialize game components
        field.getChildren().addAll(pacMan.getImageView(), ghost.getImageView());

        // Set up the game loop
        new GameLoop().start();
    }

    // Handle user input
    public void handleKeyPress(KeyEvent event) {
        if (!gameOver) {
            switch (event.getCode()) {
                case UP:
                    pacMan.move(0, -PACMAN_SPEED);
                    break;
                case DOWN:
                    pacMan.move(0, PACMAN_SPEED);
                    break;
                case LEFT:
                    pacMan.move(-PACMAN_SPEED, 0);
                    break;
                case RIGHT:
                    pacMan.move(PACMAN_SPEED, 0);
                    break;
                default:
                    // Handle other key presses if needed
                    break;
            }
        }
    }

    private class GameLoop extends AnimationTimer {

        private long lastUpdateTime = 0;

        @Override
        public void handle(long now) {
            // Update game state in each frame
            if (lastUpdateTime == 0) {
                lastUpdateTime = now;
            }

            double elapsedTime = (now - lastUpdateTime) / 1e9; // Convert to seconds
            updateGameState(elapsedTime);

            lastUpdateTime = now;
        }
    }

    private void updateGameState(double elapsedTime) {
        // Implement game logic, check collisions, and update positions
        if (!gameOver) {
            // Update PacMan position
            double pacManX = pacMan.getImageView().getX();
            double pacManY = pacMan.getImageView().getY();

            // Update Ghost position
            double ghostX = ghost.getImageView().getX();
            double ghostY = ghost.getImageView().getY();

            // Check for collision
            if (checkCollision(pacManX, pacManY, ghostX, ghostY)) {
                handleCollision();
            }

            // Update the positions of PacMan and Ghost
            pacMan.move(0, 0); // Placeholder, replace with actual movement
            ghost.move(GHOST_SPEED * elapsedTime, 0); // Placeholder, replace with actual movement

            // Check winning condition (for example, reaching a certain score)
            if (score >= 100) {
                handleWin();
            }

            // TODO: Implement scoring and other game logic
        }
    }

    private boolean checkCollision(double x1, double y1, double x2, double y2) {
        // Implement collision detection logic
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance < 30; // Adjust the threshold as needed
    }

    private void handleCollision() {
        // Implement what should happen when PacMan collides with a Ghost
        // For example, reset positions, decrease score, etc.
        score -= 10;
        field.updateScore(score);
        pacMan.getImageView().setX(0);
        pacMan.getImageView().setY(0);
        ghost.getImageView().setX(field.getWidth() - ghost.getImageView().getFitWidth());
        ghost.getImageView().setY(field.getHeight() - ghost.getImageView().getFitHeight());

        // Check losing condition (for example, reaching a certain negative score)
        if (score <= -50) {
            handleLose();
        }
    }

    private void handleWin() {
        // Implement actions when the player wins
        gameOver = true;
        System.out.println("Congratulations! You win!");
    }

    private void handleLose() {
        // Implement actions when the player loses
        gameOver = true;
        System.out.println("Game over! You lose!");
    }
}
