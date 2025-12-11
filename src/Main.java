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

/**
 * A simple JavaFX animation examples. Animates a Circle's X property by
 * translating (moving) it 200 points over 10 seconds.
 */


//The story begins with exposition of the world: the player was recently displaced by something. They don't have money, but the town square has an old piano. The player has vague memories of learning basics during childhood, and they begin practicing. at this point, start either a tutorial or an easy song. next, they keep practicing and meet a teacher. they can choose to learn under the teacher or practice themselves. if they practice themselves, the next song is harder(not sure how though,this might not be mandatory as well). depending on their score they gain money. if they get enough money, they can move on to playing in a bar. If they picked a teacher the teacher has no more to teach and the bar songs get harder to play. if not, the songs are easier to play because the player grasped the essence of piano themselves. when they play enough and earn enough, they can play at the town hall for the mayor who praises the player if they do well and taxes them if they dont(they go back to the bar). 


public class Main extends Application {
    private Scene scene;
    private SceneManager sceneManager;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        sceneManager = new SceneManager();

        // Start on the main menu screen
        //var initialRoot = sceneManager.createGameScreen();
        var initialRoot = sceneManager.createMenuScreen();

        // Create one Scene and reuse it
        scene = new Scene(initialRoot, 800, 600);

        //GameScreen rhythmGame = new GameScreen(sceneManager);

        // Give the Scene to the manager so it can swap roots later
        sceneManager.setScene(scene);
        primaryStage.setTitle("Perfected Peerless Penniless Piano Pursuit");

        primaryStage.setScene(scene);
        primaryStage.show();
        // sceneManager.showRhythmGame();

    }
}
