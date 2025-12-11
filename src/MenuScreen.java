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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
//import SceneManager; 

public class MenuScreen extends VBox {
    //int rhythmGamesPlayed = 0;

    public MenuScreen(SceneManager sceneManager) {
        setSpacing(10);
        
        setAlignment(Pos.CENTER);
        
        Button startGameButton = new Button("Start Perfected Peerless Penniless Piano Pursuit");
        Button exitbutton = new Button("Exit");
        
        startGameButton.setFont(new Font("Arial", 18));
        exitbutton.setFont(new Font("Arial", 18));
        getChildren().addAll(startGameButton,exitbutton);
        startGameButton.setOnAction(e-> {
            sceneManager.createDialogueScreen();
            sceneManager.showDialogueScreen();
        });
    }
}