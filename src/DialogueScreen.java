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
    //int rhythmGamesPlayed = 0;

    public DialogueScreen(SceneManager sceneManager) {
        setSpacing(10);
        
        setAlignment(Pos.CENTER);
        Label narration = new Label("You see flowers everywhere, \nstretching past welcoming mountains and lovely valley alike.");
        narration.setFont(new Font("Arial", 18));
        Button startButton = new Button("Wake up.");
        Button continueButton = new Button("Continue");
        Button badChoice = new Button("Yes");
        Button restart = new Button("Restart");
    
        if(sceneManager.getRhythmGamesPlayed() == 0) {
            getChildren().addAll(narration,startButton);
            startButton.setOnAction(e -> {
                getChildren().remove(startButton);
                narration.setText("Oh... That was a dream. You find yourself in your same old bed, the same, smelly clothes, \nand the same 12-cent-per-day closet you sleep in.");
                getChildren().add(continueButton);
                continueButton.setOnAction(ee -> {
                    //getChildren().removeAll(continueButton);
                    narration.setText("Searching for your usual donation at the mall entrance, \nyou notice a decrepit upright piano hidden conspicuously near you.");
                    continueButton.setOnAction(eee -> {
                        getChildren().remove(continueButton);
                        narration.setText("Suddenly, memories of your past appear: your grandmother \nused to sit you on her lap and have you play 'Hot Cross Buns'");
                        Button playPiano = new Button("Play the piano");
                        Button leavePiano = new Button("Walk away");
                        getChildren().addAll(leavePiano,playPiano);
                        playPiano.setOnAction(eeee -> {
                            //getChildren().remove(narration);
                            narration.setText("What is this feeling... You feel... INSPIRED \n Press ASDF to play the notes, H to hold the long ones");
                            //getChildren().add(narration);
                            getChildren().removeAll(playPiano,leavePiano);
                            getChildren().add(continueButton);
                            continueButton.setOnAction(eeeee -> {
                                getChildren().removeAll(continueButton,narration);
                                //rhythmGamesPlayed++;
                                //sceneManager.createRhythmGameScreen();
                                sceneManager.showRhythmGame();
                            });
                        });
                        leavePiano.setOnAction(eeeee     -> {
                            getChildren().removeAll(playPiano,narration,leavePiano);
                            narration.setText("You left. You spend the rest of your life on the streets, fighting with rats for rotten scraps.");
                            getChildren().addAll(narration,restart);
                            restart.setOnAction(eeeeee-> {
                                sceneManager.showMenuScreen();
                            });
                        });
                    });
                });
                
            });
            //exitButton.setOnAction(e -> System.exit(0));

            // Add controls to this layout
            //getChildren().addAll(startButton/*, exitButton*/);

            //Button exitButton = new Button("Exit");
        } else if(sceneManager.getRhythmGamesPlayed() == 1) {
            narration.setText("Woah! You surprised even yourself. Your performance drew heads, and, \nsoon, a small pile of coins appears.");
            getChildren().addAll(narration,continueButton);
            continueButton.setOnAction(e -> {
                narration.setText("Pick up the coins?");
                continueButton.setText("No");
                getChildren().add(badChoice);
                continueButton.setOnAction(ee -> {
                    getChildren().remove(badChoice);
                    narration.setText("You don't need other people's pity money!\nWill you keep practicing every day, \nor will you keep to what you know and \nleave the piano behind?");
                    continueButton.setText("Practice every day");
                    badChoice.setText("Walk away");
                    badChoice.setOnAction(eeee     -> {
                        getChildren().removeAll(continueButton,badChoice);
                        narration.setText("You left. You spend the rest of your life on the streets, fighting with rats for rotten scraps.");
                        getChildren().add(restart);
                        restart.setOnAction(eeeee-> {
                            sceneManager.showMenuScreen();
                        });
                    });
                    continueButton.setOnAction(eeeeee -> {
                        getChildren().remove(badChoice);
                        narration.setText("You practice every day. Through showers of rain and rotten tomatoes alike, you play the old piano.");
                    });
                });
                badChoice.setOnAction(eee-> {
                    getChildren().remove(badChoice);
                    narration.setText("You picked up $2.89\n\n \"HEY!!! What are you DOING?!?\"");
                    getChildren().add(restart);
                });
            });
        }
    }
}