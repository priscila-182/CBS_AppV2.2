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
import android.widget.RatingBar;

import com.example.cbs_appv10.HomeAdapter.AllBooksAdapter;
import com.example.cbs_appv10.HomeAdapter.AllBooksHelpedClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class TodosLosLibros_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView allBooksRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1;
    ImageView menuIcon;

    //Sección de menú

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_los_libros);

        ratingBar = (RatingBar) findViewById(R.id.ab_ratingBar);

        allBooksRecycler = findViewById(R.id.all_books_recycler);
        menuIcon = findViewById(R.id.menu_icono);

        //menu hooks

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navegation_view);


        navigationDrawer();

        //recycler view function calls

        allBooksRecycler();

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

    //Información de libros

    private void allBooksRecycler() {

        allBooksRecycler.setHasFixedSize(true);
        allBooksRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<AllBooksHelpedClass> allBooksLocations = new ArrayList<>();

        allBooksLocations.add(new AllBooksHelpedClass(R.drawable.soy_leyenda_portada1, "Soy Legenda", "Robert Neville es el único sobreviviente en un planeta asolado...", "Autor: Richard Matheson", "Género: Ciencia Ficción", "Puntuación: "));
        allBooksLocations.add(new AllBooksHelpedClass(R.drawable.de_sangre_y_cenizas_portada2, "De Sangre y Cenizas", "Una Doncella elegida desde su nacimiento para comenzar una nueva era...", "Jennifer L. Armentrout", "Género: Fantasía", "Puntuación: "));
        allBooksLocations.add(new AllBooksHelpedClass(R.drawable.el_resplandor_portada3, "El resplandor", "Jack Torrance acepta una oferta de trabajo en un hotel de montaña que se encuentra a 65 kilómetros del...", "Stephen King", "Género: Horror", "Puntuación: "));
        allBooksLocations.add(new AllBooksHelpedClass(R.drawable.cumbres_borrascosas_portada4, "Cumbres Borrascosas", "Cumbres borrascosas constituye una asombrosa visión metafísica del destino, la obsesión, la pasión y la venganza...", "Emily Bronte", "Género: Romance", "Puntuación: "));
        allBooksLocations.add(new AllBooksHelpedClass(R.drawable.la_chica_del_tren_portada4, "La Chica del Tren", "Rachel Watson se divorcia del marido que la engaña y se siente sola y deprimida. No tiene trabajo y...", "Autor: Paula Hawkins", "Género: Thriller", "Puntuación: "));

        adapter = new AllBooksAdapter(allBooksLocations);
        allBooksRecycler.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}