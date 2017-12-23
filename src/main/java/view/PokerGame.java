package view;

import javafx.application.Application;
import javafx.stage.Stage;
import viewcontroller.PokerGameController;



import javafx.scene.layout.VBox;
import javafx.scene.Scene;

import viewcontroller.GameState;


/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class PokerGame extends Application {

    private static Stage primaryStage;
    private PokerGameController control;
    private GameScreen gamescreen;
    private ControlPane conpane;
    private Console console;
    private VBox box;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     * @param ps The primary Stage
     */
    public void start(Stage ps) {
        primaryStage = ps;
        StartScreen start = new StartScreen(this);
        Scene scene = new Scene(start.getPane(), 800, 600);
        primaryStage.setTitle("Extreme Poker");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    /**
     * Starts the Game
     * This is called by StartScreen whenever it is done and the GameScreen,
     * ControlPane, and Console should be displayed
     * @param name The name of the human player
     * @param amount The amount of chips the player wants to start with
     */
    public void startGame(String name, int amount) {


        control = new PokerGameController(this, name, amount);
        gamescreen = new GameScreen(control);
        conpane = new ControlPane(control);
        console = new Console();
        box = new VBox();
        box.getChildren().addAll(gamescreen, conpane, console);
        //Scene scene2 = new Scene(box);
        primaryStage.getScene().setRoot(box);
        primaryStage.show();
        control.start();


    }

    /**
     * This is called by PokerGameController whenever updates are made. You
     * must handle updating the UI here.
     */
    public void updatesMade() {

        if (control.getState() == GameState.DONE) {
            gamescreen.endOfRound();
            conpane.endOfRound();
            console.clear();
        }

        if (control.getState() == GameState.AI_BET)  {
            conpane.getRaise().setDisable(true);
            conpane.getCall().setDisable(true);
            conpane.getFold().setDisable(true);
            //conpane.getNewRound().setVisible(false);
            gamescreen.updatesMade();

        }

        if (control.getState() == GameState.HUMAN_BET) {
            gamescreen.updatesMade();
            conpane.playerTurn();
        }
    }

    /**
     * This is the main method that launches the javafx application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Returns the VBox that we used to display the GameScreen, controlpane,
     * and console
     * @return a VBox
     */
    public VBox getVBox() {
        return box;
    }

    /**
     * Returns the PokerGameController
     * @return a PokerGameController
     */
    public PokerGameController getPokerGameController() {
        return control;
    }

    /**
     * Returns the GameScreen
     * @return a GameScreen
     */
    public GameScreen getGameScreen() {
        return gamescreen;
    }

    /**
     * Returns the ControlPane
     * @return a ControlPane
     */
    public ControlPane getControlPane() {
        return conpane;
    }


    /**
     * Returns the Console
     * @return a Console
     */
    public Console getConsole() {
        return console;
    }


    /**
     * Returns the stage
     * @return the main stage displaying everything
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}