//import view;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import java.util.Timer;
// import java.util.TimerTask;

public class SceneManager {

    private Scene scene;
    int rhythmGamesPlayed = 0;

    // Called once after the Scene is created
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    // create new screens

    public Parent createMenuScreen() {
        return new MenuScreen(this);
    }

    public Parent createRhythmGameScreen() {
        return new RhythmGame(this);
    }

    public void showRhythmGame() {
        rhythmGamesPlayed++;
        scene.setRoot(createRhythmGameScreen());
    }

    public int getRhythmGamesPlayed() {
        return rhythmGamesPlayed;
    }

    public Parent createDialogueScreen() {
        return new DialogueScreen(this);
    }

    public void showDialogueScreen() {
        scene.setRoot(createDialogueScreen());
    }

    // navigation methods

    public void showMenuScreen() {
        rhythmGamesPlayed = 0;
        scene.setRoot(createMenuScreen());
    }
}