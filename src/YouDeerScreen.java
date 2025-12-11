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

public class YouDeerScreen extends VBox {

    
    //int rhythmGamesPlayed = 0;

    public YouDeerScreen(SceneManager sceneManager) {

        int timerOver = 0;

        setSpacing(10);
        setAlignment(Pos.CENTER);
        
        Label youDeer = new Label("YOU\nDEER");
        youDeer.setFont(new Font("Arial", 180));
 
        getChildren().add(youDeer);

        class youDeerTaskSetter extends TimerTask {
            public void run() {
                sceneManager.showFailScreen();
            }
        }
        Timer removeYouDeerTime = new Timer();
        TimerTask removeYouDeerTask = new youDeerTaskSetter();
        
        removeYouDeerTime.schedule(removeYouDeerTask, 2222);
    }
}