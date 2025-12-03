package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import src.SceneManager; 

public class MenuScreen extends VBox {

    public MenuScreen(SceneManager sceneManager) {
        setSpacing(10);
        setAlignment(Pos.CENTER);
    }
}