package at.fhcampus.game.gui;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Field extends Pane {

    private Text scoreText;

    // Set up the game field
    public Field() {
        setPrefSize(800, 600); // Set your preferred size for the game field
        scoreText = new Text("Score: 0");
        scoreText.setFont(Font.font(20));
        scoreText.setTranslateY(20);
        getChildren().add(scoreText);
        // TODO: Add grid lines or background image for the game field
    }

    public void updateScore(int score) {
        scoreText.setText("Score: " + score);
    }
}
