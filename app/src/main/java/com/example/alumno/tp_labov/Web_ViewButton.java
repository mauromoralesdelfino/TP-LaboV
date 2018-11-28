package com.example.alumno.tp_labov;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v7.app.ActionBar;


public class Web_ViewButton extends AppCompatActivity implements FloatingActionButton.OnClickListener {

    Intent intent;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_web__view_button);
        WebView wv = (WebView) findViewById(R.id.webview);
        fab=(FloatingActionButton) findViewById(R.id.fab);

        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("WebView Activity");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        intent = getIntent();
        Bundle extras = intent.getExtras();

        String strActivity1 = extras.getString("sitio");
        wv.setWebViewClient(new WebViewClient());
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.loadUrl(strActivity1);

    fab.setOnClickListener(this);


    }//segundo metodo

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

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

    @Override
    public void onClick(View v) {
    if(v.getId() == fab.getId())
    {

        Intent segundo = new Intent(Intent.ACTION_SEND);
        segundo.setType("text/plane");
        segundo.putExtra(Intent.EXTRA_SUBJECT,"Compartir");
        segundo.putExtra(Intent.EXTRA_TEXT,"Mira esta noticia: \n" + intent.getExtras().getString("sitio"));
        Log.d("fab","fab");
        startActivity(segundo);
    }

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