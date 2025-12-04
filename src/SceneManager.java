//import view;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneManager {

    private Scene scene;

    // Called once after the Scene is created
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    // create new screens

    public Parent createGameScreen() {
        return new GameScreen(this);
    }

    public Parent createRhythmGameScreen() {
        return new RhythmGame(this);
    }

    public void showRhythmGame() {
        scene.setRoot(createRhythmGameScreen());
    }

    public Parent createDialogueScreen() {
        return new DialogueScreen(this);
    }

    public void showDialogueScreen() {
        scene.setRoot(createDialogueScreen());
    }

    // navigation methods

    public void showGameScreen() {
        scene.setRoot(createGameScreen());
    }
}