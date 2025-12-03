import view;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneManager {

    private Scene scene;

    // Called once after the Scene is created
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    // create new screens
    public Parent createMenu() {
        return new view.MenuScreen(this);
    }

    public Parent createGameScreen() {
        return new view.GameScreen(this);
    }

    // navigation methods
    public void showMainMenu() {
        scene.setRoot(createMenu());
    }

    public void showGame() {
        scene.setRoot(createGameScreen());
    }
}