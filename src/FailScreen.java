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
import java.util.TimerTask;
import java.util.Timer;
//import java.lang.Thread;
//import SceneManager; 

public class FailScreen extends VBox {

    
    //int rhythmGamesPlayed = 0;

    public FailScreen(SceneManager sceneManager) {

        setSpacing(10);
        setAlignment(Pos.CENTER);
        
        Button restartLevel = new Button("Restart Level");
        Button exitbutton = new Button("Exit");
        Label justKidding = new Label("Just kidding! \nYou failed the level");
        
        
        restartLevel.setFont(new Font("Arial", 18));
        exitbutton.setFont(new Font("Arial", 18));
        justKidding.setFont(new Font("Arial", 18));
       
        getChildren().addAll(justKidding,restartLevel,exitbutton);
        restartLevel.setOnAction(e-> {
            sceneManager.restartLevel();
            sceneManager.showRhythmGame();
        });
        exitbutton.setOnAction(ee-> System.exit(0));
    
        
    }
}