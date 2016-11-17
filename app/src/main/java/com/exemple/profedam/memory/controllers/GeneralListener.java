package com.exemple.profedam.memory.controllers;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.exemple.profedam.memory.model.Carta;
import com.exemple.profedam.memory.model.Partida;

import java.util.ArrayList;


/**
 * Created by ALUMNEDAM on 02/02/2016.
 */
public class GeneralListener implements AdapterView.OnItemClickListener, Runnable{

    private MainActivity tauler;
    private Carta cartaOnClick;
    private boolean listenerActive = true;
    private ArrayList<Carta> listaCartasFront;

    public GeneralListener(MainActivity tauler) {
        this.tauler = tauler;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //Solo procesamos clicks si el listener es activo
        Partida partida = tauler.getPartida();

        if(listenerActive) {

            Toast.makeText(tauler, "position" + position, Toast.LENGTH_SHORT).show();
            //view.setVisibility(View.INVISIBLE);

            cartaOnClick = tauler.getPartida().getLlistaCartes().get(position);
            cartaOnClick.girar();

            tauler.refrescarTablero();
            int cont=0;
            listaCartasFront = partida.mostrarCartasFront();

            if(listaCartasFront.size()==2 && listaCartasFront.get(0).getFrontImage() != listaCartasFront.get(1).getFrontImage()) {
                this.listenerActive = false;

                Handler delay = new Handler();
                delay.postDelayed(this, 2000);

            }else if(listaCartasFront.size()==2){
                listaCartasFront.get(0).setEstat(Carta.Estat.FIXED);
                listaCartasFront.get(1).setEstat(Carta.Estat.FIXED);
            }

        }
    }

    @Override
    public void run() {
        listaCartasFront.get(0).girar();
        listaCartasFront.get(1).girar();
        tauler.refrescarTablero();
        listenerActive = true;
    }

}

