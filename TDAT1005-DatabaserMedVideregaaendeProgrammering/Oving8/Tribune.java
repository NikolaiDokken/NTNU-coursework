import java.io.*;

abstract class Tribune implements Serializable {
  private final String tribunenavn;
  private final int kapasitet;
  private final int pris;

  public Tribune(String tribunenavn, int kapasitet, int pris) {
    if (tribunenavn == null) {
      throw new IllegalArgumentException("Tribune må ha et navn");
    }
    this.tribunenavn = tribunenavn.trim();
    this.kapasitet = kapasitet;
    this.pris = pris;
  }

  public int getKapasitet() {
    return kapasitet;
  }

  public int getPris() {
    return pris;
  }

  public String getTribuneNavn() {
    return tribunenavn;
  }

  public abstract int finnAntallSolgtBilletter();

  public abstract int finnInntekt();

  public abstract Billett[] kjopBilletter(int antBilletter);

  public abstract Billett[] kjopBilletter(String[] navn);

  public abstract String toString();

}
