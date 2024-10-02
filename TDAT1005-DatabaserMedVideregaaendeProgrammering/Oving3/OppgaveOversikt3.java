class OppgaveOversikt {
  private Student[] studenter = new Student[5];
  private int antStud = 0;


  public int finnAntStud() {
    return antStud;
  }

  public boolean regNyStudent(String navn) {
    // Sjekker om navnet er registrert fra før
    for (Student s: studenter) {
      if (s != null) {
        if (s.getNavn().equals(navn)) {
          return false;
        }
      }
    }

    // Sjekker om tabellen er full og trenger å utvides
    if (antStud == studenter.length) {
      utvidTabell();
    }

    // Oppretter en ny student dersom navnet ikke er registrert fra før
    Student nyStudent = new Student(navn, 0);
    studenter[antStud] = nyStudent;
    antStud++;
    return true;
  }

  // Metode som returnerer antall oppgaver en student har løst
  public int finnAntOppgaver(String navn) {
    // Sjekker om studenten er registrert
    for (Student s: studenter) {
      if (s != null) {
        if (s.getNavn().equals(navn)) {
          return s.getAntOppg();
        }
      }
    }

    // Returnerer -1 hvis studenten ikke er registrert
    return -1;
  }

  // Metode som øker antall oppgaver for en student
  public boolean okAntOppg(String navn, int oke) {
    // Finner studenten og øker dersom den eksisterer
    for (Student s: studenter) {
      if (s != null) {
        if (s.getNavn().equals(navn)) {
          s.setAntOppg(s.getAntOppg() + oke);
          return true;
        }
      }
    }
    return false;
  }

  public String[] finnAlleNavn() {
    String[] alleNavn = new String[antStud];
    for (int i = 0; i < antStud; i++) {
      alleNavn[i] = studenter[i].getNavn();
    }
    return alleNavn;
  }

  // toString metode
  public String toString() {
    String utskrift = "";
    for (Student s: studenter) {
      if (s != null) {
        utskrift += s.toString() + "\n";
      }
    }
    return utskrift;
  }

  // Hjelpemetode som utvider student-tabellen
  private void utvidTabell() {
    Student[] nyTab = new Student[studenter.length + 5];
    for (int i = 0; i < antStud; i++) {
      nyTab[i] = studenter[i];
    }
    studenter = nyTab;
  }
}
