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
    private static int holdduration = 1;
    private long holdStartNano;
    
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

    public boolean handleTap (int keyIndex) {
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

    public boolean handlePress(javafx.scene.input.KeyCode code) {

        if (!isHoldNote) {
            return handleTap(getLane(code));
        }

        //Start of hold note press
        if (Math.abs(r.getX() - getLane(code)) < 50 &&
            Math.abs(r.getY() + r.getTranslateY() - 375) < 600)
        {
            isHolding = true;
            holdStartNano = System.nanoTime();
            return true;
        }

        return false;
    }

    public int getLane (javafx.scene.input.KeyCode code) {
        switch(code) {
            case A:
                return 50;
            case S:
                return 150;
            case D:
                return 250;
            case F:
                return 350;
            default:
                return -1;
        }
    }
    public boolean handleRelease(javafx.scene.input.KeyCode code) {
        if (!isHoldNote) return false;

        if (!isHolding) return false; // released but wasn't holding

        isHolding = false;

        double heldSeconds = (System.nanoTime() - holdStartNano) / 1_000_000_000.0;

        if (heldSeconds >= holdduration) {
            r.setVisible(false);
            return true; // successful hold
        } else {
            r.setFill(Color.GRAY); // failed hold indicator
            return false;
        }
    }
    
}
