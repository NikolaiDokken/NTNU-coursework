package dyrehage;

public class Rovdyrfabrikk {
    public SkandinaviskeRovdyr nyBinne(int ankommetDato, String adresse, String navn, int fDato, int antallKull) {
        return new Hunnindivid("Brunbjørn", "Ursus arctos", "Ursidae",
                ankommetDato, adresse, navn, fDato, true, antallKull);
    }

    public SkandinaviskeRovdyr nyHannbjorn(int ankommetDato, String adresse, String navn, int fDato) {
        return new Hannindivid("Brunbjørn", "Ursus arctos", "Ursidae",
                ankommetDato, adresse, navn, fDato, true);
    }

    public SkandinaviskeRovdyr nyUlvetispe(int ankommetDato, String adresse, String navn, int fDato, int antallKull) {
        return new Hunnindivid("Ulv", "Canis lupus", "Canidae",
                ankommetDato, adresse, navn, fDato, true, antallKull);
    }

    public SkandinaviskeRovdyr nyUlvehann(int ankommetDato, String adresse, String navn, int fDato) {
        return new Hannindivid("Ulv", "Canis lupus", "Canidae",
                ankommetDato, adresse, navn, fDato, true);
    }
}
