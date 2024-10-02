import static javax.swing.JOptionPane.*;

class Oving2_Skuddar {
	
	public static void main(String[] args) {
		String tallLest = showInputDialog("År du ønsker å finne ut om er skuddår: ");
		int årstall = Integer.parseInt(tallLest);
		int rest = årstall % 100;
		if (rest == 0)
		{
			int rest100 = årstall % 400;
			if (rest100 == 0)
			{
				showMessageDialog(null, "År " + årstall + " er et skuddår.");
			}
			else
			{
				showMessageDialog(null, "År " + årstall + " er ikke et skuddår.");
			}
		}
		else
		{
			int restVanlig = årstall % 4;
			if (restVanlig == 0)
			{
				showMessageDialog(null, "År " + årstall + " er et skuddår.");
			}
			else
			{
				showMessageDialog(null, "År " + årstall + " er ikke et skuddår.");
			}
		}
	}
	
}