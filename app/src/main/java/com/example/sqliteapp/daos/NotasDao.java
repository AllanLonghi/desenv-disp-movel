package com.example.sqliteapp.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqliteapp.models.Nota;

import java.util.ArrayList;
import java.util.List;

public class NotasDao {
    private Context context;
    private SQLiteDatabase db;

    public NotasDao(Context context) {
        this.context = context;
        this.db = context.openOrCreateDatabase("db_sqlite", context.MODE_PRIVATE, null);
        this.db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (" +
                " %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                " %s VARCHAR NOT NULL " +
                ");", Nota.NOTA, Nota.ID, Nota.DESC));
    }

    public Nota insert(Nota nota) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Nota.DESC, nota.getDesc());
        Long id = this.db.insert(Nota.NOTA, "", contentValues);
        return new Nota(id.intValue(), nota.getDesc());
    }

    public List<Nota> getAll() {
        List<Nota> notas = new ArrayList<>();
        Cursor c = this.db.rawQuery(String.format("SELECT %s, %s FROM %s ", Nota.ID, Nota.DESC, Nota.NOTA), null);
        while (!c.isAfterLast()) {
            notas.add(new Nota(c.getInt(0), c.getString(1)));
        }
        c.close();
        return notas;
    }

    public Nota get(int id) {
        Nota nota = null;
        Cursor c = this.db.rawQuery(
                String.format("SELECT %s, %s FROM %s WHERE %s = %o", Nota.ID, Nota.DESC, Nota.NOTA, Nota.ID, id),
                null);

        while (!c.isAfterLast()) {
            nota = new Nota(c.getInt(0), c.getString(1));
        }
        c.close();
        return nota;
    }


}