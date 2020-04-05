package com.example.allan.blocodenotas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Notas nota;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nota.salvaNota(editText.getText().toString());
            }
        });

        nota = new Notas(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();
        editText.setText(nota.recuperaNota());
    }

    @Override
    protected void onPause() {
        super.onPause();
        nota.salvaNota(editText.getText().toString());
    }

}
