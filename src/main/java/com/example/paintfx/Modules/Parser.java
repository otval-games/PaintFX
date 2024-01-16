package com.example.paintfx.Modules;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Parser {

    private static final String TAG_FILENAME = "drawing.json";

    public static void save(ArrayList<Rectangle> rectList){
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(TAG_FILENAME)){
            gson.toJson(rectList, writer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void upload(Module module) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(TAG_FILENAME)){

            Type rectType = new TypeToken<ArrayList<Rectangle>>(){}.getType();
            ArrayList<Rectangle> rectList = gson.fromJson(reader, rectType);

            System.out.println("JSON rects list: "+rectList);

            module.uploadDrawing(rectList);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}