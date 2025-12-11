//package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
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
        TextField nameField = new TextField();
        Button submit = new Button("Submit");
        Button impressiveChoice = new Button("Impressive");
    
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
                            narration.setText("What is this feeling... You feel... INSPIRED \nTap ASDF to play the notes, press H to hold the long ones");
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
            narration.setText("Score: " + RhythmGame.getScore() + "\n\nWoah! You surprised even yourself. Your performance drew heads, and, \nsoon, a small stash of money appears.");
            getChildren().addAll(narration,continueButton);
            continueButton.setOnAction(e -> {
                narration.setText("Pick up the bills and coins?");
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
                        narration.setText("You practice every day. \nThrough showers of rain and rotten tomatoes alike, \nyou play the old piano.");
                        continueButton.setText("Continue");
                        continueButton.setOnAction(eeeeeeeee -> {
                            narration.setText("On one especially rainy evening, \nyou notice a hooded figure.");
                            continueButton.setText("Approach the hooded figure");
                            impressiveChoice.setText("Play as you always have");
                            impressiveChoice.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee->{
                                sceneManager.addSeoFavorability(1);
                                sceneManager.showRhythmGame();
                            });
                            continueButton.setOnAction(eeeeeeeeeeeeeeeeee-> {
                                getChildren().remove(impressiveChoice);
                                narration.setText("They notice you.\nStartled, they begin to flee, \nand you catch a glimpse of a \ndark brown strand of hair.");
                                continueButton.setText("Chase after them");
                                badChoice.setText("Play the piano");
                                badChoice.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee->{
                                    sceneManager.showRhythmGame();
                                });
                                continueButton.setOnAction(eeeeeeeeeeeee->{
                                    narration.setText("They seem to be good at \nblending in with the crowd. \nYou lose sight of them.");
                                    continueButton.setText("Keep searching");
                                    badChoice.setText("Play the piano");
                                    badChoice.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeee->{
                                        sceneManager.showRhythmGame();
                                    });
                                    continueButton.setOnAction(eeeeeeeeeeeeee->{
                                        narration.setText("You really can't find them. \nAs you walk back to your favorite sleeping spot,\nyou look into a fancy store and \nspot a full head of gleaming \ndark brown hair---");
                                        continueButton.setText("Continue");
                                        continueButton.setOnAction(eeeeeeeeeeeeeeee->{
                                            narration.setText("She sees you, looks flustered,\nthen runs toward you.\n\"I'm so sorry for running away earlier!\nLet me introduce myself.\nI'm Reese, and I run this cafe.\nI really admire your playing!\nWould you maybe play inside?\nI'll pay you well!\"");
                                            continueButton.setText("Yes");
                                            badChoice.setText("No");
                                            getChildren().add(badChoice);
                                            continueButton.setOnAction(eeeeeeee->{
                                                getChildren().remove(badChoice);
                                                continueButton.setText("Continue");
                                                narration.setText("You start working at Reese's cafe. \nIt's now your first day of work!");
                                                continueButton.setOnAction(eeeeeeeeeee->{
                                                    sceneManager.addCafeOwnerFavorabiltiy(1);
                                                    sceneManager.showRhythmGame();
                                                });
                                            });
                                            badChoice.setOnAction(eeeeeeeeeeeeeeeeeeee->{
                                                narration.setText("\"Oh... Sorry about that\" \nShe leaves.\n\"Hey, you.\"\nYou see a homeless man with his arms around \na long-shaped something wrapped in bandages\n\"Yeah. You. All of our fights are set the \nmoment we raise our fists...\nA youngling like you wouldn't be able to get it. \nJoin me in my hunt.\"");
                                                continueButton.setText("Yes");
                                                badChoice.setText("No");
                                                badChoice.setOnAction(eeeeeeeeeeeeeeeee->{
                                                    getChildren().remove(badChoice);
                                                    narration.setText("\"Then at least let me taste what The Script promised...\"\nHe unwraps his sword.\nStrangely, you are looking at him upside down.\nOh. You realize, but your eyes already start closing.");
                                                    continueButton.setText("Continue");
                                                    continueButton.setOnAction(eeeeeeeeeeee->{
                                                        sceneManager.addBladeFavorability(-1);
                                                        sceneManager.showEndScreen();
                                                    });
                                                });
                                                continueButton.setOnAction(eeeee->{
                                                    narration.setText("He beckons you to follow.\nYou arrive before a strange tablet and\nimmediately realize your fate, along with this man's name:\nBlade.\nYou spend the rest of your days diligently following\n\"The Script\" with Blade.");
                                                    continueButton.setOnAction(eeeeeeeeeeeeeee->{
                                                        sceneManager.addBladeFavorability(1);
                                                        sceneManager.showEndScreen();
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
                badChoice.setOnAction(eee-> {
                    getChildren().remove(badChoice);
                    int score = RhythmGame.getScore();
                    narration.setText("You picked up $" + score/100 + "." + score%100 + "\n\n\"HEY!!! What are you DOIN'?!?\" \nYou turn your head.");
                    continueButton.setText("Continue");
                    continueButton.setOnAction(eeee-> {
                        getChildren().remove(continueButton);
                        narration.setText("You see a very, VERY angry, gruff-looking sheriff walking towards you.\n\"Don't you know beggin' is illegal 'round these here parts? \nWhat's your name?!?\"");
                        getChildren().addAll(nameField,submit);
                        submit.setOnAction(ee-> {
                            sceneManager.setName(nameField.getText());
                            getChildren().removeAll(nameField,submit);
                            narration.setText("\"Hmph. " + sceneManager.getName() + " is it? \nWhat do you have to say for yourself?\"");
                            continueButton.setText("Nothing, sir. Just making a living, sir.");
                            badChoice.setText("I didn't steal. I earned this money.");
                            getChildren().addAll(badChoice,continueButton);
                            continueButton.setOnAction(eeeeeeee-> {
                                narration.setText("\"*Sigh* can't blame a wretch for tryna eat... \nGo on...\nI won't stop ya.\"\nWhat will you do?");
                                sceneManager.addSheriffFavorability(1);
                                continueButton.setText("Practice every day");
                                badChoice.setText("Walk away");
                                badChoice.setOnAction(eeeeeee     -> {
                                getChildren().removeAll(continueButton,badChoice);
                                narration.setText("You left. You spend the rest of your life on the streets, fighting with rats for rotten scraps.");
                                getChildren().add(restart);
                                    restart.setOnAction(eeeee-> {
                                        sceneManager.showMenuScreen();
                                    });
                                });
                                continueButton.setOnAction(eeeeee -> {
                        getChildren().remove(badChoice);
                        narration.setText("You practice every day. \nThrough showers of rain and rotten tomatoes alike, \nyou play the old piano.");
                        continueButton.setText("Continue");
                        continueButton.setOnAction(eeeeeeeee -> {
                            narration.setText("On one especially rainy evening, \nyou notice a hooded figure.");
                            continueButton.setText("Approach the hooded figure");
                            impressiveChoice.setText("Play as you always have");
                            impressiveChoice.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee->{
                                sceneManager.addSeoFavorability(1);
                                sceneManager.showRhythmGame();
                            });
                            continueButton.setOnAction(eeeeeeeeeeeeeeeeee-> {
                                getChildren().remove(impressiveChoice);
                                narration.setText("They notice you.\nStartled, they begin to flee, \nand you catch a glimpse of a \ndark brown strand of hair.");
                                continueButton.setText("Chase after them");
                                badChoice.setText("Play the piano");
                                badChoice.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee->{
                                    sceneManager.showRhythmGame();
                                });
                                continueButton.setOnAction(eeeeeeeeeeeee->{
                                    narration.setText("They seem to be good at \nblending in with the crowd. \nYou lose sight of them.");
                                    continueButton.setText("Keep searching");
                                    badChoice.setText("Play the piano");
                                    badChoice.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeee->{
                                        sceneManager.showRhythmGame();
                                    });
                                    continueButton.setOnAction(eeeeeeeeeeeeee->{
                                        narration.setText("You really can't find them. \nAs you walk back to your favorite sleeping spot,\nyou look into a fancy store and \nspot a full head of gleaming \ndark brown hair---");
                                        continueButton.setText("Continue");
                                        continueButton.setOnAction(eeeeeeeeeeeeeeee->{
                                            narration.setText("She sees you, looks flustered,\nthen runs toward you.\n\"I'm so sorry for running away earlier!\nLet me introduce myself.\nI'm Reese, and I run this cafe.\nI really admire your playing!\nWould you maybe play inside?\nI'll pay you well!\"");
                                            continueButton.setText("Yes");
                                            badChoice.setText("No");
                                            getChildren().add(badChoice);
                                            continueButton.setOnAction(eeeeeeeeeeeeeeeee->{
                                                getChildren().remove(badChoice);
                                                continueButton.setText("Continue");
                                                narration.setText("You start working at Reese's cafe. \nIt's now your first day of work!");
                                                continueButton.setOnAction(eeeeeeeeeee->{
                                                    sceneManager.addCafeOwnerFavorabiltiy(1);;
                                                    sceneManager.showRhythmGame();
                                                });
                                            });
                                            badChoice.setOnAction(eeeeeeeeeeeeeeeeeeee->{
                                                narration.setText("\"Oh... Sorry about that\" \nShe leaves.\n\"Hey, you.\"\nYou see a homeless man with his arms around \na long-shaped something wrapped in bandages\n\"Yeah. You. All of our fights are set the \nmoment we raise our fists...\nA youngling like you wouldn't be able to get it. \nJoin me in my hunt.\"");
                                                continueButton.setText("Yes");
                                                badChoice.setText("No");
                                                badChoice.setOnAction(eeeeeeeeeeeeeeeee->{
                                                    getChildren().remove(badChoice);
                                                    narration.setText("\"Then at least let me taste what The Script promised...\"\nHe unwraps his sword.\nStrangely, you are looking at him upside down.\nOh. You realize, but your eyes already start closing.");
                                                    continueButton.setText("Continue");
                                                    continueButton.setOnAction(eeeeeeeeeeee->{
                                                        sceneManager.addBladeFavorability(-1);
                                                        sceneManager.showEndScreen();
                                                    });
                                                });
                                                continueButton.setOnAction(eeeee->{
                                                    narration.setText("He beckons you to follow.\nYou arrive before a strange tablet and\nimmediately realize your fate, along with this man's name:\nBlade.\nYou spend the rest of your days diligently following\n\"The Script\" with Blade.");
                                                    continueButton.setOnAction(eeeeeeeeeeeeeee->{
                                                        sceneManager.addBladeFavorability(1);
                                                        sceneManager.showEndScreen();
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });             
                            });
                            badChoice.setOnAction(eeeeee-> {
                                getChildren().remove(badChoice);
                                narration.setText("\"YOU... COME WITH ME\" \nYou are taken to the prison");
                                continueButton.setText("Continue");
                                continueButton.setOnAction(eeeeeeeeeee->{
                                    narration.setText("The prison guards go on a weeklong drinking spree.\nThey forget to feed you,\nand you feel the light welcoming you...");
                                    continueButton.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee->{
                                        narration.setText("\"YOU MUDDLEFUDGING SHIRTBAGS! \nI can't stand you goons. \nWhere's the Sheriff?!?\" \nYou hear a fight raging outside.");
                                        continueButton.setOnAction(eeeeeeeeeeeeeeee ->{
                                            narration.setText("A tall, black and white haired man appears. \nHis teeth are jagged, \nhe wears combat medals, \nwields a shining revolver, \nand generally looks like a cowboy. \"Hey you!\nDo you know where the Sheriff is?\nNo? Maybe what he looks like?\"");
                                            continueButton.setText("I do. He's the one who put me here");
                                            badChoice.setText("I'm not helping a scoundrel like you");
                                            getChildren().add(badChoice);
                                            continueButton.setOnAction(eeeeeeeeeeee-> {
                                                narration.setText("\"Hah! What do you say we work together\nto find him? We can have a \nnice long chat with him...\"");
                                                continueButton.setText("Let's go");
                                                badChoice.setText("No");
                                                continueButton.setOnAction(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee -> {
                                                    getChildren().removeAll(continueButton,badChoice);
                                                    sceneManager.addBoothillFavorability(1);
                                                    narration.setText("\"The name's Boothill, \npleasure to work with you, partner.\" \nYou and Boothill find the Sheriff, \nmake him regret his harsh ways, \nand go on to free other cities from corruption's grasp.");
                                                    sceneManager.showEndScreen();
                                                });
                                                badChoice.setOnAction(eeeeeeeeeeeeee ->{
                                                narration.setText("\"Fine. Have it your way.\nThere are only two types of people\nin this world...\nThose with a loaded gun,\nand those who dig their own grave!\" \nHe struts away, never to be seen again");
                                                continueButton.setText("Continue");
                                                continueButton.setOnAction(eeeeeeee-> {
                                                    narration.setText("You died of starvation.");
                                                    getChildren().remove(continueButton);
                                                    getChildren().add(restart);
                                                    restart.setOnAction(eeeee-> {
                                                        sceneManager.showMenuScreen();
                                                    });
                                                });
                                            });
                                            });
                                            badChoice.setOnAction(eeeeeeeeee ->{
                                                narration.setText("\"Fine. Have it your way.\nThere are only two types of people\nin this world...\nThose with a loaded gun,\nand those who dig their own grave!\" \nHe struts away, never to be seen again");
                                                continueButton.setText("Continue");
                                                continueButton.setOnAction(eeeeeeee-> {
                                                    narration.setText("You died of starvation.");
                                                    getChildren().remove(continueButton);
                                                    getChildren().add(restart);
                                                    restart.setOnAction(eeeee-> {
                                                        sceneManager.showMenuScreen();
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        } else if(sceneManager.getRhythmGamesPlayed() == 2) {
            if
        }
    }
}