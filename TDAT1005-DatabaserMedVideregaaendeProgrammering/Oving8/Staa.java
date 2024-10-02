class Staa extends Tribune {
  private int antSolgteBilletter;

  public Staa(String tribunenavn, int kapasitet, int pris) {
    super(tribunenavn, kapasitet, pris);
    this.antSolgteBilletter = 0;
  }

  public int finnAntallSolgtBilletter() {
    return antSolgteBilletter;
  }

  public int finnInntekt() {
    return super.getPris() * finnAntallSolgtBilletter();
  }

  public Billett[] kjopBilletter(int antBilletter) {
    Billett[] billetter = new Billett[antBilletter];
    if (antBilletter > (super.getKapasitet() - antSolgteBilletter)) {
      return billetter;
    }
    for (int i = 0; i < billetter.length; i++) {
      billetter[i] = new StaaplassBillett(super.getTribuneNavn(), super.getPris());
      antSolgteBilletter++;
    }
    return billetter;
  }

  public Billett[] kjopBilletter(String[] navn) {
    Billett[] billetter = new Billett[navn.length];
    if (navn.length > (super.getKapasitet() - antSolgteBilletter)) {
      return billetter;
    }
    for (int i = 0; i < navn.length; i++) {
      billetter[i] = new StaaplassBillett(super.getTribuneNavn(), super.getPris());
      antSolgteBilletter++;
    }
    return billetter;
  }

  public String toString() {
    String utskrift = "";
    utskrift += super.getTribuneNavn() + ". Kapasitet: " + super.getKapasitet() + ". Solgt " + finnAntallSolgtBilletter() + " billetter for " + finnInntekt();
    return utskrift;
  }
}
