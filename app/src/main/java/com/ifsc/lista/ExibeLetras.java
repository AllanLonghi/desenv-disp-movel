package com.ifsc.lista;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExibeLetras extends AppCompatActivity {
    TextView textViewCodigo,textViewNome;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_letra);

        int id=getIntent().getExtras().getInt("id");

        textViewCodigo=findViewById(R.id.textViewCodigo);
        textViewNome=findViewById(R.id.textViewNome);
        imageView=findViewById(R.id.imageView);

        LetrasController letrasController = new LetrasController();

        textViewCodigo.setText(letrasController.LETRAS[id].getId());
        textViewNome.setText(letrasController.LETRAS[id].getNome());
        imageView.setImageResource(letrasController.LETRAS[id].getImagem());
    }
}
