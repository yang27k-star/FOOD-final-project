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
    private int holdNoteHeight = 200;
    private double holdEndY = 375;
    private boolean wasHolding;
    
    public Note(int xPos, int yPos, boolean isHold) {
        this.xPos = xPos;
        this.yPos = yPos;   
        this.isHoldNote = isHold;
        if(isHold){
            this.r = new Rectangle(20, holdNoteHeight, Color.BLACK);
        } else {
            this.r = new Rectangle(20, 50, Color.color(Math.random(), Math.random(), Math.random()));
        }
        
        r.setX(xPos);
        r.setY(yPos);
        KeyValue keyValue = new KeyValue(r.translateYProperty(), duration * 200);
        KeyValue holdKeyValue = new KeyValue(r.translateYProperty(), duration * 200 + 250);
        keyFrame = new KeyFrame(Duration.seconds(duration), keyValue);
    }

    public Rectangle getRectangle() {
        return r;
    }

    public boolean isHoldNote() {
        return isHoldNote;
    }

    public boolean wasHolding() {
        return wasHolding;
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
        isHolding = false;
        wasHolding = false;
        double yPosition = r.getY() + r.getTranslateY() + holdNoteHeight;
        //Start of hold note press
        if (Math.abs(r.getX() - getLane(code)) < 50 &&
            Math.abs(yPosition - 375) < 60)
        {
            System.out.println("Started holding note");
            isHolding = true;
            wasHolding = true;
            return true; //start holding
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
            case G:
                return 450; //Hold notes
            default:
                return -1;
        }
    }
    public boolean handleRelease(javafx.scene.input.KeyCode code) {
        if (!isHoldNote) return false;
        if (!wasHolding) return false; 

        isHolding = false;

        double yPosition = r.getY() + r.getTranslateY();

        // Only judge when the note actually reached the end
        if (yPosition >= holdEndY) {
          r.setVisible(false);
          return true;   // successful hold
        }

        return false;
        }
    
}
