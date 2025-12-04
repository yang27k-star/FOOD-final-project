import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.Key;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class RhythmGame extends Application {
    private static int numberOfNotes = 100;
    private static int numberOfHoldNotes = 5;
    private static ArrayList<Note> notes = new ArrayList<>();
    private static ArrayList<Note> holdNotes = new ArrayList<>();
    private int misses = 0;
    private static KeyFrame[] keyFrames = new KeyFrame[numberOfNotes + numberOfHoldNotes];

    private Scene scene;
    private SceneManager sceneManager;



    public static void main(String[] args) {
        launch(args);
    }

    private void updateScore(Label score, int x){
        int currentScore = Integer.parseInt(score.getText());
        score.setText(String.valueOf(currentScore + x));
    }

    private void showResponse(Label label, String text, Color color) {
        label.setText(text);
        label.setTextFill(color);
        FadeTransition ft = new FadeTransition(Duration.seconds(0.4), label);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
    }

    public void start(Stage primaryStage) {
        
        //Randomly generating notes and storing them in the notes arraylist
        
        for(int i = 0; i < numberOfNotes; i++){
            notes.add(new Note((50 + i * 100) % 400, 100 * (int)(numberOfNotes * (Math.random()  - 0.5)), false));
            
        }

        for(int i = 0; i < numberOfHoldNotes; i++){
            holdNotes.add(new Note(450, 100 * (int)(numberOfNotes * (Math.random()  - 0.5)), true));
            
        }
        
        for(int i = 0; i < numberOfNotes; i++){
            keyFrames[i] = notes.get(i).getKeyFrame();
        }

        for(int i = numberOfNotes; i < numberOfNotes + numberOfHoldNotes; i++){
            keyFrames[i] = holdNotes.get(i - numberOfNotes).getKeyFrame();
        }
        

        //Setting up stage
        Pane pane = new Pane();

        Label response = new Label("");
        response.setFont(new Font(24));
        response.setLayoutX(180);
        response.setLayoutY(20);
        pane.getChildren().add(response);
        
        Label score = new Label(String.valueOf(0));
        score.setFont(new Font(24));
        score.setLayoutX(400);
        score.setLayoutY(50);
        score.setTextFill(Color.PURPLE);
        pane.getChildren().add(score);

       
        //List of rectangles representing the lanes/keys
        for(int i = 0; i < 5; i++){
            Rectangle r = new Rectangle(35 + i * 100, 400, 50, 10);

            r.setStroke(Color.TRANSPARENT);
            r.setFill(Color.GREENYELLOW);

            pane.getChildren().addAll(r);
        }
        
        for(Note note: notes){
            pane.getChildren().add(note.getRectangle());
        }
        for(Note note: holdNotes){
            pane.getChildren().add(note.getRectangle());
        }

        Scene scene = new Scene(pane, 550, 550);
        primaryStage.setScene(scene);
        primaryStage.show();

        
        scene.setOnKeyPressed(event -> {
            boolean tapHit = false;
            boolean holdHit = false;
            for (Note note : notes) {
                int lane = note.getLane(event.getCode());
                tapHit |= note.handleTap(lane);      
            }

            for (Note hold : holdNotes) {
                holdHit |=hold.handlePress(event.getCode());
            }
            

            if (tapHit) {
                showResponse(response, "Hit!", Color.LIMEGREEN);
                updateScore(score, 30);
            } else {
                if(!event.getCode().toString().equals("G")){
                showResponse(response, "Miss!", Color.RED);
                updateScore(score, -10);
                misses++;
                }
            }
     });

    scene.setOnKeyReleased(event -> {
    for (Note hold : holdNotes) {
        if (hold.handleRelease(event.getCode()) == true) {
            showResponse(response, "Hold success!", Color.GOLD);
            updateScore(score, 50);  // bonus points for hold
        }
    }
});

        
        

        Timeline timeline = new Timeline(keyFrames);
        System.out.println("playing timeline");
        timeline.play();
    }
}