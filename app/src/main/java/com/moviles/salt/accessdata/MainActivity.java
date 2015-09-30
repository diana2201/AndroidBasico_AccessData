package com.moviles.salt.accessdata;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtAlmacenado;
    EditText txtIngresado;
    Button btn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    static final String KEY_INFO = "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAlmacenado = (TextView) findViewById(R.id.txtAlmacenado);
        txtIngresado = (EditText) findViewById(R.id.txtIngresado);
        btn = (Button) findViewById(R.id.btn);

        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();

        btn.setOnClickListener(this);

        String msj = preferences.getString(KEY_INFO,"");
        txtAlmacenado.setText(msj);
    }

    @Override
    public void onClick(View v) {
        String info;
        info = txtIngresado.getText().toString();

        editor.putString(KEY_INFO,info);
        editor.commit();
    }
}
