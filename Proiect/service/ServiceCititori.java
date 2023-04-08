package service;

import java.util.List;
import java.util.Scanner;

import model.Colectii;
import model.Imprumut;
import model.carti.Carte;
import model.carti.CopieCarte;
import model.persoane.*;

public class ServiceCititori {
    public static Scanner scanner = new Scanner(System.in);

    public static void adaugaCititor() {
        String numePrenume = scanner.nextLine();
        Cititor cititorAdaugat = Cititor.cititorDinString(numePrenume, true);
        Colectii.adaugaCititor(cititorAdaugat);
    }

    public static void eliminaCititor() {
        String numePrenume = scanner.nextLine();
        Cititor cititorEliminat = Cititor.cititorDinString(numePrenume, false);
        if (cititorEliminat.equals(new Cititor()))
            System.out.println("Nu a fost gasit un cititor cu acel nume.");
        else
            Colectii.eliminaCititor(cititorEliminat);
    }

    public static void afisareCititori()
    {
        System.out.println("Cititori:");
        for (Cititor cititor : Colectii.getSetCititori())
        {
            System.out.print("   > "); cititor.afisare();
            System.out.println();
        }
        System.out.println();
    }
    public static void afisareCititorInfo() {
        String numePrenume = scanner.nextLine();
        Cititor cititorInfo = Cititor.cititorDinString(numePrenume, false);
        if (cititorInfo.equals(new Cititor()))
            System.out.println("Nu a fost gasit un cititor cu acel nume.");
        else
            cititorInfo.afisareInfo();

        System.out.println();
    }

    // ---------------------------------------------------------------------

    public static void adaugaImprumut() {
        System.out.println("Dati numele si prenumele cititorului ce imprumuta:");
        String numePrenume = scanner.nextLine();
        Cititor cititorImprumut = Cititor.cititorDinString(numePrenume, false);
        if (cititorImprumut.equals(new Cititor()))
        {
            System.out.println("Nu a fost gasit un cititor cu acel nume.");
            return;
        }


        List<Carte> carti = Colectii.getListaCarti();

        System.out.println("Dati numarul de ordine (#) al cartii ce va fi imprumutata:");
        int nrCarte = scanner.nextInt();
        scanner.nextLine();

        System.out.println("CARTEA DORITA");
        carti.get(nrCarte).afisare();

        CopieCarte copieImprumutata = new CopieCarte(new Carte("", new Autor(), -1));
        boolean gasitCopie = false;
        for (CopieCarte copieCarte : Colectii.getSetCopii())
        {
            if (copieCarte.getCarteReferinta().equals(carti.get(nrCarte))) {
                if (!copieCarte.getEsteImprumutata())
                {
                    gasitCopie = true;
                    copieImprumutata = copieCarte;
                    break;
                }
            }
        }

        if (gasitCopie)
            Colectii.adaugaImprumut(new Imprumut(copieImprumutata, cititorImprumut));
        else
            System.out.println("Nu a putut fi gasita o copie valabila pentru acea carte.");
    }

    public static void eliminaImprumut() {
        System.out.println("Dati numele si prenumele cititorului ce a imprumutat o carte:");
        String numePrenume = scanner.nextLine();
        Cititor cititorImprumut = Cititor.cititorDinString(numePrenume, false);
        if (cititorImprumut.equals(new Cititor()))
        {
            System.out.println("Nu a fost gasit un cititor cu acel nume.");
            return;
        }

        List<Carte> carti = Colectii.getListaCarti();

        System.out.println("Dati numarul de ordine (#) al cartii ce a fost imprumutata:");
        int nrCarte = scanner.nextInt();
        scanner.nextLine();

        System.out.println("CARTEA DORITA");
        carti.get(nrCarte).afisare();


        Imprumut imprumutDeSters = new Imprumut(new CopieCarte(new Carte("", new Autor(), -1)), new Cititor());
        boolean gasitImprumut = false;
        for (Imprumut imprumut : Colectii.getSetImprumuturi())
        {
            if (imprumut.getCopieImprumutata().getCarteReferinta().equals(carti.get(nrCarte))) {
                if (imprumut.getCititorActual().equals(cititorImprumut))
                {
                    gasitImprumut = true;
                    imprumutDeSters = imprumut;
                    break;
                }
            }
        }

        if (gasitImprumut)
            Colectii.eliminaImprumut(imprumutDeSters);
        else
            System.out.println("Nu a fost gasit un astfel de imprumut.");

    }

    public static void afisareImprumuturi() {
        for (Imprumut imprumut : Colectii.getSetImprumuturi())
        {
            System.out.println(imprumut.getCititorActual().getNumePrenume() + " a imprumutat o copie a cartii \"" +
                    imprumut.getCopieImprumutata().getCarteReferinta().getTitlu() + "\", de " +
                    imprumut.getCopieImprumutata().getCarteReferinta().getAutor().getNumePrenume() + ".");
        }
    }

}
