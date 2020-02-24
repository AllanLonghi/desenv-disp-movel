package com.example.aluno.sorteio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    EditText firstValue;
    EditText secondValue;
    Button btnSortear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.textView2);
        firstValue = findViewById(R.id.edtFirstValue);
        secondValue = findViewById(R.id.edtSecondValue);
        btnSortear = findViewById(R.id.button);
        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer intFirstValue = Integer.parseInt(firstValue.getText().toString());
                Integer intSecondValue = Integer.parseInt(secondValue.getText().toString());
                Integer result = new Random().nextInt(intSecondValue-intFirstValue) + intSecondValue;
                resultado.setText(result.toString());
            }
        });
    }
}
