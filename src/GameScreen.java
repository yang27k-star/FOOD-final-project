//package view;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
//import SceneManager; 

public class GameScreen extends VBox {
    private Scene scene;
    private SceneManager sceneManager;

    public GameScreen(SceneManager sceneManager) {
        // Basic layout setup
        setSpacing(10);
        setAlignment(Pos.CENTER);

        // Create UI controls
        Button startButton = new Button("Start Game");
        Button exitButton = new Button("Exit");

        // Hook up behavior
        startButton.setOnAction(e -> sceneManager.showGame());
        exitButton.setOnAction(e -> System.exit(0));

        // Add controls to this layout
        getChildren().addAll(startButton, exitButton);
    }
}
