package com.example.paintfx.Controllers;

import com.example.paintfx.Modules.Module;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

//Variables
    @FXML
    public ColorPicker colorPicker;

    @FXML
    public Canvas canvas;

    @FXML
    public Button BtnSave;

    @FXML
    public Button BtnUpload;


    private GraphicsContext g;

    private final Module module = new Module(this);

//Functions
    public void onPickerHandled() {
        module.setColor(colorPicker.getValue());
    }

    public void onMouseDragged(MouseEvent mouseEvent) {
        module.drawRect(g, mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
    }

    public void onSaved() {
        module.onSaveClicked();
    }

    public void onUploaded() {
        module.onUploadClicked();
    }
}