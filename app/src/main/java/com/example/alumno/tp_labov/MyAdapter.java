package com.example.alumno.tp_labov;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alumno on 11/10/2018.
 */


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MyViewHolder h = new MyViewHolder(v,this.activity);
        return h;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Noticia p = this.lista.get(position);
        /*String s = p.getCantidad().toString();
        holder.nombre.setText(p.getNombre());
        holder.precio.setText(p.getPrecio().toString());
        holder.cantidad.setText(p.getCantidad().toString());*/
        holder.setPos(position);
        holder.titulo.setText(p.getTitulo());
        holder.descripcion.setText(p.getDescripcion());
       // holder.fecha.setText(p.getFecha().toString());
        holder.creador.setText(p.getCreador());
        holder.link.setText(p.getUrl());


    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

     List<Noticia> lista;
     MainActivity activity;

    /*public MyAdapter(List<Producto> lista, MainActivity activity) {
        this.lista = lista;
        this.activity=activity;
    }*/
    public MyAdapter(List<Noticia> lista, MainActivity activity) {
        this.lista = lista;
        this.activity=activity;
    }
}