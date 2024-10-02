import java.util.*;
import java.io.*;

class Testprogram {

  public static Tribune[] lesTribuneFraFil(String filnavn) {
      try {
          // Åpner en strøm som gjør at vi kan lese fra fil
          FileInputStream fis = new FileInputStream(filnavn);
          ObjectInputStream ois = new ObjectInputStream(fis);

          Tribune[] temp = new Tribune[4];
          for (int i = 0; i < temp.length; i++) {
            temp[i] = (Tribune) ois.readObject();
          }
          // Lukker lesestrømmen og returnerer Soppregisteret som ble lest
          ois.close();
          return temp;
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (SecurityException e) {
          e.printStackTrace();
      } catch (StreamCorruptedException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (NullPointerException e) {
          e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      return null;
  }

  // Metode som brukes for å lagre registeret ved avslutning av programmet
  public static void skrivTribuneTilFil(String filnavn, Tribune[] tribuner) {
      try {
          // Åpner en strøm som gjør at vi kan skrive til
          FileOutputStream fos = new FileOutputStream(filnavn);
          ObjectOutputStream oos = new ObjectOutputStream(fos);

          // Skriver registeret til filen
          for (int i = 0; i < tribuner.length; i++) {
            oos.writeObject(tribuner[i]);
          }

          // Lukker strømmen
          oos.close();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (StreamCorruptedException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }


  public static void main(String[] args) {

    Tribune[] tribuner = lesTribuneFraFil("tribune.ser");
    if (tribuner[0] == null) {
      // Tribune[] tribuner = {new Staa("Pølsesvingen", 100, 75), new Staa("Fittefjellet", 79, 143), new Sitte("Benken", 300, 30, 200), new VIP("De kongelige", 20, 2, 500)};
    }
    String[] navn = {"Nikolai", "Kasper"};


    Billett[] tribune1 = tribuner[0].kjopBilletter(8);
    for (Billett bil: tribune1) {
      System.out.println(bil.toString());
    }

    Billett[] tribune1Navn = tribuner[0].kjopBilletter(navn);
    for (Billett bil: tribune1Navn) {
      System.out.println(bil.toString());
    }
    System.out.println();

    /*
    Billett[] tribune2 = tribuner[1].kjopBilletter(15);
    for (Billett bil: tribune2) {
      System.out.println(bil.toString());
    }
    */

    Billett[] tribune2Navn = tribuner[1].kjopBilletter(navn);
    for (Billett bil: tribune2Navn) {
      System.out.println(bil.toString());
    }
    System.out.println();

    Billett[] tribune3 = tribuner[2].kjopBilletter(4);
    for (Billett bil: tribune3) {
      System.out.println(bil.toString());
    }

    Billett[] tribune3Navn = tribuner[2].kjopBilletter(navn);
    for (Billett bil: tribune3Navn) {
      System.out.println(bil.toString());
    }
    System.out.println();

    Billett[] tribune4 = tribuner[3].kjopBilletter(navn);
    for (Billett bil: tribune4) {
      System.out.println(bil.toString());
    }

    // Tribunene
    System.out.println();
    for (Tribune trib: tribuner) {
      System.out.println(trib.toString());
    }

    Arrays.sort(tribuner, new SortByInntekt());

    System.out.println();
    for (Tribune trib: tribuner) {
      System.out.println(trib.toString());
    }
    skrivTribuneTilFil("tribune.ser", tribuner);
  }
}

class SortByInntekt implements Comparator<Tribune> {
    public int compare(Tribune a, Tribune b) {
        if (a.finnInntekt() < b.finnInntekt()) return -1;
        else if ( a.finnInntekt() == b.finnInntekt() ) return 0;
        else return 1;
    }
}
