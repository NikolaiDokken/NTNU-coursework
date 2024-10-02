import static javax.swing.JOptionPane.*;

class TekstAnalyseKlient {	
	public static void main(String[] args) {
		
		String tekst = showInputDialog("Les inn en tekst, eller la stå tomt for å buke forrige.");
		Analyse testTekst = new Analyse(tekst);
		testTekst.analyser();
				
		// Gir klienten en meny med operasjoner		
		String operasjoner = "Hvilken operasjon vil du gjøre?\n";
		operasjoner += "1. Finne antall forskjellige bokstaver i teksten\n";
		operasjoner += "2. Finne total antall bokstaver i teksten\n";
		operasjoner += "3. Finne prosentandel av teksten som ikke er bokstaver\n";
		operasjoner += "4. Finne antall forekomster av en bestemt bokstav\n";
		operasjoner += "5. Finne hvilken/hvilke bokstav(er) som forekommer oftest";
		
		String valgLest  = showInputDialog(operasjoner);
		char valg = valgLest.charAt(0);
		
		
		
		
		// lager programkoden for de forskjellige operasjonene
		switch (valg) {
			case '1':
			System.out.println("Teksten: " + tekst + " gir følgende resultat:\n");
			System.out.println(testTekst.getAntallGanger());
			break;
			
			case '2':
			System.out.println("Antall bokstaver i teksten er: " + testTekst.getAntallBokstaver());
			break;
			
			case '3':
			System.out.println("Prosentandelen av teksten som ikke er bokstaver er: " + testTekst.getProsentIkkeBokstaver() + "%");
			break;
			
			case '4':
			System.out.println(testTekst.getEnBokstav());
			break;
			
			case '5':
			System.out.println(testTekst.getTypetall());
			break;
				
		}		
	}
}