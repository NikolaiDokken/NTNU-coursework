import java.io.*;

class KontoHandtering {
	public static void main(String[] args) {
		String saldoFil = "saldo.txt";
		String transaksjonsFil = "transaksjoner.txt";
		double forrigeSaldo = 0;

		/* Leser inn forrige saldo */
	try (FileReader leseForbTilFil = new FileReader(saldoFil);){
		BufferedReader leser = new BufferedReader(leseForbTilFil);
		String forrigeSaldoLest = leser.readLine();
		forrigeSaldo = Double.parseDouble(forrigeSaldoLest);
		leser.close();
	} catch (FileNotFoundException e) {
		System.out.println("Fant ikke fil");
	} catch (IOException e) {
		System.out.println("IOException");
	}

		/* Leser fra transaksjonsfilen og sjekker om saldo blir gyldig */
		try (FileReader leseForbTilFil = new FileReader(transaksjonsFil);) {
			BufferedReader leser = new BufferedReader(leseForbTilFil);
			boolean ok = true;
			String linje = "";
			while (linje != null) {
				linje = leser.readLine();
				if (linje == null) {
					break;
				}
				String[] linjeTabell = linje.split(" ");
				double belop = Double.parseDouble(linjeTabell[1]);
				if (linjeTabell[0].equals("U")) {
					forrigeSaldo -= belop;
				} else {
					forrigeSaldo += belop;
				}
			}
			leser.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fant ikke fil");
		} catch (IOException e) {
			System.out.println("IOException");
		}


		if (forrigeSaldo >= 0) {
			try (FileWriter skriveforbTilFil = new FileWriter(saldoFil, false);) {
      	PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveforbTilFil));
				skriver.println(forrigeSaldo);
				skriver.close();
			} catch (IOException e) {
				System.out.println("IOException");
			}
		}
	}

}
