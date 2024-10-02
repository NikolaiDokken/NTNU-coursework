import java.util.*;

class OppgaveOversikt {
  private ArrayList<Student> studenter = new ArrayList<Student>();

  public int finnAntStud() {
    return studenter.size();
  }

  public boolean regNyStudent(String navn) {
    // Sjekker om navnet er registrert fra før
    for (Student s : studenter) {
      if (navn.equals(s.getNavn())) {
        return false;
      }
    }

    // Oppretter en ny student dersom navnet ikke er registrert fra før
    Student nyStudent = new Student(navn, 0);
    studenter.add(nyStudent);
    return true;
  }

  // Metode som returnerer antall oppgaver en student har løst
  public int finnAntOppgaver(String navn) {
    // Sjekker om studenten er registrert
    for (Student s: studenter) {
      if (navn.equals(s.getNavn())) {
        return s.getAntOppg();
      }
    }

    // Returnerer -1 hvis studenten ikke er registrert
    return -1;
  }

  // Metode som øker antall oppgaver for en student
  public boolean okAntOppg(String navn, int oke) {
    // Finner studenten og øker dersom den eksisterer
    for (Student s: studenter) {
      if (navn.equals(s.getNavn())) {
        s.setAntOppg(s.getAntOppg() + oke);
        return true;
      }
    }
    return false;
  }

  public String[] finnAlleNavn() {
    String[] alleNavn = new String[studenter.size()];
    for (int i = 0; i < studenter.size(); i++) {
      alleNavn[i] = studenter.get(i).getNavn();
    }
    return alleNavn;
  }

  // toString metode
  public String toString() {
    String utskrift = "";
    for (Student s: studenter) {
      utskrift += s.toString() + "\n";
    }
    return utskrift;
  }
}
