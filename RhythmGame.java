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
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class RhythmGame extends Application {
    private static int numberOfNotes = 100;
    private static ArrayList<Note> notes = new ArrayList<>();
    private static KeyFrame[] keyFrames = new KeyFrame[numberOfNotes];

    public static void main(String[] args) {
        launch(args);
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
            notes.add(new Note((50 + i * 100) % 400, 100 * (int)(numberOfNotes * (Math.random()  - 0.5))));
        }
        for(int i = 0; i < numberOfNotes; i++){
            keyFrames[i] = notes.get(i).getKeyFrame();
        }
        
        
        //Setting up stage
        Pane pane = new Pane();

        Label response = new Label("");
        response.setFont(new Font(24));
        response.setLayoutX(180);
        response.setLayoutY(20);
        pane.getChildren().add(response);
        
        //List of rectangles representing the lanes/keys
        for(int i = 0; i < 4; i++){
            Rectangle r = new Rectangle(35 + i * 100, 400, 50, 10);

            r.setStroke(Color.TRANSPARENT);
            r.setFill(Color.GREENYELLOW);

            pane.getChildren().addAll(r);
        }

        
        
        for(Note note: notes){
            pane.getChildren().add(note.getRectangle());
        }
        Scene scene = new Scene(pane, 450, 550);
        primaryStage.setScene(scene);
        primaryStage.show();

            scene.setOnKeyPressed(event -> {
            
                boolean hit = false;
            switch (event.getCode()) {
                case A:
                    for(Note note: notes){
                        hit |= note.testPress(50);
                    }
                    break;
                case S:
                    for(Note note: notes){
                        hit |= note.testPress(150);
                    }
                    break;
                case D:
                    for(Note note: notes){
                        hit |= note.testPress(250);
                    }
                    break;
                case F:
                    for(Note note: notes){
                        hit |= note.testPress(350);
                    }
                    break;
                default:
                    break;
            }
            
            
            if(hit) {
                showResponse(response, "Hit!", Color.LIMEGREEN);
            } else {
                showResponse(response, "Miss!", Color.RED);
            }
            
        });
        

        Timeline timeline = new Timeline(keyFrames);
        System.out.println("playing timeline");
        timeline.play();
    }
}
