package model.carti;

import model.persoane.Autor;
import model.persoane.Persoana;

public class Carte {
    private String titlu;
    private Autor autor;
    public int nrPagini;

    public Carte(String titlu, Autor autor, int nrPagini) {
        this.titlu = titlu;
        this.autor = autor;
        this.nrPagini = nrPagini;
    }

    public Carte(Carte carte) {
        this(carte.titlu, carte.autor, carte.nrPagini);
    }


    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    public int getNrPagini() {
        return nrPagini;
    }


    public void afisare() {
        System.out.println("Titlu: " + this.titlu);
        System.out.print("Autor: ");
        this.autor.afisare();
        System.out.println();
        System.out.println("Nr. pagini: " + this.nrPagini);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carte c))
            return false;

        return (titlu.equals(c.titlu) && autor.equals(c.autor) && nrPagini == c.nrPagini);
    }
}
