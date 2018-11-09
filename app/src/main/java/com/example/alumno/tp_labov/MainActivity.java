package com.example.alumno.tp_labov;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, SearchView.OnQueryTextListener {

   public Handler h;
    URL url;
    RecyclerView rvProductos;
    List<Noticia> p;
    MyAdapter adapter;
    Thread hilo;
    Worker w;
    List<Noticia> listaN;
    ImageView iv;

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

        rvProductos = (RecyclerView) findViewById(R.id.listaRV);

        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(p,this);
        rvProductos.setAdapter(adapter);



    }
    @Override
    protected void onStop() {
        super.onStop();
        hilo.interrupt();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem mi = menu.findItem(R.id.campo_buscar);
        SearchView sv = (SearchView) MenuItemCompat.getActionView(mi);

        sv.setOnQueryTextListener(this);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.campo_buscar) {
            Log.d("menu","Click en settings");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.arg1==1) {
            listaN = (List<Noticia>) msg.obj;
            adapter = new MyAdapter(listaN, this);
            rvProductos.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            rvProductos.setLayoutManager(new LinearLayoutManager(this));
            adapter.notifyDataSetChanged();

        }else if(msg.arg1==2){

            byte[] bytes = (byte[]) msg.obj;
            //Bitmap bytmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
          //  iv = (ImageView) findViewById(R.id.Imagen);
           // iv.setImageBitmap(bytmap);

            adapter.lista.get(msg.arg2).setImg(bytes);
            adapter.notifyItemChanged(msg.arg2);
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("search","enter");
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("search","text change");
        return false;
    }


}