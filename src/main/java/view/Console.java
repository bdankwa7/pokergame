package view;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;



/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class Console extends ScrollPane {

    private static Console instance;
    private Label label1;

    /**
     * Console's constructor. Set's the static instance variable.
     */
    public Console() {
        instance = this;


        label1 = new Label();
        label1.setWrapText(true);
        instance.setContent(label1);
        instance.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    }

    /**
     * Add's text to the top of the console. (Doesn't get rid of
     * text that is already there!)
     * @param newText is the text to add to the top of the console
     */
    public void addText(String newText) {

        instance.setVvalue(0);
        label1.setText(newText + "\n" + label1.getText());
        instance.setContent(label1);

    }

    /**
     * Clears the console of any text
     */
    public void clear() {
        label1.setText("");

    }

    /**
     * Static method that adds a message into the current
     * {@value  instance}
     * @param message The message to add
     */
    public static void putMessage(String message) {
        instance.addText(message);
    }

    /**
     * Clears the console of the current {@value instance}
     */
    public static void clearLog() {
        instance.clear();
    }

    private Label getLabel1() {
        return label1;
    }
}