class Tekstbehandling {
	private String tekst;
	
	public Tekstbehandling(String tekst) {
		this.tekst = tekst;
	}
	
	public int antallOrd() {
		String[] ord = tekst.split(" ");
		return ord.length;
	}
	
	public double ordLengde() {
		String[] ord = tekst.split(" ");
		double sum = 0;
		for (int i = 0; i < ord.length; i++) {
			sum += ord[i].length();
		}
		double gjennomsnitt = sum / (int)ord.length;
		return gjennomsnitt;
	}
	
	public double periodeLengde() {
		String[] periode = tekst.split("[.!:?]");
		double sum = 0;
		for (int i = 0; i < periode.length; i++) {
			String[] ord = periode[i].split(" ");
			sum += ord.length;
		}
		double gjennomsnitt = sum / periode.length;
		return gjennomsnitt;
	}
	
	public String erstatt(String fra, String til) {
		tekst = tekst.replace(fra, til);
		return tekst;
	}
	
	public String getTekst() {
		return tekst;
	}
	
	public String getTekstCaps() {
		return tekst.toUpperCase();
	}
}

class TekstbehandlingKlient {
	public static void main(String[] args) {
		Tekstbehandling test = new Tekstbehandling("ss sss . ss sss");
		
		/* Tester metode for antall ord */
		System.out.println("Antall ord i teksten er: " + test.antallOrd());
		
		/* Tester metode for gjennomsnittslig ordlengde */
		System.out.println("Gjennomsnittlig ordlengde er: " + test.ordLengde());
		
		/* Tester metode for gjennomsnittlig antall ord per periode */
		System.out.println("Gjennomsnittlig antall ord per periode er: " + test.periodeLengde());
		
		/* Tester metode for å erstatte en del av en tekst med noe annet */
		System.out.println("Erstatter: " + test.erstatt("test", "hei"));
		
		/* Tester metode for å hente ut teksten */
		System.out.println("Henter ut teksten som den står: " + test.getTekst());
		
		/* Tester metode for å hente ut teksten i store bokstaver */
		System.out.println("Henter ut teksten i store bokstaver: " + test.getTekstCaps());
		
	}
}