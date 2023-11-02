package calcultimate.view;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The KeyboardEventHandler class is responsible for handling keyboard input and mapping it to button actions in the calculator GUI.
 */
public class KeyboardEventHandler {

    private final Parent root;

    /**
     * Constructs a new KeyboardEventHandler with the specified root node of the GUI.
     *
     * @param root The root node of the calculator GUI.
     */
    public KeyboardEventHandler(Parent root) {
        this.root = root;
    }

    /**
     * Handles keyboard events and triggers button actions in response to specific key presses.
     *
     * @param event The KeyEvent to be processed.
     */
    public void handleKeyEvent(KeyEvent event) {
        String keyText = event.getText();
        KeyCode code = event.getCode();

        if (keyText.matches("[0-9]")) {
            // Handle numeric key presses (0-9)
            Button button = (Button) root.lookup("#" + keyText);
            if (button != null) {
                button.fire();
            }
        } else if (code == KeyCode.BACK_SPACE) {
            // Handle the BACK_SPACE key
            Button button = (Button) root.lookup("#backspace");
            if (button != null) {
                button.fire();
            }
        } else if (code == KeyCode.ENTER) {
            // Handle the ENTER key
            event.consume();
            Button button = (Button) root.lookup("#enterBtn");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("[+]")) {
            // Handle the addition key
            Button button = (Button) root.lookup("#plus");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("-")) {
            // Handle the subtraction key
            Button button = (Button) root.lookup("#minus");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("[*]")) {
            // Handle the multiplication key
            Button button = (Button) root.lookup("#multiply");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("/")) {
            // Handle the division key
            Button button = (Button) root.lookup("#divide");
            if (button != null) {
                button.fire();
            }
        } else if (code == KeyCode.DECIMAL) {
            // Handle the decimal point key
            Button button = (Button) root.lookup("#dot");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("c")) {
            // Handle the 'C' (clear) key
            Button button = (Button) root.lookup("#C");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("%")) {
            // Handle the percentage (opposite sign) key
            Button button = (Button) root.lookup("#opposite");
            if (button != null) {
                button.fire();
            }
        }
    }
}
