package com.example.aluno.internacionalizacao;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ComponentView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_view);

        Bundle bundle = getIntent().getExtras();
        String component = bundle.getString("component");
        try {
            addComponent(Button.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addComponent(Class viewClass) throws Exception {
        Constructor constructor = viewClass.getConstructor(Context.class);
        final View instance = (View) constructor.newInstance(this);
        Method setText = instance.getClass().getMethod("setText", CharSequence.class);
        setText.invoke(instance, "Eu sou um ".concat(instance.getClass().getSimpleName()));
        instance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Eu sou um ".concat(instance.getClass().getSimpleName()), Toast.LENGTH_LONG);
            }
        });
        LinearLayout ll = (LinearLayout)findViewById(R.id.comp_layout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(instance, lp);
    }
}
