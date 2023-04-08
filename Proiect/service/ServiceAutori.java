package service;

import java.util.Scanner;

import model.Colectii;
import model.persoane.*;

public class ServiceAutori {
    public static Scanner scanner = new Scanner(System.in);

    public static void adaugaAutor() {
        String numePrenume = scanner.nextLine();
        Autor autorAdaugat = Autor.autorDinString(numePrenume, true);
        Colectii.adaugaAutor(autorAdaugat);
    }

    public static void eliminaAutor() {
        String numePrenume = scanner.nextLine();
        Autor autorEliminat = Autor.autorDinString(numePrenume, false);
        if (autorEliminat.equals(new Autor()))
            System.out.println("Nu a fost gasit un autor cu acel nume.");
        else
            Colectii.eliminaAutor(autorEliminat);
    }

    public static void afisareAutori()
    {
        System.out.println("Autori:");
        for (Autor autor : Colectii.getSetAutori())
        {
            System.out.print("   > "); autor.afisare();
            System.out.println();
        }
        System.out.println();
    }
    public static void afisareAutorInfo() {
        String numePrenume = scanner.nextLine();
        Autor autorInfo = Autor.autorDinString(numePrenume, false);
        if (autorInfo.equals(new Autor()))
            System.out.println("Nu a fost gasit un autor cu acel nume.");
        else
            autorInfo.afisareInfo();
    }
}
