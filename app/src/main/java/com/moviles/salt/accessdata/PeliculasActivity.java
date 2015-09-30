package com.moviles.salt.accessdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.moviles.salt.accessdata.adapters.PeliculaAdapter;
import com.moviles.salt.accessdata.database.PeliculaDAO;
import com.moviles.salt.accessdata.models.Pelicula;

import java.util.List;

public class PeliculasActivity extends AppCompatActivity {

    ListView list;
    PeliculaAdapter adapter;
    PeliculaDAO peliculaDAO;
    List<Pelicula> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        peliculaDAO = new PeliculaDAO(this);
        Log.d("tag","Oncreate Peliculas Activity");


        list = (ListView) findViewById(R.id.list);

        data = peliculaDAO.getAllPeliculas();

        adapter = new PeliculaAdapter(this,data);

        list.setAdapter(adapter);
    }
}
