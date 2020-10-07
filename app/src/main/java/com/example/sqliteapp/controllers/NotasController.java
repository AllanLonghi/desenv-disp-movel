package com.example.sqliteapp.controllers;

import android.content.Context;

import com.example.sqliteapp.daos.NotasDao;
import com.example.sqliteapp.models.Nota;

public class NotasController {
    private Context context;
    private NotasDao dao;
    private NotasAdapter notasAdapter;

    public NotasController(Context context) {
        this.context = context;
        dao = new NotasDao(context);
    }

    public NotasAdapter getNotasAdapter(int resource) {
        notasAdapter = new NotasAdapter(context, resource);
        notasAdapter.addAll(dao.getAll());
        return notasAdapter;
    }

    public void addNota(String desc) {
        Nota nota = dao.insert(new Nota(null, desc));
        notasAdapter.add(nota);
        notasAdapter.notifyDataSetChanged();
    }
}
