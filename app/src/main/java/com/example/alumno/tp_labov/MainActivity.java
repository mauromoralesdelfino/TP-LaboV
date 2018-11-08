package com.example.alumno.tp_labov;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    Handler h;
    URL url;
    RecyclerView rvProductos;
    List<Noticia> p;
    MyAdapter adapter;
    Thread hilo;
    Worker w;
    List<Noticia> listaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rvProductos = (RecyclerView) findViewById(R.id.listaRV);
        h=new Handler(this);
        w = new Worker(h,"https://www.clarin.com/rss/lo-ultimo/");
        hilo = new Thread(w);
        hilo.start();

        p = new ArrayList<>();
        p.add(new Noticia());


        rvProductos = (RecyclerView) findViewById(R.id.listaRV);
        //tv = (TextView) findViewById(R.id.txtPrecio);

        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(p,this);
        rvProductos.setAdapter(adapter);



    }
    @Override
    protected void onStop() {
        super.onStop();
        hilo.interrupt();
    }
    /*List<Producto> lista = (List<Producto>) msg.obj;
            adapter = new MyAdapter(this, lista);
            rvProductos.setAdapter(adapter);
            rvProductos.setLayoutManager(new LinearLayoutManager(this));*/

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.arg1==1) {
            listaN = (List<Noticia>) msg.obj;
            adapter = new MyAdapter(listaN, this);
            rvProductos.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            rvProductos.setLayoutManager(new LinearLayoutManager(this));
            adapter.notifyDataSetChanged();

        }
        return false;
    }

   /* public void controlStock(int id, int position)
    {

        if (id==1)
        {
            l.get(position).setCantidad(l.get(position).getCantidad() + 1);
            adapter.notifyItemChanged(position);
        }

        if (id==2)
        {
            l.get(position).setCantidad(l.get(position).getCantidad() - 1);
            adapter.notifyItemChanged(position);
        }

    }*/
}