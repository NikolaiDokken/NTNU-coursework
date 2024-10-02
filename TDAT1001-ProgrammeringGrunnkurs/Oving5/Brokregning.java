class Brok {

	private int teller;
	private int nevner;

	public Brok(int teller, int nevner) {
		if (nevner == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være lik 0.");
		}
		this.teller = teller;
		this.nevner = nevner;

	}

	public Brok(int teller) {
		this.teller = teller;
		this.nevner = 1;
	}

	public int getTeller() {
		return teller;
	}

	public int getNevner() {
		return nevner;
	}

	public void plussBrok(Brok pluss) {
		if (pluss.getNevner() == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være lik 0.");
		}
		int originalNevner = nevner;
		teller *= pluss.getNevner();
		nevner *= pluss.getNevner();

		int teller2 = pluss.getTeller() * originalNevner;

		teller += teller2;
	}

	public void minusBrok(Brok minus) {
		if (minus.getNevner() == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være lik 0.");
		}
		int originalNevner = nevner;
		teller *= minus.getNevner();
		nevner *= minus.getNevner();

		int teller2 = minus.getTeller() * originalNevner;

		teller -= teller2;
	}

	public void gangeBrok(Brok gange) {
		if (gange.getNevner() == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være lik 0.");
		}
		teller *= gange.getTeller();
		nevner *= gange.getNevner();
	}

	public void deleBrok(Brok dele) {
		if (dele.getNevner() == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være lik 0.");
		}
		int oppe = dele.getNevner();
		int nede = dele.getTeller();
		Brok delebrok = new Brok(oppe, nede);
		gangeBrok(delebrok);
	}

	public void forkort() {
    int gcd = gcd(teller, nevner);

    // Allerede forkortet
    if (gcd == 1) return;

    if (gcd > 0) {
      teller = teller/gcd;
      nevner = nevner/gcd;
    }
	}

  // Finner GCD, greatest common divisor
  private int gcd(int teller, int nevner) {
    teller = ( teller > 0) ? teller : -teller;
    nevner = ( nevner > 0) ? nevner : -nevner;

    while (teller != nevner) {
      if (teller > nevner) {
          teller -= nevner;
      } else {
        nevner -= teller;
      }
    }
    return teller;
  }

	public void print() {
		System.out.println(getTeller() + "/" + getNevner());
	}

}


class Brokregning {
	public static void main(String[] args) {
		Brok test1 = new Brok(3, 4);
		Brok test2 = new Brok(1, 6);
		test1.plussBrok(test2);
		test1.forkort();
		test1.print();

		System.out.println();

		Brok test3 = new Brok(5, 3);
		Brok test4 = new Brok(1,2);
		test3.minusBrok(test4);
		test3.forkort();
		test3.print();

		System.out.println();

		Brok test5 = new Brok(4, 8);
		Brok test6 = new Brok(2, 3);
		test5.gangeBrok(test6);
		test5.forkort();
		test5.print();

		System.out.println();

		Brok test7 = new Brok(2,7);
		Brok test8 = new Brok(3,5);
		test7.deleBrok(test8);
		test7.forkort();
		test7.print();
	}
}
