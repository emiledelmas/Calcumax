package calcultimate.view;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardEventHandler {

    private final Parent root;

    public KeyboardEventHandler(Parent root) {
        this.root = root;
    }

    public void handleKeyEvent(KeyEvent event) {
        String keyText = event.getText();
        KeyCode code = event.getCode();
        if (keyText.matches("[0-9]")) {
            Button button = (Button) root.lookup("#" + keyText);
            if (button != null) {
                button.fire();
            }
        } else if (code == KeyCode.BACK_SPACE) {
            Button button = (Button) root.lookup("#backspace");
            if (button != null) {
                button.fire();
            }
        } else if (code == KeyCode.ENTER) {
            event.consume();
            Button button = (Button) root.lookup("#enterBtn");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("[+]")) {
            Button button = (Button) root.lookup("#plus");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("[-]")) {
            Button button = (Button) root.lookup("#minus");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("[*]")) {
            Button button = (Button) root.lookup("#multiply");
            if (button != null) {
                button.fire();
            }
        } else if (keyText.matches("[/]")) {
            Button button = (Button) root.lookup("#divide");
            if (button != null) {
                button.fire();
            }
        } else if (code == KeyCode.DECIMAL) {
            Button button = (Button) root.lookup("#dot");
            if (button != null) {
                button.fire();
            }

        } else if (keyText.matches("c")) {
            Button button = (Button) root.lookup("#C");
            if (button != null) {
                button.fire();
            }
        }
//        if % is hit, the opposite button is fired
        else if (keyText.matches("[%]")) {
            Button button = (Button) root.lookup("#opposite");
            if (button != null) {
                button.fire();
            }
        }
    }
}
