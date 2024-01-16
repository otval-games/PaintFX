package com.example.paintfx.Controllers;

import com.example.paintfx.Modules.DrawModule;
import javafx.event.ActionEvent;
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

    private final DrawModule drawModule = new DrawModule();

//Functions
    public void onPickerHandled() {
        drawModule.setColor(colorPicker.getValue());
    }

    public void onMouseDragged(MouseEvent mouseEvent) {
        drawModule.drawRect(g, mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
    }

    public void onSaved() {
        drawModule.save();
    }

    public void onUploaded() {
        drawModule.upload();
    }

    public void onMouseDragEnded(MouseEvent mouseEvent) {
    }
}