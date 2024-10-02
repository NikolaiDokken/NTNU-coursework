class NyString {
	private String tekst;
	
	public NyString(String tekst) {
		this.tekst = tekst;
	}
	
	public String getTekst() {
		return tekst;
	}
	
	/* Metode som forkorter setninger, returnerer første bokstav i hvert ord */
	public String forkorting() {
		String[] ord = tekst.split(" ");
		String forkortelse = "";
		for (int i = 0; i < ord.length; i++) {
			forkortelse += ord[i].charAt(0);
		}
		return forkortelse;
	}
	
	/* metode som fjerner tegn, og returnerer teksten uten dette tegnet */
	public String fjerneTegn(String tegn) {
		if (tegn.length() > 1) {
			throw new IllegalArgumentException("Du kan ikke fjerne mer enn et tegn av gangen");
		} 
		tekst = tekst.replace(tegn, "");
		return tekst;
	}
}

class NyStringKlient {
	public static void main(String[] args) {
		NyString test = new NyString("Hei jeg heter arne gunnar");
		
		System.out.println("Den originale teksten; " + test.getTekst());
		System.out.println(test.forkorting());
		System.out.println(test.fjerneTegn("e"));		
	}
}
