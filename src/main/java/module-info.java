module calcultimate {
    requires javafx.controls;
    requires javafx.fxml;


    exports calcultimate.model;
    opens calcultimate.model to javafx.fxml;
    exports calcultimate.controller;
    opens calcultimate.controller to javafx.fxml;
    exports calcultimate.view;
    opens calcultimate.view to javafx.fxml;
    exports calcultimate;
    opens calcultimate to javafx.fxml;
}