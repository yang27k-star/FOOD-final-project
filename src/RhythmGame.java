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
import javafx.scene.input.KeyCode;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
//import javafx.scene.layout.VBox;
import java.security.Key;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;



public class RhythmGame extends Pane {
    
    private static int numberOfNotes = 100;
    private static int numberOfHoldNotes = 5;
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Note> holdNotes = new ArrayList<>();
    private Set<KeyCode> keysHeld = new HashSet<>();
    private int misses = 0;
    private static KeyFrame[] keyFrames = new KeyFrame[numberOfNotes + numberOfHoldNotes];
    private static Label score = new Label(String.valueOf(0));


    private void updateScore(Label score, int x){
        int currentScore = Integer.parseInt(score.getText());
        score.setText(String.valueOf(currentScore + x));
    }

    public static int getScore(){
        return Integer.parseInt(score.getText());
    }
    private void showResponse(Label label, String text, Color color) {
        label.setText(text);
        label.setTextFill(color);
        FadeTransition ft = new FadeTransition(Duration.seconds(0.4), label);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
    }

    public RhythmGame(SceneManager sceneManager) {
        setBackground(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundFill(Color.LIGHTYELLOW, null, null)));
        
        class taskSetter extends TimerTask {
        public void run() {
            if(RhythmGame.getScore() < sceneManager.getRhythmGamesPlayed() * 200 + 600) {
                sceneManager.showYouDeerScreen();
            } else {
                sceneManager.showDialogueScreen();
            }
        }
    }
        
        System.out.println("Starting");
        //Setting up stage
        
        // Pane pane = new Pane();

        Label response = new Label("");
        response.setFont(new Font(24));
        response.setLayoutX(180);
        response.setLayoutY(20);
        getChildren().add(response);

        Label scoreAdd = new Label("");
        scoreAdd.setFont(new Font(24));
        scoreAdd.setLayoutX(180);
        scoreAdd.setLayoutY(70);
        getChildren().add(scoreAdd);
        
        
        score.setFont(new Font(24));
        score.setLayoutX(400);
        score.setLayoutY(50);
        score.setTextFill(Color.PURPLE);
        getChildren().add(score);

        

        
        //Randomly generating notes and storing them in the notes arraylist

        for(int i = 0; i < numberOfNotes; i++){
            notes.add(new Note((50 + i * 100) % 400, -200 - 100 * (int)(numberOfNotes * Math.random()), false));
            
        }

        for(int i = 0; i < numberOfHoldNotes; i++){
            int offset = (int)(200 * Math.random());
            holdNotes.add(new Note(450, -600 - i * 6000 / numberOfHoldNotes- offset, true)); //Hold notes are spaced out
        }

        System.out.println(holdNotes.size());
        for(int i = 0; i < numberOfNotes; i++){
            keyFrames[i] = notes.get(i).getKeyFrame();
        }

        for(int i = numberOfNotes; i < numberOfNotes + numberOfHoldNotes; i++){
            keyFrames[i] = holdNotes.get(i - numberOfNotes).getKeyFrame();
        }

       
        //List of rectangles representing the lanes/keys
        for(int i = 0; i < 5; i++){
            Rectangle r = new Rectangle(35 + i * 100, 375, 50, 2 * Note.getThreshold());

            r.setStroke(Color.TRANSPARENT);
            r.setFill(Color.GREENYELLOW);

            getChildren().addAll(r);
        }
        
        


        for(Note note: notes){
            getChildren().add(note.getRectangle());
        }
        for(Note note: holdNotes){
            System.out.println("Hold note height: " + note.getHeight());
            getChildren().add(note.getRectangle());
        }
        
        
        setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            boolean tapHit = false;
            for (Note note : notes) {
                int lane = note.getLane(event.getCode());
                tapHit |= note.handleTap(lane);      
            }
            if (!keysHeld.contains(event.getCode())) {
            keysHeld.add(event.getCode());  // mark the key as held
            for (Note hold : holdNotes) {
                boolean holdHit = false;
                holdHit |= hold.handlePress(event.getCode());
            }
        }

            if (tapHit) {
                showResponse(response, "Hit!", Color.LIMEGREEN);
                showResponse(scoreAdd, "+30", Color.LIMEGREEN);
                updateScore(score, 30);
            } else {
                if(!event.getCode().toString().equals("H")){ //space is for hold notes only
                showResponse(response, "Miss!", Color.RED);
                showResponse(scoreAdd, "-10", Color.RED);
                updateScore(score, -10);
                misses++;
                }
            }
        });

        setOnKeyReleased(event -> {
        keysHeld.remove(event.getCode());

        //only handles releases for hold notes 
        if(event.getCode().toString().equals("H")){
        int holdNoteHeight = 0;
        boolean atLeastOne = false;
        for(Note holdNote : holdNotes){
            atLeastOne |= holdNote.handleRelease();
            if(holdNote.isHolding()){
                holdNoteHeight = holdNote.getHeight(); //Get the height of the note currently held
            }
        }

        if (atLeastOne == true) {
            showResponse(response, "Hold success!", Color.GOLD);
            showResponse(scoreAdd, "+" + holdNoteHeight , Color.GOLD);
            updateScore(score, holdNoteHeight);  // bonus points for hold
        } else {
            showResponse(response, "Hold miss!", Color.RED);
            showResponse(scoreAdd, "-30", Color.RED);
            updateScore(score, -30);
            misses++;
        }
    
        }
        
        });

        Timeline timeline = new Timeline(keyFrames);
        timeline.play();
        setFocusTraversable(true);
        // requestFocus();
        Platform.runLater(() -> requestFocus() );
        Timer timer = new Timer();
        TimerTask task = new taskSetter();
        
        timer.schedule(task, 20000);

    }
}