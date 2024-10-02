class Oving2 {
  // Oppgave 2.1-1
  public static double oppg1(double grunntall, int n) { //
    if (n == 0) {
      return 1;           // 1 tilordning
    } else if (n == 1){
      return grunntall;   // 1 tilordning
    } else {
      return (grunntall * oppg1(grunntall, n - 1)); // 1 tilordning
    }
  }
 //tidskompleksitet: n
  // a = 1
  // b = 1
  // k = 0
  // Cn = 1


  // Oppgave 2.2-3
  public static double oppg2(double grunntall, int n) {
    if (n == 0) {
      return 1;
    } else if (n % 2 == 1) {
      return (grunntall * oppg2(grunntall * grunntall, (n-1) / 2)); // 1 tilordning
    } else {
      return (oppg2(grunntall * grunntall, n / 2)); // 1 tilordning
    }
  }

  // a = 1
  // b = 2
  // k = 0
  // Cn^k = 1
  // log(n)

  public static double stdJava(double grunntall, int n) {
    return Math.pow(grunntall, n);
  }

  public static void main(String[] args) {
    double grunntall = 2;
    int eksponent = 10;

    long startTime1 = System.nanoTime();
    double svar1 = oppg1(grunntall, eksponent);
    long endTime1 = System.nanoTime();
    double totTime1 = (endTime1 - startTime1);

    long startTime2 = System.nanoTime();
    double svar2 = oppg2(grunntall, eksponent);
    long endTime2 = System.nanoTime();
    double totTime2 = (endTime2 - startTime2);

    long startTime3 = System.nanoTime();
    double svar3 = stdJava(grunntall, eksponent);
    long endTime3 = System.nanoTime();
    double totTime3 = (endTime3 - startTime3);

    System.out.println("Metode 1: " + svar1 + " Kjørte på: " + totTime1 + " ns.");
    System.out.println("Metode 2: " + svar2 + " Kjørte på: " + totTime2 + " ns.");
    System.out.println("Metode 3: " + svar3 + " Kjørte på: " + totTime3 + " ns.");

    // eksponent 1000
    // Metode 1: 180 000 ns
    // Metode 2: 3609 ns

    // eksponent 10 000 ns
    // Metode 1: 709 428 ns
    // Metode 2: 5454 ns


    // grunntall 10 000
    // Metode 1: 5494 ns
    // Metode 2: 1315 ns

    // grunntall 100 000 ns
    // Metode 1: 5718 ns
    // Metode 2: 2250 ns


  }
}
