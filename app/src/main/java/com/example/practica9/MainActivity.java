package com.example.practica9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textPrincipal;
    Button btnCambiarTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPrincipal = findViewById(R.id.textPrincipal);
        btnCambiarTexto = findViewById(R.id.btnCambiarTexto);

        btnCambiarTexto.setOnClickListener(v->{
            //Crear intent para abrir la segunda actividad
            Intent intento1 = new Intent(MainActivity.this,EditarActivity.class);
            //Enviamos el texto actual
            intento1.putExtra("textoActual",textPrincipal.getText().toString());
            startActivityForResult(intento1,1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==1 && resultCode == RESULT_OK && data!=null){
            String nuevoTexto = data.getStringExtra("textoNuevo");
            textPrincipal.setText(nuevoTexto);
        }
    }


}