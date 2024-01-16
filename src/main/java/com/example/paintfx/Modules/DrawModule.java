package com.example.paintfx.Modules;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class DrawModule {

    private Color color;

    private ArrayList<Rect> rectList = new ArrayList<>();

    public void drawRect(GraphicsContext g, double x, double y) {
        g.setFill(color);
        g.fillRect(x, y, 5, 5);

        Rect newRect = new Rect(x, y);
        rectList.add(newRect);
    }

    public void save(){
        GSONModule.save(rectList);
    }

    public void upload() {
        GSONModule.upload();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}