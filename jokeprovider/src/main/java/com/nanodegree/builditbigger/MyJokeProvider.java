package com.nanodegree.builditbigger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyJokeProvider {
    private List<String> mJokes = new ArrayList<>();

    Random mRandom = new Random();

    public MyJokeProvider() {
        setJokes();
    }

    private void setJokes() {
        String jokesJson = null;
        try {
            jokesJson = ResourceReader.getResource("jokes.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jokesJson != null) {
            Type listType = new TypeToken<List<String>>() {
            }.getType();
            mJokes = new Gson().fromJson(jokesJson, listType);
        }
    }

    /**
     * Gets a random joke from the data store
     *
     * @return The selected joke
     */
    public String getJoke() {
        int selected = mRandom.nextInt(mJokes.size());
        return mJokes.get(selected);
    }
}
