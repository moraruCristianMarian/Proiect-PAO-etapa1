package service;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

import model.Colectii;
import model.carti.*;
import model.comparators.ComparatorCarteNrPagini;
import model.comparators.ComparatorCarteTitlu;
import model.persoane.Autor;

public class ServiceCarti {
    public static Scanner scanner = new Scanner(System.in);

    public record CarteRec(String titlu, Autor autor, int nrPagini) {};


    // Folosit de celelalte metode "adauga"
    private static CarteRec adaugaBase() {

        System.out.print("Titlu: ");
        String titlu = scanner.nextLine();

        System.out.print("Autor: ");
        String autorNumePrenume = scanner.nextLine();
        Autor autor = Autor.autorDinString(autorNumePrenume, true);

        System.out.print("Nr. pagini: ");
        int nrPagini = scanner.nextInt();

        scanner.nextLine();

        return new CarteRec(titlu, autor, nrPagini);
    }



    public static void adaugaCarte() {

        System.out.println("Dati un input:");
        System.out.println("0 - Anulati adaugarea");
        System.out.println("1 - Adaugare manual");
        System.out.println("2 - Adaugare carte de poezii");
        System.out.println("3 - Adaugare carte stiintifico-fantastica");

        int tipCarte = scanner.nextInt();
        scanner.nextLine();

        switch (tipCarte)
        {
            case 0 -> {
                return;
            }
            case 1 -> {
                adaugaManual();
            }
            case 2 -> {
                adaugaPoezii();
            }
            case 3 -> {
                adaugaSF();
            }
        }
    }

    private static void adaugaManual() {

        CarteRec baseCarte = ServiceCarti.adaugaBase();

        System.out.print("Materie: ");
        String materie = scanner.nextLine();

        System.out.print("Clasa: ");
        int clasa = scanner.nextInt();

        scanner.nextLine();

        CarteManual manual = new CarteManual(baseCarte.titlu, baseCarte.autor, baseCarte.nrPagini, materie, clasa);
        Colectii.adaugaCarte(manual);
    }

    private static void adaugaSF() {

        CarteRec baseCarte = ServiceCarti.adaugaBase();

        System.out.print("Rating: ");
        double rating = scanner.nextDouble();

        scanner.nextLine();

        CarteSF carteSF = new CarteSF(baseCarte.titlu, baseCarte.autor, baseCarte.nrPagini, rating);
        Colectii.adaugaCarte(carteSF);
    }

    private static void adaugaPoezii() {

        CarteRec baseCarte = ServiceCarti.adaugaBase();

        System.out.print("Numar de poezii: ");
        int nrPoezii = scanner.nextInt();

        scanner.nextLine();

        CartePoezii cartePoezii = new CartePoezii(baseCarte.titlu, baseCarte.autor, baseCarte.nrPagini, nrPoezii);
        Colectii.adaugaCarte(cartePoezii);
    }


    public static void eliminaCarte() {
        System.out.println("Dati titlul cartii/cartilor de sters:");
        String titluCarte = scanner.nextLine();

        List<Carte> cartiDeSters = new ArrayList<Carte>();
        int nrCartiSterse = 0;
        for (Carte carte : Colectii.getListaCarti())
        {
            if (carte.getTitlu().equals(titluCarte))
            {
                cartiDeSters.add(carte);
                nrCartiSterse += 1;
            }
        }
        if (nrCartiSterse != 0) {
            System.out.println("Au fost sterse " + nrCartiSterse + " carti.");
            for (Carte carte : cartiDeSters)
                carte.getAutor().eliminaPublicare(carte);
            Colectii.getListaCarti().removeAll(cartiDeSters);
        }
        else
            System.out.println("Nu a fost gasita nicio carte cu acel titlu.");
    }


    public static void afisareCarti() {
        List<Carte> carti = Colectii.getListaCarti();

        System.out.println("=== CARTI ===");
        for (int i = 0; i < carti.size(); i++)
            System.out.println("   #" + i + " - " + carti.get(i).getTitlu());
    }

    public static void afisareCarteInfo() {
        System.out.println("Dati titlul cartii/cartilor pentru informatii in plus:");
        String titluCarte = scanner.nextLine();

        for (Carte carte : Colectii.getListaCarti())
        {
            if (carte.getTitlu().equals(titluCarte))
            {
                carte.afisare();
                System.out.println();
            }
        }
    }

    // ------------------------------------------------------------------

    public static void adaugaCopie() {
        List<Carte> carti = Colectii.getListaCarti();

        System.out.println("Dati numarul de ordine (#) al cartii dorite:");
        int nrCarte = scanner.nextInt();
        scanner.nextLine();

        System.out.println("CARTEA DORITA");
        carti.get(nrCarte).afisare();

        System.out.println("Dati numarul de copii fizice al acestei carti ce va fi creat:");
        int nrCopii = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nrCopii; i++)
            Colectii.adaugaCopie(new CopieCarte(carti.get(nrCarte)));
    }

    public static void afisareCopii() {
        System.out.println("=== COPII ALE CARTILOR ===");
        for (CopieCarte copie : Colectii.getSetCopii())
        {
            copie.afisare();
            System.out.println();
        }
    }

    // ----------------------------------------------------------

    public static void sortareCarti() {
        System.out.println("Dati criteriul de sortare:");
        System.out.println("0 - Anulati");
        System.out.println("1 - Titlu");
        System.out.println("2 - Nr. de pagini");

        int criteriu = scanner.nextInt();
        scanner.nextLine();

        switch (criteriu)
        {
            case 0 -> {
                return;
            }
            case 1 -> {
                ComparatorCarteTitlu crit = new ComparatorCarteTitlu();
                Colectii.sortareCarti(crit);
            }
            case 2 -> {
                ComparatorCarteNrPagini crit = new ComparatorCarteNrPagini();
                Colectii.sortareCarti(crit);
            }
        }
    }
}
