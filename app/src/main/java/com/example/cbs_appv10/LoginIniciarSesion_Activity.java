package com.example.cbs_appv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginIniciarSesion_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_iniciar_sesion);
        Button btnAtras = (Button) findViewById(R.id.btnAtrasIngreso);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginIniciarSesion_Activity.this, PaginaPrincipal_Activity.class));
            }
        });

        Button btnCrearCuenta = (Button) findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginIniciarSesion_Activity.this, LoginRegistro_Activity.class));
            }
        });
    }
}
