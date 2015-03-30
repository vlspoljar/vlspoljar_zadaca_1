package foi.uzdiz.vlspoljar;

public class Natjecatelj implements IClonable, Comparable<Natjecatelj> {

    public enum Spol {

        M, Z;
    };

    private String id;
    private int godiste;
    private Spol spol;
    private int ukupanBrojBodova = 0;

    public Natjecatelj() {

    }

    public Natjecatelj(int godiste, Spol spol) {
        this.godiste = godiste;
        this.spol = spol;
    }

    public Natjecatelj(String id, int godiste, Spol spol) {
        this.id = id;
        this.godiste = godiste;
        this.spol = spol;
    }

    private Natjecatelj(Natjecatelj n) {
        this.godiste = n.getGodiste();
        this.spol = n.getSpol();
    }

    public String getId() {
        return id;
    }

    public void setId(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(getSpol());
        sb.append(getGodiste());
        sb.append(":");
        sb.append(i);

        id = sb.toString();
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public Spol getSpol() {
        return spol;
    }

    public void setSpol(Spol spol) {
        this.spol = spol;
    }

    @Override
    public Object kloniraj() {
        return new Natjecatelj((Natjecatelj) this);
    }

    @Override
    public String toString() {
        return "Natjecatelj [id=" + id + ", godiste=" + godiste + ", spol="
                + spol + ", ukupanBrojBodova=" + ukupanBrojBodova + "]";
    }

    public int getUkupanBrojBodova() {
        return ukupanBrojBodova;
    }

    public void setUkupanBrojBodova(int ukupanBrojBodova) {
        this.ukupanBrojBodova = ukupanBrojBodova;
    }

    public void dodajBodove(int zaradenoBodova) {
        ukupanBrojBodova += zaradenoBodova;

    }

    @Override
    public int compareTo(Natjecatelj natjecatelj) {
        int compare = natjecatelj.getUkupanBrojBodova();
        return (compare - this.ukupanBrojBodova);
    }

}
