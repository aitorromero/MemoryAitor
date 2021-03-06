package com.exemple.profedam.memory.model;

import com.exemple.profedam.memory.R;

/**
 * Created by ALUMNEDAM on 29/01/2016.
 */
public class Carta {

    public enum Estat {BACK, FRONT, FIXED}

    private final int backImage = R.drawable.back;
    private int frontImage;
    private Estat estat;

    public Carta(int frontImage) {
        this.frontImage = frontImage;
        this.estat = Estat.BACK;
    }

    public int getFrontImage() {
        return frontImage;
    }

    public int getBackImage() {
        return backImage;
    }

    public void setEstat(Estat estat) {
        this.estat = estat;
    }

    public void girar(){
        //TODO canviar logicamente el estado de la carta

        switch (estat){
            case BACK:
                this.estat = Estat.FRONT;
                break;
            case FRONT:
                this.estat = Estat.BACK;
                break;
        }

    }

    public int getActive(){
        //TODO devuelve la foto a mostrar en la aplicación
        int activeImage = 0;

        switch (estat){
            case BACK:
                activeImage = this.backImage;
                break;
            case FRONT: case FIXED:
                activeImage = this.frontImage;
                break;
        }

        return activeImage;
    }
}
