package at.fhcampus.game.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Ghost {
    private static final String GHOST_IMAGE_PATH = "images/pngwing.com.png";
    private static final double GHOST_SIZE = 40.0;

    private ImageView imageView;

    public Ghost(double initialX, double initialY) {
        // Initialize Ghost image and set initial position
        Image image = new Image(getClass().getResourceAsStream(GHOST_IMAGE_PATH));
        imageView = new ImageView(image);
        imageView.setFitWidth(GHOST_SIZE);
        imageView.setFitHeight(GHOST_SIZE);
        imageView.setX(initialX);
        imageView.setY(initialY);
    }

    // Implement movement and other Ghost behaviors
    public void move(double deltaX, double deltaY) {
        imageView.setX(imageView.getX() + deltaX);
        imageView.setY(imageView.getY() + deltaY);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
