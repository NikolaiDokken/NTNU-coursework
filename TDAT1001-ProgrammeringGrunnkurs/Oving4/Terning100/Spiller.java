import java.util.Random;

class Spiller {
  // Objektvariabler
  private Random rand;
  private int sumPoeng;


  public Spiller() {
    this.sumPoeng = 0;
    this.rand = new Random();
  }

  // get-metode
  public int getSumPoeng() {
    return sumPoeng;
  }

  public int kastTerningen() {
    int kast = rand.nextInt(6)+1;
    if (kast == 1) {
      sumPoeng = 0;
    } else if (sumPoeng < 100) {
      sumPoeng += kast;
    } else if(sumPoeng > 100) {
      sumPoeng -= kast;
    }
    return kast;
  }

  public boolean erFerdig() {
    return sumPoeng == 100;
  }
}
