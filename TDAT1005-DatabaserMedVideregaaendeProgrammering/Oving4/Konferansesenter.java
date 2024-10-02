import java.util.ArrayList;

class Konferansesenter {
  private ArrayList<Rom> rom;

  public Konferansesenter() {
    this.rom = new ArrayList<Rom>();
  }
  public boolean reserverRom(Tidspunkt fraTid, Tidspunkt tilTid, int antallPersoner, Kunde kunde) {
    // Sjekker om det er noen rom å reservere i konferansesentereret
    if (rom.size() == 0) {
      return false;
    }

    // Lager en reservasjon
    Reservasjon temp = new Reservasjon(fraTid, tilTid, kunde);

    // Finner først et ledig rom, sjekker om tidene overlapper
    for (Rom r: rom) {
      if (r.reserverTid(temp) && antallPersoner < r.getStorrelse()) {
        return true;
      }
    }
    return false;
  }

  // Metode som registrer nytt rom, returnerer false hvis rommet eksisterer
  public boolean regNyttRom(Rom nyttRom) {
    for (Rom r: rom) {
      if (nyttRom.getRomNr().equals(r.getRomNr())) {
        return false;
      }
    }

    rom.add(nyttRom);
    return true;
  }

  // Finner antall rom
  public int finnAntallRom() {
    return rom.size();
  }

  public Rom finnRom(int indeks) {
    if (indeks > rom.size()) {
      throw new IllegalArgumentException("Indeksen du oppga er ikke i systemet");
    }
    return rom.get(indeks);
  }

  public Rom finnRom(String romNr) {
    for (Rom r: rom) {
      if (romNr.equals(r.getRomNr())) {
        return r;
      }
    }
    return null;
  }


}
