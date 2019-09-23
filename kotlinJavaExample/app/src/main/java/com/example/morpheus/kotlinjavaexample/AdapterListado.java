package com.example.morpheus.kotlinjavaexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListado extends RecyclerView.Adapter<AdapterListado.ViewHolder> {
    private List<PojoBasico> list;

    public AdapterListado(List<PojoBasico> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       PojoBasico data = list.get(position);

       holder.txtTitle.setText(data.getTitulo());
       holder.txtDescripcion.setText(data.getDescripcion());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtItemTitle);
            txtDescripcion = itemView.findViewById(R.id.txtItemDescripcion);
        }
    }
}
