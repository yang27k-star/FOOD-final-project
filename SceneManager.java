import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneManager {

    private Scene scene;

    // Called once after the Scene is created
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    // new screens
    public Parent createMenuView() {
        return new view.MenuView(this);
    }

    public Parent createGameView() {
        return new view.GameView(this);
    }

    // Public navigation methods:

    public void showMenu() {
        ensureSceneInitialized();
        scene.setRoot(createMainMenuView());
    }

    public void showGame() {
        ensureSceneInitialized();
        scene.setRoot(createGameView());
    }
}