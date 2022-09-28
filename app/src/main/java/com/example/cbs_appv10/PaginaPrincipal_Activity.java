package com.example.cbs_appv10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.cbs_appv10.HomeAdapter.FeaturedAdapter;
import com.example.cbs_appv10.HomeAdapter.FeaturedHelpedClass;

import java.util.ArrayList;

public class PaginaPrincipal_Activity extends AppCompatActivity {

    RecyclerView featuredRecycler, mostViewedRecycle, categoriesRecycler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pagina_principal);
        Button btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);


        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaginaPrincipal_Activity.this, LoginIniciarSesion_Activity.class));
            }
        });

        featuredRecycler = findViewById(R.id.featured_recycle);
        mostViewedRecycle = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);

        featuredRecycler();

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelpedClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelpedClass(R.drawable.soy_leyenda_portada1, 4, "Soy Legenda", "Robert Neville es el único sobreviviente en un planeta asolado...", "Autor: Richard Matheson", "Género: Ciencia Ficción"));
        featuredLocations.add(new FeaturedHelpedClass(R.drawable.de_sangre_y_cenizas_portada2, 3, "De Sangre y Cenizas", "Una Doncella elegida desde su nacimiento para comenzar una nueva era...", "Jennifer L. Armentrout", "Fantasía"));
        featuredLocations.add(new FeaturedHelpedClass(R.drawable.el_resplandor_portada3,4 , "El resplandor", "Jack Torrance acepta una oferta de trabajo en un hotel de montaña que se encuentra a 65 kilómetros del...", "Stephen King", "Horror"));
        featuredLocations.add(new FeaturedHelpedClass(R.drawable.cumbres_borrascosas_portada4,5 , "Cumbres Borrascosas", "Cumbres borrascosas constituye una asombrosa visión metafísica del destino, la obsesión, la pasión y la venganza...", "Emily Bronte", "Romance"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }
}
