package calcultimate.calcultimate;

import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorGUI.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 630, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // Attachez un gestionnaire d'événements aux touches du clavier
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    String keyText = event.getText();
                    System.out.println(keyText);
                    if (keyText.matches("[0-9]")) {
                        System.out.println("works");
                        // Si la touche est un nombre (0-9), recherchez le bouton correspondant et cliquez dessus
                        Button button = (Button) root.lookup("#" + keyText);
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton

                        }
                    }
//            else if backspace is pressed
                    else if (keyText.matches("[\\u0008]")) {
                        Button button = (Button) root.lookup("#backspace");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    }
//            else if enter is pressed
                    else if (keyText.matches("[\\u0013]")) {
                        Button button = (Button) root.lookup("#enterButton");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    }
//            else if + - / or * is pressed, press #plus, #minus, #divide or #multiply
                    else if (keyText.matches("[\\u002B]")) {
                        Button button = (Button) root.lookup("#plus");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    } else if (keyText.matches("[\\u002D]")) {
                        Button button = (Button) root.lookup("#minus");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    } else if (keyText.matches("[\\u002A]")) {
                        Button button = (Button) root.lookup("#multiply");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    } else if (keyText.matches("[\\u002F]")) {
                        Button button = (Button) root.lookup("#divide");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    }
//            else if . is pressed
                    else if (keyText.matches("[\\u002E]")) {
                        Button button = (Button) root.lookup("#dot");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    }
//            else if c is pressed
                    else if (keyText.matches("[c]")) {
                        Button button = (Button) root.lookup("#C");
                        if (button != null) {
                            button.fire(); // Simule un clic sur le bouton
                        }

                    }
                });
        stage.setTitle("Calcultimate");
        stage.setScene(scene);
        stage.show();
                }

    // Add a function named 'affiche' to show the GUI interface
    public void affiche() {
        launch();
    }
}