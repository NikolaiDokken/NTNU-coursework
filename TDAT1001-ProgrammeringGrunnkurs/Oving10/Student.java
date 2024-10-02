class Student {
	private String navn;
	private int antallOppgaver;
	
	public Student(String navn, int antallOppgaver) {
		if (navn.trim() == null || navn == "") {
			throw new IllegalArgumentException("Navn og antall oppgaver må fylles ut");
		}
		this.navn = navn.trim();
		this.antallOppgaver = antallOppgaver;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public int getAntallOppgaver() {
		return antallOppgaver;
	}
	
	public void plussAntallOppgaver(int pluss) {
		antallOppgaver += pluss;
	}
	
	public String toString() {
		return "Navn: " + navn + ". Antall oppgaver løst: " + antallOppgaver + "\n";
	}
}