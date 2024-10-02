class MinRandomKlient{
	public static void main(String[] args) {
		MinRandom test = new MinRandom();
		
		
		
		for (int teller = 0; teller <50; teller++) {
			int intTest = test.nesteHeltall(0, 100);
			double doubleTest = test.nesteDesimaltall(10, 100);
			System.out.println(intTest);
			System.out.println(doubleTest);
			System.out.println();
		}
	}
}