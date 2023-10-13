module com.opensup.testfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.opensup.testfx to javafx.fxml;
    exports com.opensup.testfx;
}