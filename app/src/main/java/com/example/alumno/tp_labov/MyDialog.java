package com.example.alumno.tp_labov;

import android.app.AlertDialog;
import android.app.Dialog;


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
        return ad;
    }


    public void mostrar()
    {
       /* Boolean a = prefs.getBoolean("Lo Ultimo",false);
        Boolean b = prefs.getBoolean("Mundo",false);
        Boolean c = prefs.getBoolean("Tecnologia",false);
        Boolean d = prefs.getBoolean("Sociedad",false);
        Boolean e = prefs.getBoolean("Mundo",false);
        Boolean f = prefs.getBoolean("Politica",false);*/


        //Log.d("menu","" + a.toString());
         }





}
