/**
* Dette programmet gjør om sekunder, til timer, minutter, og sekunder.
*/

import static javax.swing.JOptionPane.*;

class Oving1_SekunderTilTid {
	public static void main(String[] args) {
		
		String sekunderLest = showInputDialog("Antall Sekunder: ");
		
		int sekunder = Integer.parseInt(sekunderLest);
		
		final int FAKTOR = 60;
		
		int timer = sekunder / (FAKTOR * FAKTOR);// Antall timer er sekunder delt på 3600
		int timerRest = sekunder % (FAKTOR * FAKTOR); // Antall sekunder % 3600 gir oss resterende sekunder
		int minutter = timerRest / FAKTOR; // resterende sekunder delt på 60 gir oss minutter
		int minutterRest = timerRest % FAKTOR; // Resterende sekunder % 60 gir oss sekundene som er igjen etter at minuttene er tellt.
		String utskrift = sekunder + " sekund(er), er det samme som: " + timer + " time(r), " + minutter + " minutt(er) og " + minutterRest + " sekund(er).";
		showMessageDialog(null, utskrift);
	}
}