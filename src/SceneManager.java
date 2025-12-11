//import view;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import java.util.Timer;
// import java.util.TimerTask;

public class SceneManager {

    private Scene scene;
    int rhythmGamesPlayed = 0;
    String name = "um, this is not supposed to be here";
    Double money;
    int sheriffFavorability = 0;
    int cafeOwnerFavorability = 0;
    int seoFavorability = 0;
    int cipherFavorability = 0;
    int boothillFavorability = 0;
    int bladeFavorability = 0;

    public int getSheriffFavorability() {
        return sheriffFavorability;
    }

    public void addSheriffFavorability(int i) {
        sheriffFavorability = sheriffFavorability + i;
    }

    public int getCafeOwnerFavorability() {
        return cafeOwnerFavorability;
    }

    public void addCafeOwnerFavorabiltiy(int i) {
        cafeOwnerFavorability = cafeOwnerFavorability + i;
    }

    public int getSeoFavorability() {
        return seoFavorability;
    }

    public void addSeoFavorability(int i) {
        seoFavorability = seoFavorability + i;
    }

    public int getCipherFavorability() {
        return cipherFavorability;
    }

    public void addCipherFavorability(int i) {
        cipherFavorability = cipherFavorability + i;
    }

    public int getBoothillFavorability() {
        return boothillFavorability;
    }

    public void addBoothillFavorability(int i) {
        boothillFavorability = boothillFavorability + i;
    }

    public int getBladeFavorability() {
        return bladeFavorability;
    }

    public void addBladeFavorability(int i) {
        bladeFavorability = bladeFavorability + i;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void addMoney(Double extraMoney) {
        money = money + extraMoney;
    }

    public void setName(String newName) {
        name = newName;
    }

    // Called once after the Scene is created
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    // create new screens

    public Parent createMenuScreen() {
        return new MenuScreen(this);
    }

    public Parent createRhythmGameScreen() {
        return new RhythmGame(this);
    }

    public void showRhythmGame() {
        rhythmGamesPlayed++;
        scene.setRoot(createRhythmGameScreen());
    }

    public void restartLevel(){
        rhythmGamesPlayed--;
    }

    public int getRhythmGamesPlayed() {
        return rhythmGamesPlayed;
    }

    public Parent createDialogueScreen() {
        return new DialogueScreen(this);
    }

    public void showDialogueScreen() {
        scene.setRoot(createDialogueScreen());
    }

    public Parent createEndScreen() {
        return new EndScreen(this);
    }

    public void showEndScreen() {
        scene.setRoot(createEndScreen());
    }

    public Parent createYouDeerScreen() {
        return new YouDeerScreen(this);
    }

    public void showYouDeerScreen() {
        scene.setRoot(createYouDeerScreen());
    }

    public Parent createFailScreen() {
        return new FailScreen(this);
    }

    public void showFailScreen() {
        scene.setRoot(createFailScreen());
    }

    // navigation methods

    public void showMenuScreen() {
        rhythmGamesPlayed = 0;
        money = 0.0;
        sheriffFavorability = 0;
        cafeOwnerFavorability = 0;
        seoFavorability = 0;
        cipherFavorability = 0;
        boothillFavorability = 0;
        bladeFavorability = 0;
        name = "um, this is not supposed to be here";
        scene.setRoot(createMenuScreen());
    }
}