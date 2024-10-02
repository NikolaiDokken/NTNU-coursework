class Oppgaveoversikt {
	private Student[] studenter; // Tabell med alle studenter
	private int antallStudenter = 0; // Økes med 1 for hver nye student
	
	public Oppgaveoversikt(int lengde) {
		this.studenter = new Student[lengde];
	}
	
	public boolean registrerNyStudent(String navn, int antallOppgaver) {
		if (antallStudenter == studenter.length) {
			utvidTabell();
		}
		studenter[antallStudenter] = new Student(navn, antallOppgaver);
		antallStudenter++;
		return true;
	}
	
	public int antallStudenter() {
		return antallStudenter;
	}
	
	public int antallOppgaverAv(String navn) {
		for (int i = 0; i < studenter.length; i++) {
			if (studenter[i].getNavn().equals(navn.trim())) {
				return studenter[i].getAntallOppgaver();
			}
		}
		return 0;
	}
	
	public void plussAntallOppgaverFor(String navn, int oppgaver) {
		for (int i = 0; i < antallStudenter; i++) {
			if (studenter[i].getNavn().equals(navn.trim())) {
				studenter[i].plussAntallOppgaver(oppgaver);
			}
		}
	}
	
	
	public String toString() {
		String utskrift = "";
		for (int i = 0; i < antallStudenter; i++) {
			utskrift += studenter[i].toString(); 
		}
		return utskrift;
	}
	
	private void utvidTabell() {
		Student[] nyTabell = new Student[studenter.length + 5];
		for (int i = 0; i < antallStudenter; i++) {
			nyTabell[i] = studenter[i];
		}
		studenter = nyTabell;
	}
}