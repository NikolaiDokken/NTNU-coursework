package dyrehage;

public abstract class Individ extends Dyr implements SkandinaviskeRovdyr {
    private final String navn;
    private final int fDato;
    private final boolean hanndyr;
    private final boolean farlig;


    public Individ(String norskNavn, String latNavn, String latFamilie,
                   int ankommetDato, String adresse, String navn, int fDato, boolean hanndyr, boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
    }

    public String getNavn() {
        return navn;
    }

    public int getFdato() {
        return fDato;
    }

    public int getAlder() {
        return 2019 - fDato;
    }

    public String getAdresse() {
        return super.getAdresse();
    }

    public void flytt(String nyAdresse) {
        super.setAdresse(nyAdresse);
    }

    public boolean getHanndyr() {
        return hanndyr;
    }

    public boolean getFarlig() {
        return farlig;
    }

    public String skrivUtInfo() {
        String print = "";
        print += super.toString();
        print += "\nInformasjon om individet:\nNavn: " + navn;
        print += "\nFodselsdato: " + fDato;
        print += "\nKjonn: " + (hanndyr ? "hann" : "hunn");
        print += "\nFarlig: " + (farlig ? "Ja" : "Nei");
        return print;
    }



}
