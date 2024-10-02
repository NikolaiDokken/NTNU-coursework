class MinRandom {
	
	java.util.Random tilfeldig = new java.util.Random();
	private double tallDouble;
	private int tallInt;
	
	public double nesteDesimaltall(double nedre, double ovre) {
		double randomDouble = tilfeldig.nextDouble() * (ovre - nedre) + nedre;
		randomDouble *= 100;
		randomDouble = Math.round(randomDouble);
		randomDouble /= 100;
				
		tallDouble = randomDouble;
		return tallDouble;
	}
	
	public int nesteHeltall(int nedre, int ovre) {
		int randomInt = tilfeldig.nextInt(ovre-nedre) + nedre;
		tallInt = randomInt;
		return tallInt;
	}
	
}


	
