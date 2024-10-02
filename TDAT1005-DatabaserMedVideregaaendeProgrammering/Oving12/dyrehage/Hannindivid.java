package dyrehage;

public class Hannindivid extends Individ implements SkandinaviskeRovdyr {

    public Hannindivid(String norskNavn, String latNavn, String latFamilie,
                       int ankommetDato, String adresse, String navn, int fDato,
                       boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, true, farlig);
    }

    public int getAntKull() {
        return 0;
    }

    public void leggTilKull(int nyttAntall) {
    }

    public void leggTilNyttKull() {
    }

    public String toString() {
        return super.toString();
    }
}
