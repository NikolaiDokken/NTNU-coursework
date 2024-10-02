import java.time.LocalDate;

class TestMedlemsArkiv {
  public static void main(String[] args) throws Exception {
    Personalia ole = new Personalia("Olsen", "Ole", "ole.olsen@dot.com", "ole");
    Personalia tove = new Personalia("Hansen", "Tove", "tove.hansen@dot.com", "tove");
    LocalDate testdato1 = LocalDate.of(2018, 11, 1);
    LocalDate testdato2 = LocalDate.of(2017, 11, 1);

    Medlemsarkiv med = new Medlemsarkiv();
    int testNr1 = med.nyMedlem(ole, testdato1);
    int testNr2 = med.nyMedlem(tove, testdato2);
    System.out.println("Totalt antall tester: 3");

    med.registrerPoeng(testNr1, 30000);
    med.sjekkMedlemmer();
    if ((med.getMedlem(0) instanceof SoelvMedlem) && (med.getMedlem(1).getPoeng() == 0)) {
      System.out.println("Test 1 ok");
    }

    med.registrerPoeng(testNr2, 80000);
    med.registrerPoeng(testNr1, 45000);
    med.sjekkMedlemmer();
    if ((med.getMedlem(0) instanceof GullMedlem) && (med.getMedlem(1) instanceof BasicMedlem)) {
      System.out.println("Test 2 ok");
    }


    if (med.getMedlem(0).getPoeng() == 84000 && med.getMedlem(1).getPoeng() == 80000) {
      System.out.println("Test 3 ok");
    }

    /*
    SoelvMedlem b3 = new SoelvMedlem(b2.getMedlNr(), b2.getPersonalia(), b2.getInnmeldt(), b2.getPoeng());
    b3.registrerPoeng(50000);
    if (b3.finnKvalPoeng(testdato) == 90000 && b3.getPoeng() == 90000) {
      System.out.println("Test 4 ok");
    }

    GullMedlem b4 = new GullMedlem(b3.getMedlNr(), b3.getPersonalia(), b3.getInnmeldt(), b3.getPoeng());
    b4.registrerPoeng(30000);
    if (b4.finnKvalPoeng(testdato) == 135000 && b4.getPoeng() == 135000) {
      System.out.println("Test 5 ok");
    }

    testdato = LocalDate.of(2008, 12, 10);
    if (b4.finnKvalPoeng(testdato) == 0 && b4.getPoeng() == 135000) {
      System.out.println("Test 6 ok");
    }

    if (!ole.okPassord("OOO")) {
      System.out.println("Test 7 ok");
    }
    if (tove.okPassord("tove")) {
      System.out.println("Test 8 ok");
    }
    */
  }
}
