package model.carti;

import model.carti.Carte;
import model.persoane.Autor;

public class CarteSF extends Carte {

    private double rating;

    public CarteSF(String titlu, Autor autor, int nrPagini, double rating) {
        super(titlu, autor, nrPagini);
        this.rating = rating;
    }


    public void setRating(double rating) { this.rating = rating; }
    public double getRating() { return rating; }

    @Override
    public void afisare() {
        super.afisare();
        System.out.println("Detalii S.F.");
        System.out.println("Rating: " + this.rating);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarteSF csf))
            return false;

        return (super.equals(o) && rating == csf.rating);
    }

}
