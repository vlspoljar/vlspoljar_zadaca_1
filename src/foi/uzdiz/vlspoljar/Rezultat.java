package foi.uzdiz.vlspoljar;

public class Rezultat implements Comparable<Rezultat> {

    private Natjecatelj natjecatelj;
    private int redniBroj;
    private int vrijeme;
    private int brojBodova;
    private boolean diskvalificiran = false;

    public Rezultat(Natjecatelj natjecatelj, int redniBroj) {
        this.natjecatelj = natjecatelj;
        this.redniBroj = redniBroj;
    }

    public Natjecatelj getNatjecatelj() {
        return natjecatelj;
    }

    public void setNatjecatelj(Natjecatelj natjecatelj) {
        this.natjecatelj = natjecatelj;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(int vrijeme) {
        this.vrijeme = vrijeme;
    }

    public int getBrojBodova() {
        return brojBodova;
    }

    public void setBrojBodova(int brojBodova) {
        this.brojBodova = brojBodova;
    }

    public boolean isDiskvalificiran() {
        return diskvalificiran;
    }

    public void setDiskvalificiran(boolean diskvalificiran) {
        this.diskvalificiran = diskvalificiran;
    }

    @Override
    public String toString() {
        return "Rezultat [natjecatelj=" + natjecatelj + ", redniBroj="
                + redniBroj + ", vrijeme=" + vrijeme + ", brojBodova="
                + brojBodova + ", diskvalificiran=" + diskvalificiran + "]";
    }

    @Override
    public int compareTo(Rezultat rezultat) {
        int compare = rezultat.getVrijeme();
        return vrijeme - compare;
    }

}
