import static javax.swing.JOptionPane.*;

class Oving3_Primtall {

	public static void main(String[] args) {

		String tallLest = showInputDialog("Tall som skal til primtall-sjekk: ");
		while (tallLest != null) {
		int tall = Integer.parseInt(tallLest);
		int deler = tall - 1;
		if (tall == 1) {
			showMessageDialog(null, tall + " er ikke et primtall");
		}

		while (deler > 1) {
			int rest = tall % deler;
			if (rest == 0) {
				showMessageDialog(null, tall + " er ikke et primtall.");
				break;
			}
			else {
				deler --;
			}
		}
		if (deler == 1) {
			showMessageDialog(null, tall + " er et primtall.");
		}
		tallLest = showInputDialog("Tall som skal til primtall-sjekk: ");
		}
	}
}