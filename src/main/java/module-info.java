module calcultimate.calcultimate {
    requires javafx.controls;
    requires javafx.fxml;


    opens calcultimate.calcultimate to javafx.fxml;
    exports calcultimate.calcultimate;
}