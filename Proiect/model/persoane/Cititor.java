package model.persoane;

import model.Colectii;

public class Cititor extends Persoana {

    private int nrCartiImprumutate;

    public Cititor(String nume, String prenume)
    {
        this(nume, prenume, 0);
    }
    public Cititor(String nume, String prenume, int nrCartiImprumutate) {
        super(nume, prenume);
        this.nrCartiImprumutate = nrCartiImprumutate;
    }
    public Cititor() {
        super();
        this.nrCartiImprumutate = 0;
    }

    public Cititor(Cititor cititor) {
        this(cititor.getNume(), cititor.getPrenume(), cititor.nrCartiImprumutate);
    }


    public void setNrCartiImprumutate(int nrCartiImprumutate) { this.nrCartiImprumutate = nrCartiImprumutate; }
    public int getNrCartiImprumutate() { return nrCartiImprumutate; }



    public static Cititor cititorDinString(String numePrenume, boolean creeazaNou) {

        String[] numeSiPrenume = numePrenume.split(" ",2);

        String nume = numeSiPrenume[0];
        String prenume;
        if (numeSiPrenume.length > 1)
            prenume = numeSiPrenume[1];
        else
            prenume = "(Fara prenume)";

        Cititor cititorReturnat = new Cititor();
        boolean gasitCititor = false;
        for (Cititor cititor : Colectii.getSetCititori())
        {
            if (cititor.getNume().equals(nume) && cititor.getPrenume().equals(prenume))
            {
                cititorReturnat = cititor;
                gasitCititor = true;
                break;
            }
        }
        if (!gasitCititor && creeazaNou) {
            cititorReturnat = new Cititor(nume, prenume);
            Colectii.adaugaCititor(cititorReturnat);
        }

        return cititorReturnat;
    }

    public void afisareInfo() {
        super.afisare();

        if (this.nrCartiImprumutate == 0)
        {
            System.out.print(" (nu a imprumutat nicio carte)");
        }
        else {
            if (this.nrCartiImprumutate == 1)
                System.out.print(" (a imprumutat o carte)");
            else
                System.out.print(" (a imprumutat " + this.nrCartiImprumutate + " carti)");
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Cititor cit))
            return false;

        return super.equals(o) && getNrCartiImprumutate() == cit.getNrCartiImprumutate();
    }

}
