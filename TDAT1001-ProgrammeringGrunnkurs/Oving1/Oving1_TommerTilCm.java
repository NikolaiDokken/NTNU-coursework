/**
* Omregningtommetilcm.java
* Dette programmet regner om fra Tommer til centimeter
*/

import static javax.swing.JOptionPane.*;
class Oving1_TommerTilCm {
	public static void main(String[] args) {
		String tommerLest = showInputDialog("Antall tommer: ");
		double tommer = Double.parseDouble(tommerLest);
		final double FAKTOR = 2.54;
		double cm = tommer * FAKTOR;
		String utskrift = tommer + " tommer, er det samme som " + cm + " centimeter.";
		showMessageDialog(null, utskrift);
	}
}