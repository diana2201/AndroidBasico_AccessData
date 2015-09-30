package com.moviles.salt.accessdata.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.moviles.salt.accessdata.models.Pelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diana M on 30/09/2015.
 */
public class PeliculaDAO {

    public static final String NAME = "pelicula";
    public static final String ID = "_id";
    public static final String C_NAME = "nombre";
    public static final String C_GENERO = "genero";
    public static final String C_DURACION = "duracion";

    SQLiteDatabase db;

    public PeliculaDAO(Context context) {

        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
        Log.d("TagDB","Constructor pelicula DAO");
    }

    public void insertPelicula(Pelicula pelicula)
    {
        ContentValues cV = new ContentValues();
        cV.put(C_NAME,pelicula.getNombre());
        cV.put(C_GENERO,pelicula.getGenero());
        cV.put(C_DURACION, pelicula.getDuracion());

        int idRes = (int) db.insert(NAME,null,cV);

        if(idRes>-1)
        {
            pelicula.setId(idRes);
        }
        else {
            Log.d("TagError", "No se pudo ingresar a la base de datos");
        }
    }

    public void updatePelicula(Pelicula pelicula)
    {
        ContentValues cV = new ContentValues();
        cV.put(C_NAME,pelicula.getNombre());
        cV.put(C_GENERO,pelicula.getGenero());
        cV.put(C_DURACION,pelicula.getDuracion());

        db.update(NAME,cV,ID+"="+pelicula.getId(),null);
    }

    public void deletePelicula(Pelicula pelicula)
    {
        db.delete(NAME, ID + "=" + pelicula.getId(), null);
    }

    public Pelicula getPelicula (int id)
    {
        String sql = "SELECT * FROM "+NAME+" WHERE "+ID+"="+id;
        Pelicula p = null;

        Cursor c = db.rawQuery(sql,null);

        if(c.getCount()>0)
        {
            c.moveToNext();
            p = new Pelicula();
            p.setId(c.getInt(0));
            p.setNombre(c.getString(1));
            p.setGenero(c.getString(2));
            p.setDuracion(c.getFloat(3));
        }
        return p;
    }

    public List<Pelicula> getAllPeliculas()
    {
        List<Pelicula> data = new ArrayList<>();
        String sql = "SELECT * FROM "+NAME;
        Cursor c = db.rawQuery(sql,null);

        for (int i=0;i<c.getCount();i++)
        {
            c.moveToPosition(i);
            Pelicula p = new Pelicula();
            p.setId(c.getInt(0));
            p.setNombre(c.getString(1));
            p.setGenero(c.getString(2));
            p.setDuracion(c.getFloat(3));
            data.add(p);
        }

        return data;
    }

    public List<Pelicula> getPeliculasByName(String nombre)
    {
        List<Pelicula> data = new ArrayList<>();

        String sql = "SELECT * FROM "+NAME+" WHERE "+C_NAME+" LIKE '%"+nombre+"%'";
        Cursor c = db.rawQuery(sql,null);

        for (int i=0;i<c.getCount();i++)
        {
            c.moveToPosition(i);
            Pelicula p = new Pelicula();
            p.setId(c.getInt(0));
            p.setNombre(c.getString(1));
            p.setGenero(c.getString(2));
            p.setDuracion(c.getFloat(3));
            data.add(p);
        }

        return data;
    }
}
