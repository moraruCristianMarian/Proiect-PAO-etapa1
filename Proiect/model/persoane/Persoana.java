package model.persoane;

public class Persoana {

    private String nume;
    private String prenume;


    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public Persoana() {
        this.nume = "(Fara nume)";
        this.prenume = "(Fara prenume)";
    }

    public void afisare() {
        System.out.print(this.nume + " " + this.prenume);
    }


    public void setNume(String nume) { this.nume = nume; }
    public String getNume() { return nume; }

    public void setPrenume(String prenume) { this.prenume = prenume; }
    public String getPrenume() { return prenume; }


    public String getNumePrenume() {
        return getNume() + " " + getPrenume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoana pers))
            return false;

        return (nume.equals(pers.getNume()) && prenume.equals(pers.getPrenume()));
    }

}
