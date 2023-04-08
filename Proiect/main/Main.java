package main;

import java.util.Scanner;

import model.Colectii;
import model.persoane.*;
import service.*;

public class Main {

    private static void meniuPrincipal() {

        Scanner scanner = new Scanner(System.in);
        int comanda;

        while (true)
        {
            System.out.println("Dati un input:");
            System.out.println("0 - Exit");
            System.out.println("1 - Autori");
            System.out.println("2 - Cititori");
            System.out.println("3 - Carti");

            comanda = scanner.nextInt();
            scanner.nextLine();

            switch (comanda)
            {
                case 0 -> { return; }
                case 1 -> { meniuAutori(); }
                case 2 -> { meniuCititori(); }
                case 3 -> { meniuCarti(); }
            }
            System.out.println();
        }

    }

    private static void meniuAutori() {

        Scanner scanner = new Scanner(System.in);
        int comanda;

        while (true)
        {
            System.out.println("Dati un input:");
            System.out.println("0 - Inapoi");
            System.out.println("1 - Afisati toti autorii");
            System.out.println("2 - Afisati informatii despre un autor");
            System.out.println("3 - Adaugati un autor");
            System.out.println("4 - Stergeti un autor");

            comanda = scanner.nextInt();
            scanner.nextLine();

            switch (comanda)
            {
                case 0 -> { return; }
                case 1 -> { ServiceAutori.afisareAutori(); }
                case 2 -> { ServiceAutori.afisareAutorInfo(); }
                case 3 -> { ServiceAutori.adaugaAutor(); }
                case 4 -> { ServiceAutori.eliminaAutor(); }
            }
            System.out.println("(Confirmati continuarea programului.)");
            scanner.nextLine();
            System.out.println();
        }

    }

    private static void meniuCititori() {

        Scanner scanner = new Scanner(System.in);
        int comanda;

        while (true)
        {
            System.out.println("Dati un input:");
            System.out.println("0 - Inapoi");
            System.out.println("1 - Afisati toti cititorii");
            System.out.println("2 - Afisati informatii despre un cititor");
            System.out.println("3 - Adaugati un cititor");
            System.out.println("4 - Stergeti un cititor");
            System.out.println("5 - Afisati toate imprumuturile");
            System.out.println("6 - Confirmati un imprumut");
            System.out.println("7 - Confirmati o restituire");

            comanda = scanner.nextInt();
            scanner.nextLine();

            switch (comanda)
            {
                case 0 -> { return; }
                case 1 -> { ServiceCititori.afisareCititori(); }
                case 2 -> { ServiceCititori.afisareCititorInfo(); }
                case 3 -> { ServiceCititori.adaugaCititor(); }
                case 4 -> { ServiceCititori.eliminaCititor(); }
                case 5 -> { ServiceCititori.afisareImprumuturi(); }
                case 6 -> { ServiceCititori.adaugaImprumut(); }
                case 7 -> { ServiceCititori.eliminaImprumut(); }
            }
            System.out.println("(Confirmati continuarea programului.)");
            scanner.nextLine();
            System.out.println();
        }

    }

    private static void meniuCarti() {

        Scanner scanner = new Scanner(System.in);
        int comanda;

        while (true)
        {
            System.out.println("Dati un input:");
            System.out.println("0 - Inapoi");
            System.out.println("1 - Afisati toate cartile");
            System.out.println("2 - Afisati informatii despre o carte");
            System.out.println("3 - Adaugati o carte");
            System.out.println("4 - Stergeti o carte");
            System.out.println("5 - Sortati cartile");
            System.out.println("6 - Afisati toate copiile fizice");
            System.out.println("7 - Adaugati copii fizice ale unei carti");

            comanda = scanner.nextInt();
            scanner.nextLine();

            switch (comanda)
            {
                case 0 -> { return; }
                case 1 -> { ServiceCarti.afisareCarti(); }
                case 2 -> { ServiceCarti.afisareCarteInfo(); }
                case 3 -> { ServiceCarti.adaugaCarte(); }
                case 4 -> { ServiceCarti.eliminaCarte(); }
                case 5 -> { ServiceCarti.sortareCarti(); }
                case 6 -> { ServiceCarti.afisareCopii(); }
                case 7 -> { ServiceCarti.adaugaCopie(); }
            }
            System.out.println("(Confirmati continuarea programului.)");
            scanner.nextLine();
            System.out.println();
        }

    }

    public static void main(String[] args) {

        meniuPrincipal();

    }

}
