package dyrehage;

public class Hunnindivid extends Individ implements SkandinaviskeRovdyr {
    private int antKull;

    public Hunnindivid(String norskNavn, String latNavn, String latFamilie,
                       int ankommetDato, String adresse, String navn, int fDato,
                       boolean farlig, int antKull) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, false, farlig);
        this.antKull = antKull;
    }

    public int getAntKull() {
        return antKull;
    }

    public void leggTilKull(int nyttAnt) {
        this.antKull += nyttAnt;
    }

    public void leggTilNyttKull() {
        this.antKull++;
    }

    public String toString() {
        String print = "";
        print += super.toString();
        print += "\nAntall kull: " + antKull;
        return print;
    }
}
