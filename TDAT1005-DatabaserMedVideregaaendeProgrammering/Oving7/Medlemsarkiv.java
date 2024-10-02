import java.util.Random;
import java.util.ArrayList;
import java.time.*;

class Medlemsarkiv {
  private ArrayList<BonusMedlem> medlemmer;

  public Medlemsarkiv() {
    this.medlemmer = new ArrayList<BonusMedlem>();
  }

  public int finnPoeng(int medlNr, String passord) {
    // Sjekker om et medlem med dette nummeret eksisterer
    BonusMedlem temp = null;
    for (BonusMedlem medlem: medlemmer) {
      if (medlNr == medlem.getMedlNr()) {
        if (medlem.okPassord(passord)) {
          return medlem.getPoeng();
        }
      }
    }
    return -1;
  }

  public boolean registrerPoeng(int medlNr, int poeng) {
    // Sjekker om et medlem med dette nummeret eksisterer
    for (BonusMedlem medlem: medlemmer) {
      if (medlNr == medlem.getMedlNr()) {
        medlem.registrerPoeng(poeng);
        return true;
      }
    }
    return false;
  }

  public int nyMedlem(Personalia pers, LocalDate innmeldt) {
    BasicMedlem temp = new BasicMedlem(finnLedigNr(), pers, innmeldt);
    medlemmer.add(temp);
    return temp.getMedlNr();
  }

  public boolean sjekkMedlemmer() {
    LocalDate current = LocalDate.now();
    BonusMedlem bm = null;
    for (int i = 0; i < medlemmer.size(); i++) {
      int tempPoeng = medlemmer.get(i).finnKvalPoeng(current);
      bm = medlemmer.get(i);
      if (tempPoeng >= 75000 && (bm instanceof SoelvMedlem || bm instanceof BasicMedlem)) {
        medlemmer.set(i, new GullMedlem(bm.getMedlNr(), bm.getPersonalia(), bm.getInnmeldt(), bm.getPoeng()));
      } else if (bm instanceof BasicMedlem && tempPoeng > 25000) {
        medlemmer.set(i, new SoelvMedlem(bm.getMedlNr(), bm.getPersonalia(), bm.getInnmeldt(), bm.getPoeng()));
      }
    }
    return true;
  }


  private int finnLedigNr() {
    Random rand = new Random();
    boolean funnet = true;
    int nyttMedlNr;
    do {
      nyttMedlNr = rand.nextInt(10000);
      funnet = false;
      for (BonusMedlem medlem: medlemmer) {
        if (medlem.getMedlNr() == nyttMedlNr) {
          funnet = true;
        }
      }
    } while (funnet);
    return nyttMedlNr;
  }

  public BonusMedlem getMedlem(int indeks) {
    return medlemmer.get(indeks);
  }

}
