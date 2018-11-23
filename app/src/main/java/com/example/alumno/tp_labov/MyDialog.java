package com.example.alumno.tp_labov;

import android.app.AlertDialog;
import android.app.Dialog;


import android.content.Context;
import android.content.DialogInterface;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;;

/**
 * Created by alumno on 15/11/2018.
 */

public class MyDialog extends DialogFragment {

    SharedPreferences prefs;
   View v;

    public Dialog onCreateDialog(Bundle d )
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
         v = LayoutInflater.from(this.getContext()).inflate(R.layout.rss_menu,null);
        builder.setTitle("Choice Rss");
        //builder.setMessage("Hola mundo");
        builder.setView(v);

        Listener l = new Listener(v);
        builder.setNegativeButton("Canelar",l);
        builder.setPositiveButton("Aceptar",l);


        AlertDialog ad = builder.create();
        mostrar();
        return ad;
    }


    public  void mostrar()
    {

        prefs = getContext().getSharedPreferences("miConfig", Context.MODE_PRIVATE);
        Boolean a = prefs.getBoolean("Lo Ultimo",false);
        Boolean b = prefs.getBoolean("Politica",false);
        Boolean c = prefs.getBoolean("Economia",false);
        Boolean d = prefs.getBoolean("Sociedad",false);
        Boolean e = prefs.getBoolean("Mundo",false);
        Boolean f = prefs.getBoolean("Tecnologia",false);



        Log.d("ABC","u " + a );
        Log.d("ABC","p " + b );
        Log.d("ABC","e " + c );
        Log.d("ABC","s " + d );
        Log.d("ABC","m " + e );
        Log.d("ABC","p " + f );

         }





}
