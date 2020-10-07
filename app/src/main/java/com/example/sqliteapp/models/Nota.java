package com.example.sqliteapp.models;

public class Nota {

    public static final String NOTA = "nota";
    public static final String DESC = "desc";
    public static final String ID = "id";

    public Nota(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private String desc;
    private Integer id;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }
}
