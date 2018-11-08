package com.example.alumno.tp_labov;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alumno on 11/10/2018.
 */

public class ParseProductoXML {




    public static List<Noticia> Listar(String stringXML){
        List<Noticia> noticias = new ArrayList<>();
        Noticia noti = null;

        try {
            XmlPullParser xml = Xml.newPullParser();
            xml.setInput(new StringReader(stringXML));
            SimpleDateFormat fechaParse = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            int event = xml.getEventType();
            while( event!= XmlPullParser.END_DOCUMENT ) {
                Log.d("Wile","while");
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        Log.d("StartTag","tag: "+xml.getName());
                        if ("item".equals(xml.getName())){
                            noti = new Noticia();
                        }else if ("title".equals(xml.getName())) {
                            noti.setTitulo(xml.nextText());
                        }else if ("link".equals(xml.getName())) {
                            noti.setUrl(xml.nextText());
                        }else if ("description".equals(xml.getName())) {
                            noti.setDescripcion(xml.nextText());
                        }else if ("pubDate".equals(xml.getName())) {
                            try {
                                Log.d("TEST", ""+fechaParse.parse(xml.nextText()));
                                Date date = fechaParse.parse(xml.nextText());
                                noti.setFecha(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }else if("dc:creator".equals(xml.getName()) && noti != null)
                            noti.setCreador(xml.nextText());
                        else if("enclosure".equals(xml.getName()) && noti != null){
                            if(xml.getAttributeValue(null, "url") != null)
                                noti.setImagen(xml.getAttributeValue(null, "url"));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                       // Log.d("EndTag","tag: "+xml.getName());
                        if("item".equals(xml.getName()))
                        {
                            noticias.add(noti);
                        }
                        break;
                }
                event   = xml.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return noticias;
    }

//public static String json(String stringXML)


}