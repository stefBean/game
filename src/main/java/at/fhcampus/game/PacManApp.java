package at.fhcampus.game;

import at.fhcampus.game.controller.GameController;
import at.fhcampus.game.figures.Ghost;
import at.fhcampus.game.figures.PacMan;
import at.fhcampus.game.gui.Field;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PacManApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set up the game components
        Field field = new Field();
        PacMan pacMan = new PacMan();
        Ghost ghost = new Ghost(field.getWidth() - 50, field.getHeight() - 50);

        // Set up the game controller
        GameController gameController = new GameController(field, pacMan, ghost);

        // Set up the scene
        Scene scene = new Scene(field);
        scene.setOnKeyPressed(gameController::handleKeyPress);

        // Set up the stage
        primaryStage.setTitle("PacMan 4.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
