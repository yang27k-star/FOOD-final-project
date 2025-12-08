//package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
//import src.SceneManager; 

public class DialogueScreen extends VBox {

    public DialogueScreen(SceneManager sceneManager) {
        setSpacing(10);
        
        setAlignment(Pos.CENTER);
    

        Label narration = new Label("You see flowers everywhere, \nstretching past welcoming mountains and lovely valley alike.");
        narration.setFont(new Font("Arial", 18));
        Button startButton = new Button("Wake up.");
        getChildren().addAll(startButton, narration);
        startButton.setOnAction(e -> {
            getChildren().remove(startButton);
            narration.setText("Oh... That was a dream. You find yourself in your same old bed, the same, smelly clothes, \nand the same 12-cent-per-day closet you sleep in.");
            Button continueButton = new Button("Continue");
            getChildren().add(continueButton);
            continueButton.setOnAction(ee -> {
                getChildren().removeAll(continueButton,narration);
                narration.setText("Searching for your usual donation at the mall entrance, \nyou suddenly notice a decrepit upright piano hidden conspicuously near you. \nSuddenly, memories of your past appear: your grandmother \nused to sit you on her lap and have you play 'Hot Cross Buns'");
                Button playPiano = new Button("Play the piano");
                Button leavePiano = new Button("Walk away");
                getChildren().addAll(narration, leavePiano,playPiano);
                playPiano.setOnAction(eee -> {
                    getChildren().remove(narration);
                    narration.setText("What is this feeling... You feel... INSPIRED");
                    getChildren().add(narration);
                    getChildren().removeAll(playPiano,leavePiano);
                    getChildren().add(continueButton);
                    continueButton.setOnAction(eeee -> {
                        getChildren().removeAll(continueButton,narration);
                        sceneManager.createRhythmGameScreen();
                        sceneManager.showRhythmGame();
                        narration.setText("Woah! You surprised even yourself. Your performance drew heads, and, soon, a small pile of coins appears.");
                    });
                });
                leavePiano.setOnAction(eeee -> {
                    getChildren().removeAll(playPiano,narration,leavePiano);
                    narration.setText("You left. You spend the rest of your life on the streets, fighting with rats for rotten scraps.");
                    getChildren().add(narration);
                });
            });
            
        });
        //exitButton.setOnAction(e -> System.exit(0));

        // Add controls to this layout
        //getChildren().addAll(startButton/*, exitButton*/);

        //Button exitButton = new Button("Exit");
    }
}