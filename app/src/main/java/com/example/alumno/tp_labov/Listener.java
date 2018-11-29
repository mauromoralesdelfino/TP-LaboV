package com.example.alumno.tp_labov;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
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
import android.view.View;

/**
 * Created by alumno on 15/11/2018.
 */

public class Listener implements DialogInterface.OnClickListener {

    View v;
    SharedPreferences prefs;
    MainActivity act;

    public Listener( View v,MainActivity act)

    {
        this.v = v;
        this.act=act;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if (dialog.BUTTON_NEGATIVE == which)
        {
            dialog.cancel();
        }
        if (dialog.BUTTON_POSITIVE == which)
        {


            prefs = v.getContext().getSharedPreferences("miConfig", Context.MODE_PRIVATE);
            Editor editor = prefs.edit();
           for(View item:v.getTouchables())
            {
                //Log.d("item1",""+((CheckBox)item).getText());

              //  editor.putString("key_1", "Hola mundo");
                //editor.putInt("key_2", 5);
              String nombreCheck = String.valueOf(((CheckBox) item).getText());
                editor.putBoolean(nombreCheck,((CheckBox) item).isChecked());

               // Log.d("esto no se que es",""+nombreCheck);

            }
            editor.commit();
           act.TemasElegidos();


        }

    }
}
/*fun onCheckboxClicked(view: View) {
    if (view is CheckBox) {
        val checked: Boolean = view.isChecked

        when (view.id) {
            R.id.checkbox_meat -> {
                if (checked) {
                    // Put some meat on the sandwich
                } else {
                    // Remove the meat
                }
            }
            R.id.checkbox_cheese -> {
                if (checked) {
                    // Cheese me
                } else {
                    // I'm lactose intolerant
                }
            }
            // TODO: Veggie sandwich
        }
    }
}*/