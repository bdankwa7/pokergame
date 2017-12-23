package view;


import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.TextInputDialog;

import javafx.scene.Scene;
import java.util.Optional;
import javafx.scene.control.Button;





/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class StartScreen extends StackPane {
    private PokerGame cont;
    private Scene scene;
    private StackPane pane;

    // Path to the image file for the background
    private static final String BACK_LOCATION = "File:./src/main/res"
        + "/poker-game-background.png";

    /**
     * StartScreen's constructor
     * @param cont The PokerGame to interact with
     */
    public StartScreen(PokerGame cont) {

        this.cont = cont;
        //StackPane pane = new StackPane();
        Button butt = new Button("Start New Game");


        Image image = new Image(BACK_LOCATION, 855, 845, false, true);

        ImageView imageAgain = new ImageView(image);

        pane = new StackPane();
        pane.getChildren().add(imageAgain);
        pane.getChildren().add(butt);
        //pane = new StackPane();

        //pane.getChildren().add(image);
        //pane.getChildren().add(button);






        butt.setOnAction(thehandler -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("New Game");
                dialog.setHeaderText("Confirmation");
                dialog.setContentText("Enter you name");
                String username;
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    TextInputDialog dialog2 = new TextInputDialog();
                    username = result.get();
                    dialog2.setTitle("Chip Amount:  ");
                    dialog2.setContentText("Enter chip amount:  ");
                    Optional<String> result2 = dialog2.showAndWait();
                    if (result2.isPresent()) {

                        cont.startGame(username,
                            Integer.parseInt(result2.get()));

                    }
                //result.ifPresent(name -> cont.startGame(name));

                }

            });


    }

    /**
     * Returns the StackPane with the image and button
     * @return a StackPane
     */
    public StackPane getPane() {
        return pane;
    }

    /**
     * Returns the Poker Game object
     * @return a Poker Game
     */
    public PokerGame getCont() {
        return cont;
    }

}