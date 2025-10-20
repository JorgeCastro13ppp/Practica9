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
    }

    protected void onClick(View vista){
        Intent intento = new Intent(MainActivity.this,MainActivity2.class);
        intento.putExtra("nombre",nombre.getText().toString());
        intento.putExtra("altura",altura.getText().toString());
        intento.putExtra("peso",peso.getText().toString());

        startActivity(intento);
    }
}