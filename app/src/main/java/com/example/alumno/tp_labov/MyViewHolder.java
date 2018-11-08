package com.example.alumno.tp_labov;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView titulo;
    TextView descripcion;
    TextView fecha;
    TextView link;
    TextView creador;
    ImageView foto;
    MainActivity activity;
    RecyclerView rvNoticias;

    int pos;



    public MyViewHolder(@NonNull View itemView,MainActivity activity) {
        super(itemView);
        /*this.nombre=(TextView) itemView.findViewById(R.id.txtNombre);
        this.cantidad=(TextView) itemView.findViewById(R.id.txtCantidad);
        this.precio =(TextView) itemView.findViewById(R.id.txtPrecio);
        this.mas = (ImageButton) itemView.findViewById(R.id.btnMas);
        this.menos = (ImageButton) itemView.findViewById(R.id.btnMenos);
        this.activity=activity;
        this.mas.setOnClickListener(this);
        this.menos.setOnClickListener(this);*/
      //  Log.d("Hola","holder");
        this.titulo=(TextView) itemView.findViewById(R.id.txtTitle);
        this.link=(TextView) itemView.findViewById(R.id.txtLink);
        this.descripcion=(TextView) itemView.findViewById(R.id.txtDescription);
        //this.fecha=(TextView) itemView.findViewById(R.id.txtPubDate);
        this.creador=(TextView) itemView.findViewById(R.id.txtCreador);
        this.foto=(ImageView) itemView.findViewById(R.id.Imagen);
    }

    @Override
    public void onClick(View v) {

        int x =0;
        if (v.getId() == this.rvNoticias.getId())
        {
            x=1;
        }



    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
