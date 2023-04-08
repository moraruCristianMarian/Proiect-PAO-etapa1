package model.carti;

import model.carti.Carte;
import model.persoane.Autor;

public class CartePoezii extends Carte {

    private int nrPoezii;

    public CartePoezii(String titlu, Autor autor, int nrPagini, int nrPoezii) {
        super(titlu, autor, nrPagini);
        this.nrPoezii = nrPoezii;
    }


    public void setNrPoezii(int rating) { this.nrPoezii = nrPoezii; }
    public int getNrPoezii() { return nrPoezii; }

    @Override
    public void afisare() {
        super.afisare();
        System.out.println("Detalii Poezii");
        System.out.println("Numar de poezii: " + this.nrPoezii);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartePoezii cp))
            return false;

        return (super.equals(o) && nrPoezii == cp.nrPoezii);
    }

}
