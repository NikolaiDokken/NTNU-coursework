class Bord {
  private String[] navn;
  private int antallBord;
  private int antallLedige;

  public Bord(int antallBord) {
    this.antallBord = antallBord;
    this.navn = new String[antallBord];
    this.antallLedige = antallBord;
  }

  public void okAntallLedige() {
    antallLedige++;
  }

  public int getAntallBord() {
    return antallBord;
  }

  public String[] getNavn() {
    return navn;
  }

  public int getLedigeBord() {
    return antallLedige;
  }

  public int getOpptatteBord() {
    return antallBord - antallLedige;
  }

  public boolean frigiBord(String navn1) {
    for (int i = 0; i < antallBord; i++) {
      if (navn[i].equals(navn1)) {
        navn[i] = null;
        antallLedige++;
        return true;
      }
    }
    return false;
  }

  public boolean reserverBord(String navn1) {
    if (antallLedige == 0) {
      return false;
    }
    navn[getOpptatteBord()] = navn1;
    antallLedige--;
    return true;
  }
}
