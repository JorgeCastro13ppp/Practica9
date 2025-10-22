package com.example.practica9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textoResultado;
    ImageView imagenTabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textoResultado = findViewById(R.id.textViewResultado);
        imagenTabla = findViewById(R.id.imageViewTabla);

        try{
            String nombre = getIntent().getStringExtra("nombre");
            double altura = Double.parseDouble(getIntent().getStringExtra("altura"));
            if(altura>3){
                altura = altura/100;
            }
            double peso = Double.parseDouble(getIntent().getStringExtra("peso"));
            double imc = peso /(altura*altura);
            String resultado = String.format(
                    "Nombre: %s\nAltura: %.2f m\nPeso: %.2f kg\n\nTu IMC es: %.2f",
                    nombre, altura, peso, imc
            );

            textoResultado.setText(resultado);
            imagenTabla.setImageResource(R.drawable.captura_desde_2025_10_22_09_05_43);
        }catch (Exception e) {
            // Si hay error, lo avisamos al usuario y cerramos la pantalla
            Toast.makeText(this, "Error: verifica los datos introducidos", Toast.LENGTH_LONG).show();
            finish();
        }

    }
}