class Temperatur {
	private int antDager;
	private int antTimer;
	private double[][] temp;
	
	public Temperatur(int antDager, int antTimer) {
		this.antDager = antDager;
		this.antTimer = antTimer;
		this.temp = new double[antDager][antTimer];
		fyllUtTabell();
	}
	
	// Metode for middeltemp hver dag i måneden, aka gjennomsnitt per dag, kolonne
	public double middelTempDag(int dag) {
		double sum = 0;
		for (int i = 0; i < temp[0].length; i++) {
		sum += temp[dag][i];	
		}
		double middeltemp = (sum / temp[0].length);
		middeltemp *= 100;
		middeltemp = Math.round(middeltemp);
		middeltemp /= 100;
		return middeltemp;
	}
	
	// Metode for middeltemp hver time i døgnet, gjennomsnitt for time på dagen, rad
	public double middelTempTime(int time) {
		double sum = 0;
		for (int i = 0; i < temp.length; i++) {
			sum += temp[i][time];
		}
		double middeltemp = (sum / temp.length);
		middeltemp *= 100;
		middeltemp = Math.round(middeltemp);
		middeltemp /= 100;
		return middeltemp;
	}
	
	// Metode for middeltemp hele måneden, gjennomsnitt av alle verdier
	public double middelTempManed() {
		double sum = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int k = 0; k < temp[0].length; k++) {
				sum += temp[i][k];
			}
		}
		double middeltemp = sum / (temp.length * temp[0].length);
		middeltemp *= 100;
		middeltemp = Math.round(middeltemp);
		middeltemp /= 100;
		return middeltemp;
	}
	
	// Metode for antall dager i forskjellige grupper
	public int grupperDager(int l) {
		int[] gruppe = new int[5];
		for (int i = 0; i < temp.length; i++) {
			double middel = middelTempDag(i);
			if (middel < -5) {
				gruppe[0]++;
			} else if (middel > -5 && middel < 0) {
				gruppe[1]++;
			} else if (middel > 0 && middel < 5) {
				gruppe[2]++;
			} else if (middel > 5 && middel < 10) {
				gruppe[3]++;
			} else {
				gruppe[4]++;
			}
		}
		return gruppe[l];
	}
	
	// Metode for utskfrift
	public String toString(int dag) {
		String utskrift = "Dag " + (dag) + ":";
		for (int i = 0; i < temp[0].length; i++) {
			utskrift += temp[dag][i] + " ";
		}
		return utskrift;
	}
	
	
	// Hjelpemetode for å fylle ut tabellen
	// Bruker klassne java.util.random for å sette inn tilfeldige temperaturer i tabellen
	private void fyllUtTabell() {
		java.util.Random tilfeldig = new java.util.Random();
		for (int i = 0; i < temp.length; i++) {
			for (int k = 0; k < temp[0].length; k++) {
				int randomTemp = tilfeldig.nextInt(10000);
				randomTemp /= 100;
				randomTemp -= 50;
				temp[i][k] = randomTemp;
			}
		}
	}
}
