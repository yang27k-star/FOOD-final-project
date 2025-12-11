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
    private static int gameDuration = 20;
    private static int threshhold = 20;
    
    private boolean isHoldNote;
    private boolean isHolding = false;
    private boolean wasHolding = false;
    private int holdNoteHeight;
    private double pressedYPosition = 0;
    
    
    public Note(int xPos, int yPos, boolean isHold) {
        this.xPos = xPos;
        this.yPos = yPos;   
        this.isHoldNote = isHold;
        if(isHold){
            this.holdNoteHeight = (int)(Math.random() * 200 + 100);
            this.r = new Rectangle(20, holdNoteHeight, Color.BLACK);
        } else {
            this.r = new Rectangle(20, 50, Color.color(Math.random(), Math.random(), Math.random()));
        }
        
        r.setX(xPos);
        r.setY(yPos);
        KeyValue keyValue = new KeyValue(r.translateYProperty(), gameDuration * 300);
        KeyValue holdKeyValue = new KeyValue(r.translateYProperty(), gameDuration * 300);
        keyFrame = new KeyFrame(Duration.seconds(gameDuration), keyValue);
    }

    public Rectangle getRectangle() {
        return r;
    }

    public static int getThreshold() {
        return threshhold;
    }

    public boolean isHoldNote() {
        return isHoldNote;
    }

    public boolean wasHolding() {
        return wasHolding;
    }

    public boolean isHolding() {
        return isHolding;
    }
    public KeyFrame getKeyFrame() {
        return keyFrame;
    }

    public int getHeight() {
        return holdNoteHeight;
    }

    public boolean handleTap (int keyIndex) {
        if(!isHoldNote){
            if(Math.abs(r.getX() - keyIndex) < 50 && Math.abs(r.getY() + r.getTranslateY() - 375) < 50){
            this.r.setVisible(false);
            return true;
        }
    }
    return false;
    }

    public boolean handlePress(javafx.scene.input.KeyCode code) {
        if(code == javafx.scene.input.KeyCode.H){
            wasHolding = false;
            pressedYPosition = r.getY() + r.getTranslateY() + holdNoteHeight;
        }
        
        //Start of hold note press
        if (Math.abs(r.getX() - getLane(code)) < 50 &&
            Math.abs(pressedYPosition - 375) < 60)
        {
            System.out.println("Note held");
            r.setFill(Color.DARKGRAY);
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
            case H:
                return 450; //Hold notes
            default:
                return -1;
        }
    }
    public boolean handleRelease() {

       if(wasHolding)
           wasHolding = false;
        double moved = r.getY() + r.getTranslateY() + holdNoteHeight - pressedYPosition;
        System.out.println(moved);

        if (Math.abs(moved - holdNoteHeight) < threshhold && isHolding) {
        System.out.println("Disappear");
        r.setVisible(false);
        
        // Reset to prevent multiple Hold sucesses
        wasHolding = false;

        return true;
        }
        
    return false;
    }
    
}
