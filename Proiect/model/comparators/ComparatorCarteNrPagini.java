package model.comparators;

import model.carti.Carte;

import java.util.Comparator;
public class ComparatorCarteNrPagini implements Comparator<Carte> {

    @Override
    public int compare(Carte c1, Carte c2) {
        return c1.getNrPagini() - c2.getNrPagini();
    }

}
