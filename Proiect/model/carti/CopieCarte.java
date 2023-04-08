package model.carti;

import model.persoane.*;

public class CopieCarte {

    private Carte carteReferinta;
    private boolean esteImprumutata;

    public CopieCarte(Carte carteReferinta)
    {
        this.carteReferinta = new Carte(carteReferinta);
        this.esteImprumutata = false;
    }
    public CopieCarte(Carte carteReferinta, boolean esteImprumutata) {
        this.carteReferinta = carteReferinta;
        this.esteImprumutata = esteImprumutata;
    }
    public CopieCarte(CopieCarte copieCarte) {
        this(copieCarte.carteReferinta, copieCarte.esteImprumutata);
    }

    public void setCarteReferinta(Carte carteReferinta) { this.carteReferinta = carteReferinta; }
    public Carte getCarteReferinta() { return carteReferinta; }

    public void setEsteImprumutata(boolean esteImprumutata) { this.esteImprumutata = esteImprumutata; }
    public boolean getEsteImprumutata() { return esteImprumutata; }


    public void afisare() {
        String status;
        if (esteImprumutata) status = " (Imprumutata)"; else status = " (Disponibila)";
        System.out.print("\"" + carteReferinta.getTitlu() + "\", de " + carteReferinta.getAutor().getNumePrenume() + status);
    }


}
