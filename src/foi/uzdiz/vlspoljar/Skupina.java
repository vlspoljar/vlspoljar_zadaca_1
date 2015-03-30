package foi.uzdiz.vlspoljar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Skupina {

    private Natjecatelj referentniNatjecatelj;

    private List<Natjecatelj> natjecatelji = new LinkedList<Natjecatelj>();
    private List<Utrka> utrke = new LinkedList<Utrka>();
    private int pocetniRedniBroj = 1;

    public Skupina(Natjecatelj referentniNatjecatelj) {
        this.referentniNatjecatelj = referentniNatjecatelj;

        klonirajReferentni();
    }

    private void klonirajReferentni() {
        int maxNatjecatelja = Natjecanje.getInstance().getPostavkeNatjecanja()
                .getMaxBrojNatjecateljaPoSkupini();

        for (int i = 0; i < maxNatjecatelja; i++) {
            natjecatelji.add((Natjecatelj) referentniNatjecatelj.kloniraj());
        }

    }

    public int trci() {
        int i = pocetniRedniBroj;
        Utrka utrka = new Utrka();
        for (Natjecatelj natjecatelj : natjecatelji) {
            if (new Random().nextBoolean()) {
                utrka.dodajNatjecatelja(natjecatelj, i++);
            }
        }

        utrka.generirajRezultate();

        utrke.add(utrka);

        return i;
    }

    public int getPocetniRedniBroj() {
        return pocetniRedniBroj;
    }

    public void setPocetniRedniBroj(int pocetniRedniBroj) {
        this.pocetniRedniBroj = pocetniRedniBroj;
    }

    public String prikaziStanje() {
        String skupine = "Skupina: " + getReferentniNatjecatelj().getSpol() + "" + getReferentniNatjecatelj().getGodiste() + "\n";
        Collections.sort(natjecatelji);

        for (Natjecatelj natjecatelj : natjecatelji) {
            skupine += natjecatelj + "\n";
        }

        return skupine;
    }

    public Natjecatelj getReferentniNatjecatelj() {
        return referentniNatjecatelj;
    }

    public List<Utrka> getUtrke() {
        return utrke;
    }

    public List<Natjecatelj> getNatjecatelji() {
        return natjecatelji;
    }

}
