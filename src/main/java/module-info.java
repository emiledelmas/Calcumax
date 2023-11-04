/**
 * The calcultimate module is the main module for the Calcultimate calculator application.
 * It specifies the required dependencies and exports the necessary packages for the application to function.
 *  JavaFX is required for the application to run.
 */
module calcultimate {
    requires javafx.controls;

    exports calcultimate.model;
    exports calcultimate.controller;
    exports calcultimate.view;
    exports calcultimate;
}
