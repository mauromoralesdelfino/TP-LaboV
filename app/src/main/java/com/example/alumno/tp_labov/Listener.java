package com.example.alumno.tp_labov;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by alumno on 15/11/2018.
 */

public class Listener implements DialogInterface.OnClickListener {

    View v;
    SharedPreferences prefs;

    public Listener( View v)
    {
        this.v = v;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if (dialog.BUTTON_NEGATIVE == which)
        {
            dialog.cancel();
        }
        if (dialog.BUTTON_POSITIVE == which)
        {
            //Log.d("menu","Click en settings");
            //this.titulo=(TextView) itemView.findViewById(R.id.txtTitle);
            prefs = v.getContext().getSharedPreferences("miConfig", Context.MODE_PRIVATE);
            Editor editor = prefs.edit();
           for(View item:v.getTouchables())
            {
                Log.d("item1",""+((CheckBox)item).getText());

              //  editor.putString("key_1", "Hola mundo");
                //editor.putInt("key_2", 5);
              String nombreCheck = String.valueOf(((CheckBox) item).getText());
                editor.putBoolean(nombreCheck,((CheckBox) item).isChecked());

                Log.d("esto no se que es",""+nombreCheck);

            }
            editor.commit();
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