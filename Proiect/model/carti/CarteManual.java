package model.carti;

import model.carti.Carte;
import model.persoane.Autor;
import model.persoane.Persoana;

public class CarteManual extends Carte {

    private String materie;
    private int clasa;

    public CarteManual(String titlu, Autor autor, int nrPagini, String materie, int clasa) {
        super(titlu, autor, nrPagini);
        this.materie = materie;
        this.clasa = clasa;
    }


    public void setMaterie(String materie) {
        this.materie = materie;
    }
    public String getMaterie() {
        return materie;
    }

    public void setClasa(int clasa) {
        this.clasa = clasa;
    }

    public int getClasa() {
        return clasa;
    }

    @Override
    public void afisare() {
        super.afisare();
        System.out.println("Detalii manual");
        System.out.println("Materie: " + this.materie);
        System.out.println("Clasa: " + this.clasa);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarteManual cm))
            return false;

        return (super.equals(o) && materie.equals(cm.materie) && clasa == cm.clasa);
    }

}
