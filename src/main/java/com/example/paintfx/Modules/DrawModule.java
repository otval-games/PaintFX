package com.example.paintfx.Modules;

import com.example.paintfx.JSON.JSONWorker;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DrawModule {

    private Color color;

    private ArrayList<Rect> rectList = new ArrayList<>();

    public void drawRect(GraphicsContext g, double x, double y) {
        g.setFill(color);
        g.fillRect(x, y, 5, 5);

        Rect newRect = new Rect(color, x, y);
        rectList.add(newRect);

        JSONWorker.toJSON(newRect);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}