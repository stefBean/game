module at.fhcampus.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhcampus.game to javafx.fxml;
    exports at.fhcampus.game;
}