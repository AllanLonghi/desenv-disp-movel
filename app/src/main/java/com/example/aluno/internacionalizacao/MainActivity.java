package com.example.aluno.internacionalizacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listView);

        final ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Maça");
        frutas.add("pera");
        frutas.add("uva");
        frutas.add("melancia");

        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                frutas);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, frutas.get(i), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ComponentView.class);
                startActivity(intent);
            }
        });

    }
}
