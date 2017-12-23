package view;

import javafx.scene.layout.HBox;
import viewcontroller.PokerGameController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class ControlPane extends HBox {

    private PokerGameController cont;
    private Button raise;
    private Button call;
    private Button fold;
    private Button newTurn;
    private HBox hBox;
    private TextField textfield;




    /**
     * Constructor for ControlPane
     * @param  cont The PokerGameController to interact with
     */
    public ControlPane(PokerGameController cont) {
        String sound1 = "src/main/res/fire_bow_sound-mike-koenig.mp3";
        Media soundagain = new Media(new File(sound1).toURI().toString());

        this.cont = cont;
        textfield = new TextField();
        raise = new Button("Raise");
        call = new Button("Call");
        newTurn = new Button("Start New Round");
        fold = new Button("Fold");
        newTurn.setVisible(false);


        this.getChildren().addAll(textfield, raise, call, fold, newTurn);
        hBox = new HBox();
        ((HBox) this).setAlignment(Pos.CENTER);

        raise.setOnAction(event ->  {
                cont.humanBet(Integer.parseInt(textfield.getText()));
                MediaPlayer theMediaPlayer = new MediaPlayer(soundagain);
                MediaPlayer.Status status = theMediaPlayer.getStatus();
                if (status != MediaPlayer.Status.PLAYING) {
                    theMediaPlayer.play();
                }
            });
        raise.setDisable(true);

        call.setOnAction(event -> {
                cont.humanCall();
                MediaPlayer theMediaPlayer = new MediaPlayer(soundagain);
                MediaPlayer.Status status = theMediaPlayer.getStatus();
                if (status != MediaPlayer.Status.PLAYING) {
                    theMediaPlayer.play();
                }
            });
        call.setDisable(true);

        fold.setOnAction(event -> {
                cont.humanFold();
                MediaPlayer theMediaPlayer = new MediaPlayer(soundagain);
                MediaPlayer.Status status = theMediaPlayer.getStatus();
                if (status != MediaPlayer.Status.PLAYING) {
                    theMediaPlayer.play();
                }
            });
        call.setDisable(true);

        newTurn.setOnAction(event -> {
                cont.startNewPokerHand();
                MediaPlayer theMediaPlayer = new MediaPlayer(soundagain);
                MediaPlayer.Status status = theMediaPlayer.getStatus();
                newTurn.setVisible(false);
                if (status != MediaPlayer.Status.PLAYING) {
                    theMediaPlayer.play();
                }
            });

        //newTurn.setDisable(true);
        //newTurn.setVisible(false);
        //textfield.setVisible(false);
        //getChildren().addAll(raise,call,fold,textfield);
        //setSpacing(10);
        //this.setAlignment(Pos.CENTER);


    }

    /**
     * Called whenever it becomes the player's turn again
     */
    public void playerTurn() {

        fold.setDisable(false);
        raise.setDisable(false);
        call.setDisable(false);
        //newTurn.setVisible(false);
    }

    /**
     * Method called when the round ends.
     */
    public void endOfRound() {


        newTurn.setVisible(true);

    }


    /**
     * Returns the poker game controller being used
     * @return the poker game controller
     */
    public PokerGameController getCont() {
        return cont;
    }

    /**
     * Returns the button that we called raise
     * @return the raise button
     */
    public Button getRaise() {
        return raise;

    }

    /**
     * Returns the button that we called call
     * @return the call button
     */
    public Button getCall() {
        return call;
    }


    /**
     * Returns the button that we called fold
     * @return the fold button
     */
    public Button getFold() {
        return fold;
    }

    /**
     * Returns the button that we used to say Start New Round
     * @return the Start New Round button
     */
    public Button getNewRound() {
        return newTurn;
    }

    //public Button get

}