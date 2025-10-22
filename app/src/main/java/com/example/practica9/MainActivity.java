package com.example.practica9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre,altura,peso;
    Button botonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editTextNombre);
        altura = findViewById(R.id.editTextNumberDecimalAltura);
        peso = findViewById(R.id.editTextNumberDecimalPeso);

        botonCalcular = findViewById(R.id.buttonCalcular);

        botonCalcular.setOnClickListener(v->{
            String n = nombre.getText().toString();
            String a = altura.getText().toString();
            String p = peso.getText().toString();

            if(!n.isEmpty()&&!a.isEmpty()&&!p.isEmpty()){
                Intent intento = new Intent(MainActivity.this, MainActivity2.class);
                intento.putExtra("nombre",n);
                intento.putExtra("altura",a);
                intento.putExtra("peso",p);
                startActivity(intento);
            }else{
                if(n.isEmpty()){
                    nombre.setError("Introduce todos los datos.");
                }else if(a.isEmpty()){
                    altura.setError("Introduce todos los datos.");
                }else if(p.isEmpty()){
                    peso.setError("Introduce todos los datos.");
                }

            }
        });
    }
}