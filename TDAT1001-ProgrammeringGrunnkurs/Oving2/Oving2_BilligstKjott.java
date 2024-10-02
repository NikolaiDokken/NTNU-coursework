class Oving2_BilligstKjott {
	public static void main(String[] args) {
		double vektKjottA = 0.45;
		double prisKjottA = 35.90;
		
		double vektKjottB = 0.5;
		double prisKjottB = 39.50;
		
		double prisPerKgA = prisKjottA / vektKjottA;
		double prisPerKgB = prisKjottB / vektKjottB;
		
		System.out.print("Prisen per kilo for merke A, er: ");
 		System.out.printf("%.2f", prisPerKgA);
		System.out.print(" kr");
		System.out.println("");
		System.out.print("Prisen per kilo for merke B, er: ");
		System.out.printf("%.2f", prisPerKgB);
		System.out.print(" kr");
		System.out.println("");
		
		if (prisPerKgA == prisPerKgB)
		{
			System.out.println("De to merkene koster det samme per kilo.");
		}
		if (prisPerKgA > prisPerKgB)
		{
			System.out.println("Merke B koster mindre per kilo.");
		}
		if (prisPerKgA < prisPerKgB)
	 	{
			System.out.println("Merke A koster mindre per kilo.");
		}
	}
}
	