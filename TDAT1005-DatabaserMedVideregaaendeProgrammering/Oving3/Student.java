public class Student {
  private final String navn;
  private int antOppg;

  public Student(String navn, int antOppg) {
    this.navn = navn;
    this.antOppg = antOppg;
  }

  public String getNavn() {
    return navn;
  }

  public int getAntOppg() {
    return antOppg;
  }

  public void setAntOppg(int antOppg) {
    if (antOppg < 0) {
      throw new IllegalArgumentException("Antall oppgaver kan ikke være negativt");
    }
    this.antOppg = antOppg;
  }

  public String toString() {
    return "Navn: " + navn + ". Antall oppgaver godkjent: " + antOppg;
  }
}
