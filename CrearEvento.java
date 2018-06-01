package co.edu.icesi.id.studio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CrearEvento extends AppCompatActivity {

    EditText noombre, init, fin;
    String nombreevento, inicio, finale;
    Button cancelar, aceptar;
    Activity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);

        noombre = findViewById(R.id.nombreevento);
        init = findViewById(R.id.inicio);
        fin = findViewById(R.id.fin);

        cancelar = findViewById(R.id.cancelar);
        aceptar = findViewById(R.id.aceptar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noombre.getText().clear();
                init.getText().clear();
                fin.getText().clear();
                Intent intent = new Intent(CrearEvento.this, MainActivity.class);
                startActivity(intent);
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nombreevento= noombre.getText().toString().trim();
               inicio= init.getText().toString().trim();
               finale=fin.getText().toString().trim();
               String [] datos = {nombreevento,inicio,finale};
               Intent intent = new Intent(CrearEvento.this, MainActivity.class);
               intent.putExtra("datos",datos);
               startActivity(intent);
            }
        });

    }
}
