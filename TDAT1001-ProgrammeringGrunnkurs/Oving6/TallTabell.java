class TallTabell {
	public static void main(String[] args) {
		
		java.util.Random random = new java.util.Random();
		
		
		int[] antall = new int[10];
		int gjennomlop = 1000;
		double stjerneverdi = (gjennomlop / 100);
		
		for (int teller = 0; teller < gjennomlop; teller++) {
			int tall = random.nextInt(10);
			antall[tall]++;
		}		
			
		for (int i = 0; i < 10; i ++) {
			double antallStjerner = Math.round(antall[i] / stjerneverdi);
			String stjerner = "";
			
			for (int s = 0; s < antallStjerner; s++) {
				stjerner += "* ";
			}			
			
			System.out.println("Antall " + i + "'ere: " + antall[i] + ". " + stjerner);		
		}
	}
}