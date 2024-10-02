import java.time.*;

class SoelvMedlem extends BonusMedlem {
  public SoelvMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
    super(medlNr, pers, innmeldtDato, poeng);
  }

  @Override
  public void registrerPoeng(int nyePoeng) {
    super.registrerPoeng((int)(nyePoeng * 1.2));
  }
}
