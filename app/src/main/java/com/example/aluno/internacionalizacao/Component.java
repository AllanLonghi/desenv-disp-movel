package com.example.aluno.internacionalizacao;

import android.view.View;

/**
 * Created by Aluno on 3/10/2020.
 */

public class Component {
    public View getView() {
        return view;
    }

    public String getJava() {
        return java;
    }

    public String getXml() {
        return xml;
    }

    public Component(View view, String java, String xml) {
        this.view = view;
        this.java = java;
        this.xml = xml;
    }

    private View view;
    private String java;
    private String xml;
}
