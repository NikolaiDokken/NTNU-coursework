package dyrehage;

public class Dyregruppe extends Dyr {

    private final String gruppenavn;
    private int antIndivider;

    public Dyregruppe(String norskNavn, String latNavn, String latFamilie,
                      int ankommetDato, String adresse, String gruppenavn, int antIndivider) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gruppenavn = gruppenavn;
        this.antIndivider = antIndivider;
    }

    public String getGruppenavn() {
        return gruppenavn;
    }

    public int getAntIndivider() {
        return antIndivider;
    }

    public void setAntIndivider(int nyttAntall) {
        this.antIndivider = nyttAntall;
    }

    public String getNorskNavn() {
        return "gruppe av" + super.getNorskNavn();
    }

    public String toString() {
        String print = "";
        print += super.toString() + "\n";
        print += "Informasjon om gruppen:\n";
        print += "Gruppenavn: " + gruppenavn + "\n";
        print += "Antall individer: " + antIndivider;
        return print;
    }
}
