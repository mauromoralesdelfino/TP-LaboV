package com.example.alumno.tp_labov;

import android.os.Handler;
import android.os.Message;

import java.net.URL;

/**
 * Created by alumno on 11/10/2018.
 */

public class Worker extends Thread {

    Handler h;
    URL url;
    Boolean bool;
    String conex;

    public Worker(Handler h, String url)
    {
        this.h =h;
        this.conex = url;

    }

    @Override
    public void run() {


        try {

            HttpConection z = new HttpConection("GET");


            Thread.sleep(4000);
            Message m = new Message();
            m.arg1=1;
            //new String(this.httpConnection.getBytesData(this.url))
           m.obj = ParseProductoXML.Listar(new String(z.getBytesData(conex)));

            h.sendMessage(m);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}