package com.example.paintfx.Modules;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GSONModule {

    private static final String TAG_FILENAME = "drawing.json";

    public static void save(ArrayList<Rect> rectList){
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(TAG_FILENAME)){
            gson.toJson(rectList, writer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void upload() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(TAG_FILENAME)){
            Type rectType = new TypeToken<ArrayList<Rect>>(){}.getType();
            ArrayList<Rect> rectList = gson.fromJson(reader, rectType);
            System.out.println("Rect list: "+rectList);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}