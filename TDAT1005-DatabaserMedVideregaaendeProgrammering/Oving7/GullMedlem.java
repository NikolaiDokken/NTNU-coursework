import java.time.*;

class GullMedlem extends BonusMedlem {
  public GullMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
    super(medlNr, pers, innmeldtDato, poeng);
  }

  @Override
  public void registrerPoeng(int nyePoeng) {
    super.registrerPoeng((int)(nyePoeng * 1.5));
  }
}
