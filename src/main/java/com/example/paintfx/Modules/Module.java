package com.example.paintfx.Modules;

import com.example.paintfx.Controllers.Controller;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Module {

    private Color color;

    private ArrayList<Rectangle> rectList = new ArrayList<>();

    private final Controller controller;

    public Module(Controller controller) {
        this.controller=controller;
    }

    public void drawRect(GraphicsContext g, double x, double y) {
        g.setFill(color);
        g.fillRect(x, y, 5, 5);

        addToList(x, y);
    }

    public void uploadRect(GraphicsContext g, double x, double y) {
        g.setFill(Color.BLACK);
        g.fillRect(x, y, 5, 5);
    }

    public void addToList(double x, double y){
        Rectangle newRect = new Rectangle(x, y);
        rectList.add(newRect);
    }

    public void onSaveClicked(){
        Parser.save(rectList);
    }

    public void onUploadClicked() {
        Parser.upload(this);
    }

    public void uploadDrawing(ArrayList<Rectangle> JSONrectList){
        this.rectList = JSONrectList;
        System.out.println("Module rects list:"+rectList);

        for (Rectangle rect:rectList){
            uploadRect(controller.canvas.getGraphicsContext2D(), rect.getX(), rect.getY());
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}