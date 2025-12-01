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


public class Note {
    private int xPos;
    private int yPos;
    private Rectangle r;
    private KeyFrame keyFrame;
    private static int duration = 20;

    public Note(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;   
        this.r = new Rectangle(20, 50, Color.color(Math.random(), Math.random(), Math.random()));
        r.setX(xPos);
        r.setY(yPos);
        KeyValue keyValue = new KeyValue(r.translateYProperty(), duration * 400);
        keyFrame = new KeyFrame(Duration.seconds(duration), keyValue);
    }

    public Rectangle getRectangle() {
        return r;
    }

    public KeyFrame getKeyFrame() {
        return keyFrame;
    }

    public void testPress (int keyIndex) {
        
        if(Math.abs(r.getX() - keyIndex) < 50 && Math.abs(r.getY() + r.getTranslateY() - 375) < 50){
            this.r.setVisible(false);
        }
    }
    
}
