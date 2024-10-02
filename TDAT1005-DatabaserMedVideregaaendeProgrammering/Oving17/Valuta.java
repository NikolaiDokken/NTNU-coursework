public class Valuta {

    private String valutaNavn;
    private double kurs;
    private int enhet;

    public Valuta(String valutaNavn, double kurs, int enhet) {
        this.valutaNavn = valutaNavn;
        this.kurs = kurs;
        this.enhet = enhet;
    }

    public String getValutaNavn() {
        return valutaNavn;
    }

    public double getKurs() {
        return kurs;
    }

    public int getEnhet() {
        return enhet;
    }
}
