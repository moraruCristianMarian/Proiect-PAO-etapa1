package model;

import model.carti.*;
import model.persoane.*;

public class Imprumut {

    private CopieCarte copieImprumutata;
    private Cititor cititorActual;


    public Imprumut(CopieCarte copieImprumutata, Cititor cititorActual) {
        this.copieImprumutata = copieImprumutata;
        this.cititorActual = cititorActual;
    }


    public void setCopieImprumutata(CopieCarte copieImprumutata) { this.copieImprumutata = copieImprumutata; }
    public CopieCarte getCopieImprumutata() { return copieImprumutata; }

    public void setCititorActual(Cititor cititorActual) { this.cititorActual = cititorActual; }
    public Cititor getCititorActual() { return cititorActual; }


}
