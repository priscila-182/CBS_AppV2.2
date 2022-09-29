package com.example.cbs_appv10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cbs_appv10.HomeAdapter.CategoriasAdapter;
import com.example.cbs_appv10.HomeAdapter.CategoriasHelpedClass;
import com.example.cbs_appv10.HomeAdapter.FeaturedAdapter;
import com.example.cbs_appv10.HomeAdapter.FeaturedHelpedClass;
import com.example.cbs_appv10.HomeAdapter.MostViewedCardDesignAdapter;
import com.example.cbs_appv10.HomeAdapter.MostViewedCardDesignHelpedClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class PaginaPrincipal_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, mostViewedRecycle, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1;
    ImageView menuIcon;

    //Sección de menú

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    //SPLASH y Botones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pagina_principal);

        // Botones

        Button btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaginaPrincipal_Activity.this, LoginIniciarSesion_Activity.class));
            }
        });

        Button btnCategorias = (Button) findViewById(R.id.btn_IrCategorias);
        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaginaPrincipal_Activity.this, Categorias_Activity.class));
            }
        });

        Button btnVerTodosLosLibros = (Button) findViewById(R.id.btnVerTodos);
        btnVerTodosLosLibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaginaPrincipal_Activity.this, TodosLosLibros_Activity.class));
            }
        });

        // hooks
        featuredRecycler = findViewById(R.id.featured_recycle);
        mostViewedRecycle = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icono);

        //menu hooks

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navegation_view);


        navigationDrawer();

        //recycler view function calls

        featuredRecycler();
        mostViewedRecycle();
        categoriesRecycler();

    }


    //Funciones para la sección de navegación
    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_inicio);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    //Información de las tarjetas

    private void categoriesRecycler(){
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriasHelpedClass> categoriasLocations = new ArrayList<>();

        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.accion_color2, "Acción"));
        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.fantasia_color, "Fantasía"));
        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.horror_color, "Horror"));
        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.romance_color2, "Romance"));

        adapter = new CategoriasAdapter(categoriasLocations);
        categoriesRecycler.setAdapter(adapter);
    }

    private void mostViewedRecycle() {
        mostViewedRecycle.setHasFixedSize(true);
        mostViewedRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedCardDesignHelpedClass> mostViewedCardDesignLocations = new ArrayList<>();

        mostViewedCardDesignLocations.add(new MostViewedCardDesignHelpedClass(R.drawable.soy_leyenda_portada1, "Soy Legenda", "Robert Neville es el único sobreviviente en un planeta asolado...", "Autor: Richard Matheson", "Género: Ciencia Ficción"));
        mostViewedCardDesignLocations.add(new MostViewedCardDesignHelpedClass(R.drawable.cumbres_borrascosas_portada4, "Cumbres Borrascosas", "Cumbres borrascosas constituye una asombrosa visión metafísica del destino, la obsesión, la pasión y la venganza...", "Autor: Emily Bronte", "Género: Romance"));
        mostViewedCardDesignLocations.add(new MostViewedCardDesignHelpedClass(R.drawable.la_chica_del_tren_portada4, "La Chica del Tren", "Rachel Watson se divorcia del marido que la engaña y se siente sola y deprimida. No tiene trabajo y...", "Autor: Paula Hawkins", "Género: Thriller"));

        adapter = new MostViewedCardDesignAdapter(mostViewedCardDesignLocations);
        mostViewedRecycle.setAdapter(adapter);
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelpedClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelpedClass(R.drawable.soy_leyenda_portada1, "Soy Legenda", "Robert Neville es el único sobreviviente en un planeta asolado...", "Autor: Richard Matheson", "Género: Ciencia Ficción"));
        featuredLocations.add(new FeaturedHelpedClass(R.drawable.de_sangre_y_cenizas_portada2, "De Sangre y Cenizas", "Una Doncella elegida desde su nacimiento para comenzar una nueva era...", "Jennifer L. Armentrout", "Género: Fantasía"));
        featuredLocations.add(new FeaturedHelpedClass(R.drawable.el_resplandor_portada3, "El resplandor", "Jack Torrance acepta una oferta de trabajo en un hotel de montaña que se encuentra a 65 kilómetros del...", "Stephen King", "Género: Horror"));
        featuredLocations.add(new FeaturedHelpedClass(R.drawable.cumbres_borrascosas_portada4, "Cumbres Borrascosas", "Cumbres borrascosas constituye una asombrosa visión metafísica del destino, la obsesión, la pasión y la venganza...", "Emily Bronte", "Género: Romance"));
        featuredLocations.add(new FeaturedHelpedClass(R.drawable.la_chica_del_tren_portada4, "La Chica del Tren", "Rachel Watson se divorcia del marido que la engaña y se siente sola y deprimida. No tiene trabajo y...", "Autor: Paula Hawkins", "Género: Thriller"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}
