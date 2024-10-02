import static javax.swing.JOptionPane.*;
import java.util.*;

class Klientprogram {
  public static void main(String[] args) {
    Rom rom1 = new Rom("0001", 5);
    Rom rom2 = new Rom("0002", 10);
    Rom rom3 = new Rom("0003", 15);
    Rom rom4 = new Rom("0004", 20);
    Rom rom5 = new Rom("0005", 25);

    Konferansesenter kon = new Konferansesenter();
    kon.regNyttRom(rom1);
    kon.regNyttRom(rom2);
    kon.regNyttRom(rom3);
    kon.regNyttRom(rom4);
    kon.regNyttRom(rom5);

    String meny = "Velg en handling:\n";
    meny += "1. Reserver et rom\n";
    meny += "2. Registrer ett nytt rom\n";
    meny += "3. Finn antall rom\n";
    meny += "4. Finn ett rom etter indeks\n";
    meny += "5. Finn rom etter romNr\n";
    meny += "6. Avslutt";

    int valg = 0;
    try {
      valg = Integer.parseInt(showInputDialog(meny));
    } catch (InputMismatchException e) {
    } catch (NumberFormatException e) {
    }
    while (valg != 6) {
      if (valg < 1 || valg > 6) {
        showMessageDialog(null, "Vennligst skriv inn et tall mellom 1 og 6");
      }
      switch (valg) {
        case 1:
        String reservasjonFra = "Skriv inn et start-tidspunkt for reservasjonen på formen YYYYMMDDTTTT";
        String reservasjonTil = "Skriv inn et slutt-tidspunkt for reservasjonen på formen YYYYMMDDTTTT";

        Tidspunkt tidFra = new Tidspunkt(Long.parseLong(showInputDialog(reservasjonFra)));
        Tidspunkt tidTil = new Tidspunkt(Long.parseLong(showInputDialog(reservasjonTil)));

        int antallPersoner = Integer.parseInt(showInputDialog("Hvor mange ønsker du å reservere et rom for?"));
        String kundeNavn = showInputDialog("Hvilket navn skal rommet stå på?");
        String kundeTlf = showInputDialog("Tlf til personen rommet står på?");
        Kunde temp = new Kunde(kundeNavn, kundeTlf);

        if (kon.reserverRom(tidFra, tidTil, antallPersoner, temp)) {
          showMessageDialog(null, "Rommet ble reservert på " + temp.getNavn());
        } else {
          showMessageDialog(null, "Rommet kunne ikke reserveres");
        }
        break;

        case 2:
        String romNavn = showInputDialog("Hvilket romNr har rommet du skal registrere?");
        int romStorrelse = Integer.parseInt(showInputDialog("Hvor mange mennesker er det plass til i rommet?"));
        Rom temp2 = new Rom(romNavn, romStorrelse);
        if (kon.regNyttRom(temp2)) {
          showMessageDialog(null, "Rommet ble registrert");
        } else {
          showMessageDialog(null, "Rommet kunne ikke registreres da det kanskje eksisterer et rom med dette nummeret fra før");
        }
        break;

        case 3:
        showMessageDialog(null, "Antall rom: " + kon.finnAntallRom());
        break;

        case 4:
        int indeks = Integer.parseInt(showInputDialog("Skriv inn en indeks"));
        showMessageDialog(null, kon.finnRom(indeks - 1).toString());
        break;

        case 5:
        String romNr = showInputDialog("Hva er romnummeret til rommet du ønsker å finne?");
        Rom temp4 = kon.finnRom(romNr);
        if (temp4 == null) {
          showMessageDialog(null, "Finner ingen rom med dette romnummeret");
        } else {
          showMessageDialog(null, temp4.toString());
        }
        break;

        default:
        break;
      }
      try {
        valg = Integer.parseInt(showInputDialog(meny));
      } catch (InputMismatchException e) {
      } catch (NumberFormatException e) {
      }
    }
  }
}
