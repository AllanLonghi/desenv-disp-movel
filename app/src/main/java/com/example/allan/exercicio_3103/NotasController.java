package com.example.allan.exercicio_3103;

import android.content.Context;
import android.content.SharedPreferences;

public class NotasController {

    private SharedPreferences sharedPreferences;

    public NotasController(Context c) {
        sharedPreferences = c.getSharedPreferences("notepad", c.MODE_PRIVATE);
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


}
