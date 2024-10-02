class VIP extends Sitte {
  private String[][] tilskuer; // tabellstørrelse: antall rader * antall plasser pr rad
  private int[] antOpptatt;


  public VIP(String tribunenavn, int kapasitet, int antallRader, int pris) {
    super(tribunenavn, kapasitet, antallRader, pris);
    this.antOpptatt = super.getAntallOpptatt();
    this.tilskuer = new String[super.getAntallRader()][super.getSeterPrRad()];
  }


  public int finnAntallSolgtBilletter() {
    int sum = 0;
    for (String[] opptatt: tilskuer) {
      for (String s: opptatt) {
        if (s != null) {
          sum++;
        }
      }
    }
    return sum;
  }

  public int finnInntekt() {
    return super.getPris() * finnAntallSolgtBilletter();
  }

  public Billett[] kjopBilletter(int antBilletter) {
    return null;
  }

  public Billett[] kjopBilletter(String[] navn) {
    int antBilletter = navn.length;
    boolean ledig = false;
    int rad = 0;
    int sete = 0;
    for (int i = 0; i < antOpptatt.length; i++) {
      if (antBilletter < (getSeterPrRad() - super.getAntallOpptatt()[i])) {
        ledig = true;
        rad = i;
        sete = (antOpptatt[i] + 1);
      }
    }
    Billett[] billetter = new Billett[antBilletter];
    if (!ledig) {
      return billetter;
    }
    for (int i = 0; i < billetter.length; i++) {
      billetter[i] = new SitteplassBillett(super.getTribuneNavn(), super.getPris(), rad, sete);
      tilskuer[rad][sete] = navn[i];
      sete++;
      super.inkrementerIndeks(i);
    }
    return billetter;
  }

  public String toString() {
    String utskrift = "";
    utskrift += super.getTribuneNavn() + ". kapasitet: " + super.getKapasitet() + ". Solgt " + finnAntallSolgtBilletter() + " billetter for " + finnInntekt();
    return utskrift;
  }
}
