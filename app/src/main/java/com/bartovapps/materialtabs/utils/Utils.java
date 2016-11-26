package com.bartovapps.materialtabs.utils;

import android.content.Context;
import android.util.Log;

import com.bartovapps.materialtabs.model.BasePage;
import com.bartovapps.materialtabs.model.ImagePage;
import com.bartovapps.materialtabs.model.TextPage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BartovMoti on 11/24/16.
 */
public class Utils {
    public static final String TAG = Utils.class.getSimpleName();

    public static final String JSON_TITLE = "title";
    public static final String JSON_SUBTITLE = "subtitle";
    public static final String JSON_CONTENT_TYPE = "content-type";
    public static final String JSON_CONTENT = "content";
    public static final String JSON_CONTENT_URL = "content-url";


    public static List<BasePage> loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        List<BasePage> pages = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.i(TAG, "File content: " + json);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String subtitle = null;
                String title = jsonObject.getString(JSON_TITLE);
                String contentType = jsonObject.getString(JSON_CONTENT_TYPE);

                if(jsonObject.has(JSON_SUBTITLE)){
                    subtitle = jsonObject.getString(JSON_SUBTITLE);
                }

                switch (contentType){
                    case "text":
                        String content = jsonObject.getString(JSON_CONTENT);
                        pages.add(new TextPage(title, subtitle, contentType, content));
                        Log.i(TAG, "loadJSONFromAsset: textPage was added..");
                        break;
                    case "image":
                        String contentUrl = jsonObject.getString(JSON_CONTENT_URL);
                        pages.add(new ImagePage(title, subtitle, contentType, contentUrl));
                        Log.i(TAG, "loadJSONFromAsset: imagePage was added..");
                        break;
                    default:
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pages;
    }

}
