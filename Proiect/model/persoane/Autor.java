package model.persoane;

import java.util.ArrayList;
import java.util.List;

import model.Colectii;
import model.carti.*;

public class Autor extends Persoana {

    private List<Carte> publicatii;

    public Autor(String nume, String prenume) {
        super(nume, prenume);
        this.publicatii = new ArrayList<Carte>();
    }
    public Autor() {
        super();
        this.publicatii = new ArrayList<Carte>();
    }


    public List<Carte> getPublicatii() { return this.publicatii; }
    public void setPublicatii(List<Carte> publicatii) { this.publicatii = publicatii; }


    public void publicaOCarte(Carte carte) {
        this.publicatii.add(carte);
    }
    public void eliminaPublicare(Carte carte) {
        this.publicatii.remove(carte);
    }


    public static Autor autorDinString(String numePrenume, boolean creeazaNou) {

        String[] numeSiPrenume = numePrenume.split(" ",2);

        String nume = numeSiPrenume[0];
        String prenume;
        if (numeSiPrenume.length > 1)
            prenume = numeSiPrenume[1];
        else
            prenume = "(Fara prenume)";

        Autor autorReturnat = new Autor();
        boolean gasitAutor = false;
        for (Autor autor : Colectii.getSetAutori())
        {
            if (autor.getNume().equals(nume) && autor.getPrenume().equals(prenume))
            {
                autorReturnat = autor;
                gasitAutor = true;
                break;
            }
        }
        if (!gasitAutor && creeazaNou) {
            autorReturnat = new Autor(nume, prenume);
            Colectii.adaugaAutor(autorReturnat);
        }

        return autorReturnat;
    }


    @Override
    public void afisare() {
        super.afisare();

        if (this.publicatii.isEmpty())
        {
            System.out.print(" (nu a publicat nicio carte)");
        }
        else {
            if (this.publicatii.size() == 1)
                System.out.print(" (a publicat o carte)");
            else
                System.out.print(" (a publicat " + this.publicatii.size() + " carti)");
        }
    }

    public void afisareInfo()
    {
        this.afisare();
        System.out.println();
        for (Carte carte : publicatii) {
            System.out.println("   > \"" + carte.getTitlu() + "\"");
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Autor aut))
            return false;

        return super.equals(o) && getPublicatii().equals(aut.getPublicatii());
    }
}
