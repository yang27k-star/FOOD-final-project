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
    
    private boolean isHoldNote;
    private boolean isHolding; 
    private double holdEndY;
    
    public Note(int xPos, int yPos, boolean isHold) {
        this.xPos = xPos;
        this.yPos = yPos;   
        if(isHold){
            this.r = new Rectangle(20, 100, Color.BLACK);
        } else {
            this.r = new Rectangle(20, 50, Color.color(Math.random(), Math.random(), Math.random()));
        }
        
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

    public boolean testPress (int keyIndex) {
        if(!isHoldNote){
            if(Math.abs(r.getX() - keyIndex) < 50 && Math.abs(r.getY() + r.getTranslateY() - 375) < 50){
            this.r.setVisible(false);
            return true;
        }
        return false;
        }
        

        if (Math.abs(r.getX() - keyIndex) < 50 &&
        Math.abs(r.getY() + r.getTranslateY() - 375) < 50) {

        isHolding = true; // key is now down
        return true;
    }

    return false;
    }
    
}
