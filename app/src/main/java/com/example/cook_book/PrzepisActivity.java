package com.example.cook_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PrzepisActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepis);
        TextView tekst = findViewById(R.id.textViewTytul);
        ImageView obrazek = findViewById(R.id.imageView);
        TextView tekst2 = findViewById(R.id.textViewSklad);
        int ktoryPrzepis = getIntent().getExtras().getInt(ListaPrzepisowActivity.EXTRA_IDPRZEPISU,0);
        int kategoria = getIntent().getExtras().getInt(ListaPrzepisowActivity.EXTRA_KATEGORIA,0);
        Przepis przepis = RepozytoriumPrzepisow.wybierzPrzepisy(kategoria).get(ktoryPrzepis);
        tekst.setText(String.valueOf(przepis.getNazwa()));
        obrazek.setImageResource(przepis.getIdObrazka());
        tekst2.setText(String.valueOf(przepis.getListaSkladnikow()));
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //w manifescie
                Intent intencja = new Intent();
                intencja.setAction(Intent.ACTION_SEND);
                intencja.putExtra(Intent.EXTRA_TEXT, przepis.getNazwa()+" "+przepis.getListaSkladnikow()+" smacznego");
                intencja.setType("text/plain");
                Intent podzielSieIntencja = Intent.createChooser(intencja,null);
                startActivity(podzielSieIntencja);
            }
        });



    }
}