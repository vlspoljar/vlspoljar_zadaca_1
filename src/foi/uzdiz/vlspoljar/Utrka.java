package foi.uzdiz.vlspoljar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Utrka {

    private List<Rezultat> rezultati = new LinkedList<Rezultat>();

    public void dodajNatjecatelja(Natjecatelj n, int redniBroj) {
        rezultati.add(new Rezultat(n, redniBroj));
    }

    public void generirajRezultate() {
        Random rand = new Random();
        for (Rezultat rezultat : rezultati) {
            int randomNum = rand.nextInt((1000 - 1) + 1) + 1;
            rezultat.setVrijeme(randomNum);

        }

        Collections.sort(rezultati);

        int i = 1;
        for (Rezultat rezultat : rezultati) {
            if (rezultat.getVrijeme() < 100) {
                rezultat.setDiskvalificiran(true);
            } else {
                int zaradenoBodova = izracunajBodove(i++);
                rezultat.setBrojBodova(zaradenoBodova);
                rezultat.getNatjecatelj().dodajBodove(zaradenoBodova);
            }

        }

    }

    public int izracunajBodove(int mjesto) {
        switch (mjesto) {
            case 1:
                return 25;
            case 2:
                return 20;
            case 3:
                return 15;
            case 4:
                return 12;
            case 5:
                return 10;
            case 6:
                return 8;
            case 7:
                return 6;
            case 8:
                return 4;
            case 9:
                return 2;
            case 10:
                return 1;

            default:
                return 0;
        }
    }

    public List<Rezultat> getRezultati() {
        return rezultati;
    }

}
