package com.example.paintfx.JSON;

import com.example.paintfx.Modules.Rect;
import com.google.gson.Gson;

public class JSONWorker {

    private static final String TAG_COLOR = "color";
    private static final String TAG_X = "x";
    private static final String TAG_Y = "y";

    public static void toJSON(Rect rect){
        Gson gson = new Gson();
        String json = gson.toJson(rect);
        System.out.println(json);
    }
}