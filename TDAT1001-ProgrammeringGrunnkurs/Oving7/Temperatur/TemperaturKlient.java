class TemperaturKlient {
	public static void main(String[] args) {
		
		// Konstruerer en tabell med konstruktøren Temperaturer
		Temperatur temp = new Temperatur(31, 24);
		
		// Skriver ut temperaturene for hver time i en dag 1-24		
		System.out.println("Eksempel på en dag");
		System.out.println(temp.toString(1) + "\n");
		
		// Test for å finne gjennomsnittstemp en dag
		System.out.println("Metode 1");
		double middeltempDag = temp.middelTempDag(1);
		System.out.println("Gjennomsnittstemperaturen dag 1: " + middeltempDag + " grader\n");
		
		// Test for å finne gjennomsnittstemp en gitt time hver dag
		System.out.println("Metode 2");
		double middeltempTime = temp.middelTempTime(1);
		System.out.println("Gjennomsnittstemperaturen mellom 00:00 og 01:00 er: " + middeltempTime + " grader\n");
		
		//Test for å finne gjennomsnittstemp hele måneden
		System.out.println("Metode 3");
		System.out.println("Gjennomsnittstemperaturen denne måneden var: " + temp.middelTempManed() + " grader\n");
	
	
		// Test for å finne antall dager i forskjellige grupper
		System.out.println("Metode 4");
		for (int i = 0; i < 5; i++) {
			System.out.println("Antall døgn med gjennomsnittstemp i gruppe " + (i + 1) + " er " + temp.grupperDager(i));
		}
	}
}