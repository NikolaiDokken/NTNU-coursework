import static javax.swing.JOptionPane.*;

class Oving3_Gangetabell {
	
	static public void main(String[] args) {
		
		String startIntervallLest = showInputDialog("Dette programmet skriver ut gangetabellen til tall i et gitt intervall.\n Hvilket tall ønsker du å skrive ut gangetabellen fra?");
		String sluttIntervallLest = showInputDialog("Hvilket tall ønsker du å skrive ut gangetabellen til?");
		String antallLinjerLest = showInputDialog("Hvor mange linjer ønsker du å skrive ut for hvert tall?");
		int startIntervall = Integer.parseInt(startIntervallLest);
		int sluttIntervall = Integer.parseInt(sluttIntervallLest);
		int antallLinjer = Integer.parseInt(antallLinjerLest);
		
		for (int teller = 1; teller <= antallLinjer; teller ++) {
			if (teller == 1) {
				System.out.println(startIntervall + "-gangen:");
			}
			System.out.println(startIntervall + " X " + teller + " = " + (startIntervall * teller));
			if (teller == antallLinjer) {
				teller = 0;
				startIntervall ++;
				System.out.println("\n");
			}
			if (startIntervall > sluttIntervall) {
				teller = antallLinjer + 1;
			}
		}
	}
}
		
		