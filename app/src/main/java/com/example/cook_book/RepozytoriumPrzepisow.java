package com.example.cook_book;

import java.util.ArrayList;

public class RepozytoriumPrzepisow {
    public static final Przepis[] przepisy = {
            new Przepis("Jajecznica",0,"Jajka i Masło", R.drawable.jajecznica1),
            new Przepis("Spaghetti Napoli", 1,"Pomidory, Cebula, Czosnek, Bazylia, Oliwa i przyprawy", R.drawable.spaghetti_napoli),
            new Przepis("Angielskie Śniadanie",0,"Jajka, Fasola, Frankfurterki, Boczek, Pieczywo tostowe, Pomidory, Pieczarki i przyprawy",R.drawable.eng_sniadanie1),
            new Przepis("Calzone",1,"Ser i mąka", R.drawable.calzone1)

    };
    public static ArrayList<Przepis> wybierzPrzepisy(int kategoria){
        ArrayList<Przepis> wybrane = new ArrayList<>();
        for(Przepis przepis:przepisy){
            if(przepis.getKategoria() == kategoria){
                wybrane.add(przepis);
            }
        }
        return wybrane;
    }
}
