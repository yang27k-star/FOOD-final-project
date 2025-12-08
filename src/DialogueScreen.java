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
    

        Label narration = new Label("You see flowers everywhere, stretching past welcoming mountains and lovely valley alike.");
        Button startButton = new Button("Wake up.");
        getChildren().addAll(startButton, narration);
        startButton.setOnAction(e -> {
            getChildren().remove(startButton);
            narration.setText("Oh... That was a dream. You find yourself in your same old bed, the same, smelly clothes, and the same 12-cent-per-day closet you sleep in.");
            getChildren().add(narration);
            Button continueButton = new Button("Continue");
            getChildren().add(continueButton);
            continueButton.setOnAction(ee -> {
                getChildren().removeAll(continueButton,narration);
                narration.setText("Searching for your usual donation at the mall entrance, you suddenly notice a decrepit upright piano hidden conspicuously near you. Suddenly, memories of your past appear: your grandmother used to sit you on her lap and have you play 'Hot Cross Buns'");
                getChildren().add(narration);
                Button playPiano = new Button("Play the piano");
                Button leavePiano = new Button("Walk away");
                getChildren().addAll(playPiano, leavePiano);
                playPiano.setOnAction(eee -> {
                    getChildren().removeAll(playPiano,narration);
                    narration.setText("What is this feeling... You feel... INSPIRED");
                    getChildren().addAll(narration,continueButton);
                    continueButton.setOnAction(eeee -> {
                        getChildren().removeAll(continueButton,narration);
                        sceneManager.createRhythmGameScreen();
                        sceneManager.showRhythmGame();
                    });
                });
            });
            
        });
        //exitButton.setOnAction(e -> System.exit(0));

        // Add controls to this layout
        //getChildren().addAll(startButton/*, exitButton*/);

        //Button exitButton = new Button("Exit");
    }
}