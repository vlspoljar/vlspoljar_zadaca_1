package foi.uzdiz.vlspoljar;

public class Client {

    public static void main(String[] args) {

        Natjecanje natjecanje = Natjecanje.getInstance();

        PostavkeNatjecanja postavkeNatjecanja = new PostavkeNatjecanja(
                Integer.valueOf(args[0]),
                Integer.valueOf(args[1]),
                Integer.valueOf(args[2]),
                args[3]);

        natjecanje.setPostavkeNatjecanja(postavkeNatjecanja);

        natjecanje.zapoceniNatjecanje();

    }

}
