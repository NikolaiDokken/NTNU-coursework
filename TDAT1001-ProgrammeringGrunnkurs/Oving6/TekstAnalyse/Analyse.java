import static javax.swing.JOptionPane.*;

class Analyse {
	private String tekst;
	private int[] antallTegn = new int[30];
	private int antallBokstaver;
	private int ikkeBokstaver;
	private double prosent;
	
	public Analyse(String tekst) {
		this.tekst = tekst;
	}
	
	public void analyser() {
		for (int i = 0; i < tekst.length(); i++) {
			int karakter = Character.toLowerCase(tekst.charAt(i));
			if (karakter == 'å' || karakter == 'Å') {
				karakter = 28 + 97;
			}
			if (karakter == 'Æ' || karakter == 'æ') {
				karakter = 26 + 97;
			}
			if (karakter == 'ø' || karakter == 'Ø') { 
				karakter = 27 + 97;
			}
			
			if (karakter > 96 && karakter < 126) {
				antallTegn[karakter - 97] ++;
				antallBokstaver ++;
			} 
			else {
			antallTegn[29] ++;
			ikkeBokstaver ++;
			}
		}
	}
	
	public int getAntallForekomster(int i) {
		return antallTegn[i];
	}
	
	public String getAntallGanger() {
		String utskrift = "";
		for (int i = 0; i < 26; i++) {
			char tegn = (char)(i + 97);
			utskrift += "Bokstaven " + tegn + " forekommer " + antallTegn[i] + " ganger.\n";
		}
		utskrift += "Bokstaven æ forekommer " + antallTegn[26] + " ganger.\n";
		utskrift += "Bokstaven ø forekommer " + antallTegn[27] + " ganger.\n";
		utskrift += "Bokstaven å forekommer " + antallTegn[28] + " ganger.\n";
		
		return utskrift;
	}
	
	public int getAntallBokstaver() {
		return antallBokstaver;
	}
	
	public int getIkkeBokstaver() {
		return ikkeBokstaver;
	}
	
	public double getProsentIkkeBokstaver() {
		double deler = getIkkeBokstaver() + getAntallBokstaver();
		double topp = getIkkeBokstaver();
		prosent = topp / deler;
		prosent *= 100;
		prosent *= 100;
		prosent = (Math.round(prosent)) / 100;
		return prosent;
	}
	
	public String getTypetall() {
		int hoyesteTall = 0;
		int bokstav = 0;
		String hoyesteBokser= "";
		boolean flereSvar = false;
		for (int i = 0; i < 29; i++) {
			int nyttTall = getAntallForekomster(i);
			if (nyttTall >= hoyesteTall) {
				if (nyttTall > hoyesteTall) {
				bokstav = i;
				hoyesteBokser = "";
				flereSvar = false;
				}
				if (nyttTall == hoyesteTall) {
					hoyesteBokser += (char)(i + 97) + ", ";
					flereSvar = true;
				}			
			}
		}
		
		String utskrift = "";
		int bokstav1 = bokstav + 97;

		if (flereSvar == true) {
			utskrift = "De bokstavene med flest forekomster er: " + hoyesteBokser;
		} else {
		
			if (bokstav1 == (26 + 97)) {
				utskrift = "Den bokstaven som forekommer oftest er: æ";
			} else if (bokstav1 == (27 + 97)) {
				utskrift = "Den bokstaven som forekommer oftest er: ø";
			} else if (bokstav1 == (28 + 97)) {
				utskrift = "Den bokstaven som forekommer oftest er: å";
			} else {
				utskrift = "Den bokstaven som forekommer oftest er: " + (char)bokstav1;
			}
		}
		return utskrift;
	}
	
	public String getEnBokstav() {
		String bokstav = showInputDialog("Hvilken bokstav ønsker du å finne antall forekomster av?");
		char tegn = bokstav.charAt(0);
		String utskrift = "";
		if (tegn == 'æ') {
			utskrift = "Bokstaven æ forekommer " + getAntallForekomster(26) + " ganger.";
		} else if (tegn == 'ø') {
			utskrift = "Bokstaven ø forekommer " + getAntallForekomster(27) + " ganger.";
		} else if (tegn == 'å') {
			utskrift = "Bokstaven å forekommer " + getAntallForekomster(28) + " ganger.";
		} else {
			utskrift = "Bokstaven " + tegn + " forekommer " + getAntallForekomster(tegn - 97) + " ganger.";
		}
		return utskrift;
	}
	
	
}



	
