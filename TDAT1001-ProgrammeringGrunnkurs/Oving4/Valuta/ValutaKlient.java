import java.util.Scanner;

class Klientprogram {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    Valuta dollar = new Valuta("USD", 8.93);
    Valuta euro = new Valuta("EUR", 10.56);
    Valuta sek = new Valuta("SEK", 1.02);


    System.out.println("Velg valuta:\n1. Dollar\n2. Euro\n3. Svenske kroner\n4. Avslutt");
    int valgtTall = scan.nextInt();
    while (valgtTall != 4) {
      System.out.println("Hvor mange penger har du av valutaen?");
      double belop = scan.nextDouble();

      // Dollar
      if (valgtTall == 1) {
        System.out.println(belop + " dollar, er det samme som " + dollar.tilNorskeKroner(belop) + " NOK");
      } else if(valgtTall == 2) {
        System.out.println(euro.tilNorskeKroner(belop));
      } else if(valgtTall == 3) {
        System.out.println(sek.tilNorskeKroner(belop));
      }
      System.out.println("Velg valuta:\n1. Dollar\n2. Euro\n3. Svenske kroner\n4. Avslutt");
      valgtTall = scan.nextInt();
    }
  }
}
