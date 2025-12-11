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

public class EndScreen extends VBox {

    
    //int rhythmGamesPlayed = 0;

    public EndScreen(SceneManager sceneManager) {

        setSpacing(10);
        setAlignment(Pos.CENTER);
        
        Button restartGame = new Button("Restart Game");
        Button exitbutton = new Button("Exit");
        Label endingShower = new Label("The End");
        if(sceneManager.getBoothillFavorability() == 1) {
            endingShower.setText("Galaxy \nRanger \nEnding");
        } else if(sceneManager.getBladeFavorability() == -1){
            endingShower.setText("Script-ed Ending");
        } else if(sceneManager.getBladeFavorability() == 1) {
            endingShower.setText("Stellaron Hunter Ending");
        }
        
        
        restartGame.setFont(new Font("Arial", 18));
        exitbutton.setFont(new Font("Arial", 18));
        endingShower.setFont(new Font("Arial", 130));
       
        getChildren().addAll(endingShower,restartGame,exitbutton);
        restartGame.setOnAction(e-> {
            sceneManager.showMenuScreen();
        });
        exitbutton.setOnAction(ee-> System.exit(0));
    }
}