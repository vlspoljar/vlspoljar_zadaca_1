package foi.uzdiz.vlspoljar;

import foi.uzdiz.vlspoljar.Natjecatelj.Spol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Natjecanje {

    private static Natjecanje uniqueInstance;
    private PostavkeNatjecanja postavkeNatjecanja;
    private List<Skupina> skupine = new LinkedList<Skupina>();
    private File file;
    private String sadrzaj = "Rezultati: \n";
    private int brojUtrka;

    private Natjecanje() {
    }

    public static Natjecanje getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Natjecanje();
        }
        return uniqueInstance;
    }

    public void zapoceniNatjecanje() {
        generirajSkupine();
        zapocniNatjecanje();
    }

    private void generirajSkupine() {
        skupine.add(new Skupina(new Natjecatelj(14, Spol.M)));
        skupine.add(new Skupina(new Natjecatelj(18, Spol.M)));
        skupine.add(new Skupina(new Natjecatelj(25, Spol.M)));
        skupine.add(new Skupina(new Natjecatelj(35, Spol.M)));
        skupine.add(new Skupina(new Natjecatelj(45, Spol.M)));
        skupine.add(new Skupina(new Natjecatelj(99, Spol.M)));
        skupine.add(new Skupina(new Natjecatelj(14, Spol.Z)));
        skupine.add(new Skupina(new Natjecatelj(18, Spol.Z)));
        skupine.add(new Skupina(new Natjecatelj(25, Spol.Z)));
        skupine.add(new Skupina(new Natjecatelj(35, Spol.Z)));
        skupine.add(new Skupina(new Natjecatelj(45, Spol.Z)));
        skupine.add(new Skupina(new Natjecatelj(99, Spol.Z)));

        int i = 1;
        for (Skupina skupina : skupine) {
            for (Natjecatelj natjecatelj : skupina.getNatjecatelji()) {
                natjecatelj.setId(i++);
            }
        }
    }

    private void zapocniNatjecanje() {

        Random rand = new Random();
        brojUtrka = rand.nextInt((postavkeNatjecanja.getMaxBrojUtrka() - 1) + 1) + 1;

        for (int i = 0; i < brojUtrka; i++) {

            int redniBroj = 1;

            for (Skupina skupina : skupine) {
                skupina.setPocetniRedniBroj(redniBroj);
                redniBroj = skupina.trci();
            }

            if (postavkeNatjecanja.getPauzaNakonUtrke() == 1) {
                try {
                    Thread.sleep(1000);
                    System.out.println("");
                    System.out.println("------------------------------------ UTRKA - " + i + "-----------------------------------");
                    ispisiRezulatatePoSkupinama();
                    ispisiRezulatate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        if (postavkeNatjecanja.getPauzaNakonUtrke() == 0) {

            ispisiRezulatatePoSkupinama();
            ispisiIzbornik();

        }

        zapisiUDatoteku();
    }

    private void ispisiRezulatatePoSkupinama() {
        for (Skupina skupina : skupine) {
            System.out.println("");
            System.out.println(skupina.prikaziStanje());
        }

    }

    private void ispisiRezulatate() {
        for (Skupina skupina : skupine) {
            for (Utrka utrka : skupina.getUtrke()) {
                System.out.println("");
                for (Rezultat rezultat : utrka.getRezultati()) {
                    System.out.println(rezultat);
                }
            }
        }
    }

    public void zapisiUDatoteku() {
        String path;
        try {
            path = new File(".").getCanonicalPath() + "\\" + postavkeNatjecanja.getDatotekaRezultata();
            file = new File(path);
            file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            String rezultati = "";
            for (Skupina skupina : skupine) {
                for (Utrka utrka : skupina.getUtrke()) {
                    for (Rezultat rezultat : utrka.getRezultati()) {
                        rezultati += rezultat.toString() + "\n";
                    }
                }
            }
            sadrzaj += rezultati;

            String sveSkupine = "";
            for (Skupina skupina : skupine) {
                sveSkupine += skupina.prikaziStanje() + "\n";
            }
            sadrzaj += "\n\nSkupine:\n";
            sadrzaj += sveSkupine;

            bw.write(sadrzaj);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void ispisiIzbornik() {
        System.out.println("______________________________________________");
        System.out.println("Unesite broj utrke (izmedu 1 i " + brojUtrka + "): ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int selectedValue = 0;
        try {
            selectedValue = Integer.valueOf(br.readLine());
        } catch (NumberFormatException e) {
            return;
        } catch (IOException e) {
            return;
        }

        for (Skupina s : skupine) {
            Utrka utrka = s.getUtrke().get(selectedValue - 1);
            Collections.sort(utrka.getRezultati());
            for (Rezultat rezultat : utrka.getRezultati()) {
                System.out.println(rezultat);
            }
        }
    }

    public PostavkeNatjecanja getPostavkeNatjecanja() {
        return postavkeNatjecanja;
    }

    public void setPostavkeNatjecanja(PostavkeNatjecanja postavkeNatjecanja) {
        this.postavkeNatjecanja = postavkeNatjecanja;
    }

}
