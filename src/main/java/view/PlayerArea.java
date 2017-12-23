package view;

import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Player;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public abstract class PlayerArea {

    private Pane pane;
    private Label name;
    private Label chips;
    private Label outofplay;

    private Player player;
    private CardView cardView1;
    private CardView cardView2;
    //private Player player;

    /**
     * PlayerArea's constructor
     * @param  pane   The Pane where all UI elements will be added. The type of
     * pane is decided by subclasses
     * @param  player The Player who's information will be tracked
     */
    public PlayerArea(Pane pane, Player player) {
        this.pane = pane;
        this.player = player;
        cardView1 = new CardView();
        cardView2 = new CardView();
        name = new Label(player.toString());
        chips = new Label(Integer.toString(player.getMoney()));
        outofplay = new Label("Out of Play");
        outofplay.setVisible(false);
        VBox box1 = new VBox();
        box1.getChildren().addAll(name, chips, outofplay);
        pane.getChildren().addAll(cardView1, cardView2, box1);




    }

    /**
     * Getter for the Pane that contains all of the UI elements.
     * @return The Pane that contains all of the UI elements.
     */
    public Pane playerPane() {
        return pane;
    }

    /**
     * This method is called whenever an update to the UI needs to be made.
     * @param showDetails is true whenever the details of the front of the
     * cards are supposed to be shown false otherwise
     */
    public void update(boolean showDetails) {
        chips.setText("Chips: " + player.getMoney());

        if (player.getCard(0) != null) {
            cardView1.setCard(player.getCard(0));
        }
        if (player.getCard(1) != null) {
            cardView2.setCard(player.getCard(1));
        }

        if (!showDetails && !player.getOutOfPlay()) {
            cardView1.hideDetails();
            cardView2.hideDetails();
            outofplay.setVisible(false);
        } else if (player.getOutOfPlay()) {
            cardView1.hide();
            cardView2.hide();
            outofplay.setVisible(true);
        } else {
            cardView1.show();
            cardView2.show();
            outofplay.setVisible(false);
        }




    }

}