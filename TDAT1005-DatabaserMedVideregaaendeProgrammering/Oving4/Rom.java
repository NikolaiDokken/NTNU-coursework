import java.util.ArrayList;

class Rom {
  private ArrayList<Reservasjon> reservasjonsobjekter = new ArrayList<Reservasjon>();
  private String romNr;
  private int storrelse;

  public Rom(String romNr, int storrelse) {
    this.romNr = romNr;
    this.storrelse = storrelse;
  }

  public String getRomNr() {
    return romNr;
  }

  public int getStorrelse() {
    return storrelse;
  }

  public ArrayList<Reservasjon> getReservasjoner() {
    return reservasjonsobjekter;
  }

  public boolean reserverTid(Reservasjon res) {
    // Sjekkr om reservasjonen overlapper noen av reservasjonene som allerede er gjort
    for (Reservasjon r: reservasjonsobjekter) {
      if (res.overlapp(r.getFraTid(), r.getTilTid())) {
        return false;
      }
    }
    reservasjonsobjekter.add(res);
    return true;
  }

  public boolean equals(Object obj) {
    // Sjekker om obj er et objekt av typen Rom
    if (!(obj instanceof Rom)) {
      return false;
    }

    // Sjekker om man sammenlikner rommet med seg selv
    if (this == obj) {
      return true;
    }

    // Caster obj til et objekt av typen rom
    Rom temp = (Rom) obj;

    return temp.getRomNr().equals(this.getRomNr());
  }

  public String toString() {
    return "RomNr: " + this.romNr + ". Plass til " + this.storrelse + " personer.";
  }

  // Tester klassen
  public static void main(String[] args) {
    Kunde k = new Kunde("Anne Hansen", "12345678");
    System.out.println("Totalt antall tester: ");
    Reservasjon res1 = new Reservasjon(new Tidspunkt(200302011000L), new Tidspunkt(200302011100L), k);
    Reservasjon res2 = new Reservasjon(new Tidspunkt(200301211000L), new Tidspunkt(200301211030L), k);
    Reservasjon res3 = new Reservasjon(new Tidspunkt(200302011015L), new Tidspunkt(200302011115L), k);


    Rom rom1 = new Rom("0001", 10);
    Rom rom2 = new Rom("0002", 20);
    if (rom1.reserverTid(res1) &&
        rom1.reserverTid(res2) &&
       !rom1.reserverTid(res3)) {
         System.out.println("Reservasjon: Test 1 vellykket.");
    }

    if (rom1.equals(rom1) && (!(rom1.equals(rom2)))) {
         System.out.println("Reservasjon: Test 2 vellykket.");
    }
    // Flg. setning kaster exception (fra-tid lik til-tid)
    //Reservasjon r5 = new Reservasjon(new Tidspunkt(200302011100L), new Tidspunkt(200302011100L), k);
    // Flg. setning kaster exception (fra-tid > til-tid)
    //Reservasjon r5 = new Reservasjon(new Tidspunkt(200302011130L), new Tidspunkt(200302011100L), k);
  }
}
