import java.util.Calendar.*;
import java.util.*;

class Restaurant {
  private String navn;
  private String etableringsAr;
  private Bord bord;

  public Restaurant(String navn, String ar, Bord bord) {
    this.navn = navn;
    this.etableringsAr = ar;
    this.bord = bord;
  }

  public String getNavn() {
    return navn;
  }

  public void setNavn(String nyttNavn) {
    navn = nyttNavn;
  }

  public String getAr() {
    return etableringsAr;
  }

  public int getAlder() {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    return currentYear - Integer.parseInt(etableringsAr);
  }

  public int getLedigeBord() {
    return bord.getLedigeBord();
  }

  public int getOpptatteBord() {
    return bord.getOpptatteBord();
  }

  public boolean reserverBord(int antallBord, String navn) {
    for (int i = 0; i < antallBord; i++) {
      boolean temp = bord.reserverBord(navn);
      if (!temp) {
        return false;
      }
    }
    return true;
  }

  public int[] finnBord(String navn) {
    int teller = 0;
    String[] temp = bord.getNavn();
    for (int i = 0; i < bord.getAntallBord(); i++) {
      if (temp[i] != null) {
        if (temp[i].equals(navn)) {
          teller ++;
        }
      }
    }
    int[] bord = new int[teller];
    int indeks = 0;
    for (int i = 0; i < this.bord.getAntallBord(); i++) {
      if (temp[i] != null) {
        if (temp[i].equals(navn)) {
          bord[indeks] = i;
          indeks++;
        }
      }
    }
    return bord;
  }

  public boolean frigiBord(int[] bord1) {
    String[] temp = bord.getNavn();
    for (int i = 0; i < bord1.length; i++) {
      temp[bord1[i]] = null;
      bord.okAntallLedige();
    }
    return true;
  }

  // Tester
  public static void main(String[] args) {
    Bord bord1 = new Bord(20);
    Restaurant res1 = new Restaurant("Dominoes", "2000", bord1);

    if (res1.getAlder() == 19) {
        System.out.println("Alder-test velykket");
    }

    if (res1.reserverBord(2, "Nikolai Dokken")) {
      System.out.println("Reserver-test vellykket");
    }
    int[] test = res1.finnBord("Nikolai Dokken");
    if (test [0] == 0 && test[1] == 1) {
      System.out.println("FinnBord-test vellykket");
    }
    int[] test2 = {0};
    if (res1.frigiBord(test2)) {
      System.out.println("FrigiBord-test vellykket");
    }
  }

}
