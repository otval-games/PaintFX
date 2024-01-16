module com.example.paintfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.google.gson;

    opens com.example.paintfx to javafx.fxml;
    exports com.example.paintfx;
    exports com.example.paintfx.Controllers;
    opens com.example.paintfx.Controllers to javafx.fxml;
}