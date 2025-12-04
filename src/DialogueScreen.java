//package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Label;
//import src.SceneManager; 

public class DialogueScreen extends VBox {

    public DialogueScreen(SceneManager sceneManager) {
        setSpacing(10);
        setAlignment(Pos.CENTER);
        Text text = new Text("This is a text.");
        VBox vBox = new VBox(text);

        
        Scene scene = new Scene(new VBox(text), 300, 250);
        

        text.setText("This is the text to display");
        text.setX(50);
        text.setY(25);
        Label gameLabel = new Label("Game Screen Placeholder");

        Button startButton = new Button("Wake up.");
        startButton.setOnAction(e -> {
            System.out.println("stuff");
            
        });
        //exitButton.setOnAction(e -> System.exit(0));

        // Add controls to this layout
        getChildren().addAll(startButton/*, exitButton*/);

        //Button exitButton = new Button("Exit");
    }
}