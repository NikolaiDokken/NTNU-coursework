class TestOppgaveoversikt {
	public static void main(String[] args) {
		Oppgaveoversikt test = new Oppgaveoversikt(2);
		
		test.registrerNyStudent("Nikolai Dokken", 5);
		test.registrerNyStudent("Caspar Eide", 3);
		test.registrerNyStudent("Carsten Gilje", 10);
		System.out.println(test.toString());
		System.out.println();
		
		System.out.println("nikolai har løst: " + test.antallOppgaverAv("Nikolai Dokken"));
		
		System.out.println("Antall studenter: " + test.antallStudenter());
		test.plussAntallOppgaverFor("Caspar Eide", 2);
		System.out.println(test.toString());
		
	}
}