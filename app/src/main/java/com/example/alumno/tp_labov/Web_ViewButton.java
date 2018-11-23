package com.example.alumno.tp_labov;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web_ViewButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_web__view_button);
        WebView wv = (WebView) findViewById(R.id.webview);
        android.support.v7.app.ActionBar barra = getSupportActionBar();
        //barra.setTitle("Hola");
        barra.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String strActivity1 = extras.getString("sitio");
        wv.setWebViewClient(new WebViewClient());
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.loadUrl(strActivity1);




    }//segundo metodo

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Log.d("back","BOTON BACK");
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
/*onCreate recuperar el string de url(ruta) de la noticia putextra y getextra
String s = (ruta)
webView wv = wv findviewById
(habilitar javascript en webview)
WebSettings ws = wv.getSettings
ws.setJAvaScripEnable(true)
wv.loadURl(s);
loadData(html);

esto dentro del segundo activity


floating action button, abajo a la derecha con el compartir, back arriba a la izquierda
*
*
* */