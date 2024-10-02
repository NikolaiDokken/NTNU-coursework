import java.util.Random;

class Oving1 {

  public static void beregnProfitt(int[] kursEndring) {
    int currentMax = 0;
    int fortjeneste = 0;
    int dagKjop = 0;
    int dagSelg = 0;

    for (int i = 0; i < kursEndring.length; i++) { // 1 tilordning, n x tilordning, n x tilordninger
      fortjeneste = 0;
      for (int k = i; k < kursEndring.length; k++) {// n tilordninger tilorning
        fortjeneste += kursEndring[k];
        if (fortjeneste > currentMax) {
          currentMax = fortjeneste;
          dagKjop = i;
          dagSelg = k+1;
        }
      }
    }
    System.out.println("Dag kjøpt: " + dagKjop + "\nDag solgt: " + dagSelg + "\nFortjeneste: " + currentMax);
  }

  public static void main(String[] args) {
    int n = 100000;
    Random rand = new Random();
    int[] kursEndring = new int[n];

    for (int i = 0; i < n; i++) {
      kursEndring[i] = rand.nextInt(20) - 10;
    }

    long startTime = System.nanoTime();

    beregnProfitt(kursEndring);

    long stopTime = System.nanoTime();
    double elapsedTime = (stopTime - startTime);
    System.out.println("Millisekunder: " + (elapsedTime / 1000000));
  }
}
// Tidskompleksitet: Θ (n^2)

// 100 verdier: ~0.12 ms
// 1000 kjøringer: ~2.89 ms
// 10 000 kjøringer: ~43.43 ms
// 100 000 kjøringer: ~3852.34 ms

/*
{-1, +3, -9, +2, +2, -1, +2, -1, -5} // expected buy day 3, sell day 7, profit 5
{-2, -4, 5, 2, -5, -2} // expected buy day 2, sell day 4, profit 7
*/
