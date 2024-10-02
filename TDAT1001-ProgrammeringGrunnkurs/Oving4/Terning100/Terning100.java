class Terning100 {
  public static void main(String[] args) {
    Spiller spillerA = new Spiller();
    Spiller spillerB = new Spiller();

    int rundeNummer = 0;

    while (!spillerA.erFerdig() && !spillerB.erFerdig()) {
      rundeNummer++;
      System.out.println("Runde nr." + rundeNummer);
      System.out.println("Spiller A kaster: " + spillerA.kastTerningen() + ". Har " + spillerA.getSumPoeng() + " poeng.");
      System.out.println("Spiller B kaster: " + spillerB.kastTerningen() + ". Har " + spillerB.getSumPoeng() + " poeng.");
    }

    if (spillerA.erFerdig()) {
      System.out.println("Spiller A vant!");
    } else if(spillerB.erFerdig()) {
      System.out.println("Spiller B vant!");
    }
  }
}
