package model.comparators;

import model.carti.Carte;

import java.util.Comparator;
public class ComparatorCarteTitlu implements Comparator<Carte> {

    @Override
    public int compare(Carte c1, Carte c2) {
        return c1.getTitlu().compareTo(c2.getTitlu());
    }

}
