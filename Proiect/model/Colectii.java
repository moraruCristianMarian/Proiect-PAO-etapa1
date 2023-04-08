package model;

import java.util.*;

import model.persoane.Autor;
import model.carti.*;
import model.persoane.Cititor;

public class Colectii {
    private static Set<Autor> setAutori = new HashSet<Autor>();
    private static Set<Cititor> setCititori = new HashSet<Cititor>();
    private static Set<CopieCarte> setCopii = new HashSet<CopieCarte>();
    private static Set<Imprumut> setImprumuturi = new HashSet<Imprumut>();
    private static List<Carte> listaCarti = new ArrayList<Carte>();


    public static void adaugaAutor(Autor autor) { setAutori.add(autor); }
    public static void eliminaAutor(Autor autor) { setAutori.remove(autor); }
    public static Set<Autor> getSetAutori() { return setAutori; }


    public static void adaugaCititor(Cititor cititor) { setCititori.add(cititor); }
    public static void eliminaCititor(Cititor cititor) { setCititori.remove(cititor); }
    public static Set<Cititor> getSetCititori() { return setCititori; }


    public static void adaugaCopie(CopieCarte copie) { setCopii.add(copie); }
    public static void eliminaCopie(CopieCarte copie) { setCopii.remove(copie); }
    public static Set<CopieCarte> getSetCopii() { return setCopii; }


    public static void adaugaImprumut(Imprumut imprumut) {
        setImprumuturi.add(imprumut);
        imprumut.getCititorActual().setNrCartiImprumutate(imprumut.getCititorActual().getNrCartiImprumutate() + 1);
        imprumut.getCopieImprumutata().setEsteImprumutata(true);
    }
    public static void eliminaImprumut(Imprumut imprumut) {
        setImprumuturi.remove(imprumut);
        imprumut.getCititorActual().setNrCartiImprumutate(imprumut.getCititorActual().getNrCartiImprumutate() - 1);
        imprumut.getCopieImprumutata().setEsteImprumutata(false);
    }
    public static Set<Imprumut> getSetImprumuturi() { return setImprumuturi; }


    public static void adaugaCarte(Carte carte) { listaCarti.add(carte); carte.getAutor().publicaOCarte(carte); }
    public static void eliminaCarte(Carte carte) { listaCarti.remove(carte); carte.getAutor().eliminaPublicare(carte); }
    public static List<Carte> getListaCarti() { return listaCarti; }
    public static void sortareCarti(Comparator<Carte> crit) { listaCarti.sort(crit); }


}
