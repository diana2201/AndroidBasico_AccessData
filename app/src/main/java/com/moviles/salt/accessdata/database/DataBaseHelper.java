package com.moviles.salt.accessdata.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Diana M on 30/09/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "peliculas.db";
    static int version = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + PeliculaDAO.NAME + " " +
                "(" + PeliculaDAO.ID + " INTEGER AUTO_INCREMENT PRIMARY KEY, "
                + PeliculaDAO.C_NAME + " VARCHAR, "
                + PeliculaDAO.C_GENERO + " VARCHAR, "
                + PeliculaDAO.C_DURACION + " FLOAT);");


        ContentValues cV = new ContentValues();
        cV.put(PeliculaDAO.C_NAME,"Transformers");
        cV.put(PeliculaDAO.C_GENERO,"Accion");
        cV.put(PeliculaDAO.C_DURACION, 120);

        db.insert(PeliculaDAO.NAME, null, cV);

        ContentValues cV2 = new ContentValues();
        cV2.put(PeliculaDAO.C_NAME,"Minions");
        cV2.put(PeliculaDAO.C_GENERO,"Infantil");
        cV2.put(PeliculaDAO.C_DURACION, 90);

        db.insert(PeliculaDAO.NAME,null,cV2);
        Log.d("TagDB", "Entra al onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+PeliculaDAO.NAME);
        onCreate(db);
    }
}
