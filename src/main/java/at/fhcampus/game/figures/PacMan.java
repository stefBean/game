package at.fhcampus.game.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PacMan {
    private static final String PACMAN_IMAGE_PATH = "images/pacman-png-25195.png";
    private static final double PACMAN_SIZE = 40.0;

    private ImageView imageView;

    public PacMan() {
        // Initialize PacMan image and set initial position
        Image image = new Image(getClass().getResourceAsStream(PACMAN_IMAGE_PATH));
        imageView = new ImageView(image);
        imageView.setFitWidth(PACMAN_SIZE);
        imageView.setFitHeight(PACMAN_SIZE);
        imageView.setX(0);
        imageView.setY(0);
    }

    // Implement movement and other PacMan behaviors
    public void move(double deltaX, double deltaY) {
        imageView.setX(imageView.getX() + deltaX);
        imageView.setY(imageView.getY() + deltaY);
    }

    public ImageView getImageView() {
        return imageView;
    }
}