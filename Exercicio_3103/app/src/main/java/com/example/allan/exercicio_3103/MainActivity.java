package com.example.allan.exercicio_3103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private NotasController notasController;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView3);
        notasController = new NotasController(this);
    }

    private void salvar(View view) {
        String nota = editText.getText().toString();
        this.notasController.setString("notas", nota);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textView.setText(notasController.getString("notas"));
    }
}
