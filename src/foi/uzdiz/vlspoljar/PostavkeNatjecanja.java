package foi.uzdiz.vlspoljar;

public class PostavkeNatjecanja {

    private int maxBrojUtrka;
    private int maxBrojNatjecateljaPoSkupini;
    private int pauzaNakonUtrke;
    private String datotekaRezultata;

    public PostavkeNatjecanja(int maxBrojUtrka,
            int maxBrojNatjecateljaPoSkupini, int pauzaNakonUtrke,
            String datotekaRezultata) {

        this.maxBrojUtrka = maxBrojUtrka;
        this.maxBrojNatjecateljaPoSkupini = maxBrojNatjecateljaPoSkupini;
        this.pauzaNakonUtrke = pauzaNakonUtrke;
        this.datotekaRezultata = datotekaRezultata;
    }

    public int getMaxBrojUtrka() {
        return maxBrojUtrka;
    }

    public void setMaxBrojUtrka(int maxBrojUtrka) {
        this.maxBrojUtrka = maxBrojUtrka;
    }

    public int getMaxBrojNatjecateljaPoSkupini() {
        return maxBrojNatjecateljaPoSkupini;
    }

    public void setMaxBrojNatjecateljaPoSkupini(int maxBrojNatjecateljaPoSkupini) {
        this.maxBrojNatjecateljaPoSkupini = maxBrojNatjecateljaPoSkupini;
    }

    public int getPauzaNakonUtrke() {
        return pauzaNakonUtrke;
    }

    public void setPauzaNakonUtrke(int pauzaNakonUtrke) {
        this.pauzaNakonUtrke = pauzaNakonUtrke;
    }

    public String getDatotekaRezultata() {
        return datotekaRezultata;
    }

    public void setDatotekaRezultata(String datotekaRezultata) {
        this.datotekaRezultata = datotekaRezultata;
    }

}
