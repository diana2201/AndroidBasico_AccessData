package com.moviles.salt.accessdata.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moviles.salt.accessdata.R;
import com.moviles.salt.accessdata.models.Pelicula;

import java.util.List;

/**
 * Created by Diana M on 30/09/2015.
 */
public class PeliculaAdapter extends BaseAdapter {

    Context context;
    List<Pelicula> data;

    public PeliculaAdapter(Context context, List<Pelicula> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;

        if (convertView == null){
            v = View.inflate(context,
                    R.layout.template_pelicula, null);
        }
        else {
            v = convertView;
        }

        TextView nombre = (TextView) v.findViewById(R.id.txt_nombre_Ad);
        TextView genero = (TextView) v.findViewById(R.id.txt_genero_Ad);
        TextView duracion = (TextView) v.findViewById(R.id.txt_duracion_Ad);

        Pelicula p = data.get(position);

        nombre.setText(p.getNombre());
        genero.setText(p.getGenero());
        duracion.setText(""+p.getDuracion());
        return v;
    }
}
