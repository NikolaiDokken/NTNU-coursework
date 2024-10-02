class StudentTest {
	public static void main(String[] args) {
		Student test = new Student("Magnus", 3);
		
		System.out.println(test.getNavn());
		System.out.println(test.getAntallOppgaver());
		test.plussAntallOppgaver(7);
		System.out.println(test.getAntallOppgaver());
		System.out.println(test.toString());
	}
}