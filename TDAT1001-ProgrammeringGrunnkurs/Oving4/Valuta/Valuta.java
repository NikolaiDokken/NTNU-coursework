class Valuta {
  // Objektvariabler
  private String navn;
  private double kurs;

  // Konstruktør
  public Valuta(String navn, double kurs) {
    this.navn = navn;
    this.kurs = kurs;
  }

  // Metoder

  // get-metode
  public String getNavn() {
    return navn;
  }

  // set-metode
  public void setKurs(double nyKurs) {
    kurs = nyKurs;
  }

  // Omregning til og fra NOK
  public double fraNorskeKroner(double norskeKroner) {
    return norskeKroner / kurs;
  }

  public double tilNorskeKroner(double utenlandskeKroner) {
    return utenlandskeKroner*kurs;
  }
}
