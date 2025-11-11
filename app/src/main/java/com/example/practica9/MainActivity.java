package com.example.practica9;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textPrincipal;
    Button btnCambiarTexto;

    //Nuevo launcher moderno
    private final ActivityResultLauncher<Intent> launcherEditar =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if(result.getResultCode()== RESULT_OK && result.getData()!=null){
                            String nuevoTexto = result.getData().getStringExtra("textoNuevo");
                            textPrincipal.setText(nuevoTexto);
                        }
                    }

            );
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
            launcherEditar.launch(intento1);
        });
    }




}