import java.time.*;

class BonusMedlem {
  private final int medlNr;
  private final Personalia pers;
  private final LocalDate innmeldtDato;
  private int poeng = 0;

  public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
    this.medlNr = medlNr;
    this.pers = pers;
    this.innmeldtDato = innmeldtDato;
    this.poeng = poeng;
  }

  // get-metoder
  public int getMedlNr() {
    return medlNr;
  }

  public Personalia getPersonalia() {
    return pers;
  }

  public LocalDate getInnmeldt() {
    return innmeldtDato;
  }

  public int getPoeng() {
    return poeng;
  }

  public int finnKvalPoeng(LocalDate date1) {
    int arMellom = Period.between(innmeldtDato, date1).getYears();
    int dagerMellom = Period.between(innmeldtDato, date1).getDays();
    dagerMellom += arMellom * 365;
    if (dagerMellom < 365) {
      return poeng;
    }
    return 0;
  }

  public boolean okPassord(String passord) {
    return pers.okPassord(passord);
  }

  public void registrerPoeng(int poeng) {
    this.poeng += poeng;
  }
}
