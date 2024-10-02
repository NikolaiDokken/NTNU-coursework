import static javax.swing.JOptionPane.*;

class Klientprogram {
  public static void main(String[] args) {
    Bord bord = new Bord(10);
    Restaurant res = new Restaurant("Nikolais delikatesser", "2000", bord);

    String[] muligheter = {"Reserver bord", "Finn bordNr etter navn", "Frigi bord", "Avslutt"};
    final int RESERVER = 0;
    final int FINN_BORDNR = 1;
    final int FRIGI_BORD = 2;
    final int AVSLUTT = 3;
    int valg = showOptionDialog(null, "Velg", "Klientprogram for restaurant",  YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
    do {
        switch (valg) {
            case RESERVER:  // reservere et antall bord på et bestemt navn
                String navn = showInputDialog("Hvilket navn vil du reservere bord på?");
                int antallBord = Integer.parseInt(showInputDialog("Hvor mange bord vil du reservere?"));
                res.reserverBord(antallBord, navn);
                break;
            case FINN_BORDNR:  // finne alle bordene som er reservert på et bestemt navn
                String navn1 = showInputDialog("Hvilket navn vil du finne bord for?");
                int[] temp = res.finnBord(navn1);
                String utskrift = "Følgende bord er reservert for " + navn1 + "\n";
                for (int i = 0; i < temp.length; i++) {
                  utskrift += temp[i] + "\n";
                }
                showMessageDialog(null, utskrift);
                break;
            case FRIGI_BORD:  // frigi en rekke bord, bordnummer er gitt
                String bordInnlest = showInputDialog("Skriv inn bord du ønsker å frigi med - som skilletegn");
                String[] bordNr = bordInnlest.split("-");
                int[] tallene = new int[bordNr.length];
                for (int i = 0; i < tallene.length; i++) {
                  tallene[i] = Integer.parseInt(bordNr[i]);
                }
                res.frigiBord(tallene);
                break;
            case AVSLUTT:
            break;
          }
          valg = showOptionDialog(null, "Velg", "Klientprogram for restaurant",  YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
    } while (valg != AVSLUTT);
  }
}
