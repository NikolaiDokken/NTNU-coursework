class Sitte extends Tribune {
  private int[] antOpptatt;  // tabellstørrelse: antall rader
  private int antallRader;

  public Sitte(String tribunenavn, int kapasitet, int antallRader, int pris) {
    super(tribunenavn, kapasitet, pris);
    this.antallRader = antallRader;
    this.antOpptatt = new int[antallRader];
  }
  public int getAntallRader() {
    return antallRader;
  }

  public int getSeterPrRad() {
    return super.getKapasitet() / antallRader;
  }

  public int[] getAntallOpptatt() {
    return antOpptatt;
  }

  public void inkrementerIndeks(int indeks) {
    antOpptatt[indeks]++;
  }

  public int finnAntallSolgtBilletter() {
    int sum = 0;
    for (int opptatt: antOpptatt) {
      sum += opptatt;
    }
    return sum;
  }

  public int finnInntekt() {
    return super.getPris() * finnAntallSolgtBilletter();
  }

  public Billett[] kjopBilletter(int antBilletter) {
    boolean ledig = false;
    int rad = 0;
    int sete = 0;
    for (int i = 0; i < antOpptatt.length; i++) {
      if (antBilletter < (getSeterPrRad() - antOpptatt[i])) {
        ledig = true;
        rad = i;
        sete = (antOpptatt[i] + 1);
        break;
      }
    }
    Billett[] billetter = new Billett[antBilletter];
    if (!ledig) {
      return billetter;
    }
    for (int i = 0; i < billetter.length; i++) {
      billetter[i] = new SitteplassBillett(super.getTribuneNavn(), super.getPris(), rad, sete);
      sete++;
      antOpptatt[rad]++;
    }
    return billetter;
  }

  public Billett[] kjopBilletter(String[] navn) {
    int antBilletter = navn.length;
    boolean ledig = false;
    int rad = 0;
    int sete = 0;
    for (int i = 0; i < antOpptatt.length; i++) {
      if (antBilletter < (getSeterPrRad() - antOpptatt[i])) {
        ledig = true;
        rad = i;
        sete = (antOpptatt[i] + 1);
        break;
      }
    }
    Billett[] billetter = new Billett[antBilletter];
    if (!ledig) {
      return billetter;
    }
    for (int i = 0; i < billetter.length; i++) {
      billetter[i] = new SitteplassBillett(super.getTribuneNavn(), super.getPris(), rad, sete);
      sete++;
      antOpptatt[rad]++;
    }
    return billetter;
  }

  public String toString() {
    String utskrift = "";
    utskrift += super.getTribuneNavn() + ". Kapasitet: " + super.getKapasitet() + ". Solgt " + finnAntallSolgtBilletter() + " billetter for " + finnInntekt();
    return utskrift;
  }
}
