package com.example.practica9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditarActivity extends AppCompatActivity {

    EditText editNuevoTexto;
    Button btnModificar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        editNuevoTexto = findViewById(R.id.editNuevoTexto);
        btnModificar = findViewById(R.id.btnModificar);
        btnCancelar = findViewById(R.id.btnCancelar);

        //Recuperar el texto actual
        Intent intento2 = getIntent();
        String textoActual = intento2.getStringExtra("textoActual");
        if(textoActual!=null){
            editNuevoTexto.setText(textoActual);
        }

        //Botón modificar devuelve texto a la primera actividad
        btnModificar.setOnClickListener(v->{
            String nuevoTexto = editNuevoTexto.getText().toString();
            Intent data = new Intent();
            data.putExtra("textoNuevo",nuevoTexto);
            setResult(RESULT_OK,data);
            finish();
        });

        //Botón cancelar -> no devuelve cambios
        btnCancelar.setOnClickListener(v->{
            setResult(RESULT_CANCELED);
            finish();
        });

    }
}
