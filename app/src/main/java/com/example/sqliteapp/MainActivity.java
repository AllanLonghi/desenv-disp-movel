package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqliteapp.controllers.NotasController;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private EditText editText;
    private NotasController notasController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notasController = new NotasController(this);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.addBtn);
        editText = findViewById(R.id.editText);
        listView.setAdapter(notasController.getNotasAdapter(R.layout.list_item));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notasController.addNota(editText.getText().toString());
                Log.e("TESTE", "Entrou aqui");
            }
        });

    }


}
