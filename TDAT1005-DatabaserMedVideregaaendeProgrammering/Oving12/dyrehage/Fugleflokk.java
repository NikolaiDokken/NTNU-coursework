package dyrehage;

public class Fugleflokk extends Dyregruppe {

    private final int gjennomsnittligVekt;
    private final boolean svommer;

    public Fugleflokk(String norskNavn, String latNavn, String latFamilie,
                      int ankommetDato, String adresse, String gruppenavn, int antIndivider,
                      int gjennomsnittligVekt, boolean svommer) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn, antIndivider);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svommer = svommer;
    }

    public int getGjennomsnittligVekt() {
        return gjennomsnittligVekt;
    }

    public boolean getSvommer() {
        return svommer;
    }

    @Override
    public String toString() {
        return super.toString()  + "Informasjon om dyrehage.Fugleflokk:\n" +
                "Gjennomsnittlig vekt:" + gjennomsnittligVekt +
                "\nSvommer: " + (svommer ? "Ja" : "Nei");
    }
}
