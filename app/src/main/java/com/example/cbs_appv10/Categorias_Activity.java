package com.example.cbs_appv10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.cbs_appv10.HomeAdapter.CategoriasAdapter;
import com.example.cbs_appv10.HomeAdapter.CategoriasHelpedClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Categorias_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1;
    ImageView menuIcon;

    //Sección de menú

    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icono);

        //menu hooks

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navegation_view);


        navigationDrawer();

        //recycler view function calls

        categoriesRecycler();

    }

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

    // Información de las tarjetas

    private void categoriesRecycler(){
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<CategoriasHelpedClass> categoriasLocations = new ArrayList<>();

        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.accion_color2, "Acción"));
        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.fantasia_color, "Fantasía"));
        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.horror_color, "Horror"));
        categoriasLocations.add(new CategoriasHelpedClass(R.drawable.romance_color2, "Romance"));

        adapter = new CategoriasAdapter(categoriasLocations);
        categoriesRecycler.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}