package com.example.allan.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Notas {
    SharedPreferences notas;
    SharedPreferences.Editor editor;
    Context contexto;
    private static final String PREFERENCIAS_FILE = "Notas";

    public Notas(Context c) {
        this.contexto = c;
        notas = this.contexto.getSharedPreferences(PREFERENCIAS_FILE, Context.MODE_PRIVATE);
        editor = notas.edit();
    }

    public void salvaNota(String s) {
        editor.putString(PREFERENCIAS_FILE, s);
        editor.commit();
    }

    public String recuperaNota() {
        if (this.notas.contains(PREFERENCIAS_FILE)) {
            String s = this.notas.getString(PREFERENCIAS_FILE, "");
            Toast.makeText(contexto, s, Toast.LENGTH_LONG).show();
            return s;
        } else {
            return "";
        }
    }

}
