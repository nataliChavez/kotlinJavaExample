package com.example.morpheus.kotlinjavaexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListadoActivity extends AppCompatActivity {
    RecyclerView rcvListado;
    TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        rcvListado = findViewById(R.id.rcvListado);
        txtNombre = findViewById(R.id.txtListadoUser);

        if(getIntent() !=null)
        {
            Bundle bundle = getIntent().getExtras();
            String nombre = bundle.getString("usuario");
            txtNombre.setText("Bienvenido " + nombre);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        
        rcvListado.setLayoutManager(linearLayoutManager);
        
        rcvListado.setAdapter(new AdapterListado(getFakeData()));


    }

    private List<PojoBasico> getFakeData() {
        List<PojoBasico> pojoBasicos = new ArrayList<>();
        for(int i= 0; i<10; i++)
        {
            pojoBasicos.add(new PojoBasico("Titulo","Descripcion"));
        }

        return  pojoBasicos;
    }
}
