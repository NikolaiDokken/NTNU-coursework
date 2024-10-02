/**
* Programmet inneholder fire klasser:
*
* Person.java
* Klassen konstruerer et objekt med parameterene fornavn, etternavn og fødselsår
* Klassen skal ha get-metoder for hvert attributt.
*
* ArbTager.java
* Klassen konstruerer et objekt ArbeidsTager med parametrene navn(datatype Person),
* arbeidstagerNr., ansettelsesår, månedslønn og skatteprosent.
* Klassen skal være mutabel og skal ha både get-metoder for alle attributter, men også set-metoder for de
* attributtene det burde være mulig å forandre.
* Klassen skal også ha metoder som kan gjøre følgende operasjoner:
*
* 	Finne ut hvor mange kroner en arbeidstager trekkes i skatt per måned
* 	Finne bruttolønn per år, altså lønn før skatt
* 	Finne skattetrekk per år (ingen skatt juni, halv skatt i desember)
* 	Navn på formen: etternavn, fornavn
* 	Finne alder
* 	Finne antall år i bedriften
* 	Finne ut om personen har vært ansatt mer enn x antall år, parameter (x)
*
* BGS.java
* Klassen fungerer som brukergrensesnitt for programmet
* Skal ha metoder for hovedmeny, og get- og set-metoder
* Skal gjøre koden i klientprogrammet enklere

* PersonaliaKlient.java
* Klientprogrammet for koden
* skal bruke metoder fra BGS for å gjøre koden mer oversiktelig
*
*/

import static javax.swing.JOptionPane.*;
import javax.swing.*;

class Person {
	private final String fornavn;
	private final String etternavn;
	private final int fodselsar;

	public Person(String fornavn, String etternavn, int fodselsar) {
		this.fornavn = fornavn.trim();
		this.etternavn = etternavn.trim();
		this.fodselsar = fodselsar;
		if (fodselsar < 0 || fodselsar > 9999) {
			throw new IllegalArgumentException("Ugyldig fødselsår, må være i dette årtusenet");
		}
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public int getFodselsar() {
		return fodselsar;
	}

	public String toString() {
		return fornavn + " " + etternavn + ", født i år " + fodselsar;
	}
}


class ArbTaker {
	private Person personalia;
	private String arbeiderNr;
	private int ansattAr;
	private double manedsLonn;
	private double skatteprosent;

	public ArbTaker(Person personalia, String arbeiderNr, int ansattAr, double manedsLonn, double skatteprosent) {
		String fornavn = personalia.getFornavn();
		String etternavn = personalia.getEtternavn();
		int fodselsar = personalia.getFodselsar();
		this.personalia = new Person(fornavn, etternavn, fodselsar);
		this.arbeiderNr = arbeiderNr;
		this.ansattAr = ansattAr;
		this.manedsLonn = manedsLonn;
		this.skatteprosent = skatteprosent / 100;
	}

	public String getPersonalia() {
		return personalia.toString();
	}

	public String getArbeiderNr() {
		return arbeiderNr;
	}

	public int getAnsattAr(){
		return ansattAr;
	}

	public double getManedsLonn() {
		return manedsLonn;
	}

	public double getSkatteprosent() {
		return skatteprosent * 100;
	}

	public void setPersonalia(String fornavn, String etternavn, int fodselsar) {
		personalia = new Person(fornavn, etternavn, fodselsar);
	}

	public void setArbeiderNr (String nyttNr) {
		arbeiderNr = nyttNr;
	}

	public void setManedsLonn(double nyLonn) {
		manedsLonn = nyLonn;
	}

	public double skattPerManed() {
		return manedsLonn * skatteprosent;
	}

	public double bruttoLonn() {
		return manedsLonn * 12;
	}

	public double skattPerAr() {
		return (10 * skattPerManed()) + (skattPerManed() / 2);
	}

	public String navnForm() {
		return personalia.getEtternavn() + ", " + personalia.getFornavn();
	}

	public int getAlder() {
		java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
		int år = kalender.get(java.util.Calendar.YEAR);
		return år - personalia.getFodselsar();
	}

	public int arIBedriften() {
		java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
		int år = kalender.get(java.util.Calendar.YEAR);
		return år - ansattAr;
	}

	public boolean ansattLengreEnn(int antallAr) {
		java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
		int år = kalender.get(java.util.Calendar.YEAR);
		if (arIBedriften() > antallAr) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return (navnForm() + ". Ansatt Nr: " + getArbeiderNr() + ". Ble ansatt i: " + getAnsattAr() + ". Har " + getManedsLonn() + " i månedslønn, og betaler " + getSkatteprosent() + "% skatt.");
	}

}


class BGS {
	private Person person;
	private ArbTaker arbTaker;
	private final String[] MULIGHETER = {"Ny Arbeidstaker", "Vis Arbeidstaker"};
	private final String[] METODER = {"Set ansattNr.", "Set månedslønn", "Skatt pr måned", "Skatt pr år", "Alder", "Antall år ansatt", "Ansatt lengre enn x?"};

	private void nyPerson() {
		String personNavn = showInputDialog("Skriv inn fornavn og etternavn:\n Eksempel: Ola Nordmann");
		String[] navn = personNavn.split(" ");
		String personArLest = showInputDialog("Skriv inn fødselsår:\n Eksempel: 1999");
		int personAr = Integer.parseInt(personArLest);
		person = new Person(navn[0].trim(), navn[1].trim(), personAr);
	}

	private void nyArbTaker() {
		nyPerson();
		String arbeiderNr = showInputDialog("Skriv inn arbeidstakerNr.:\n Eksempel: 000001");
		String ansattArLest = showInputDialog(person.getFornavn() + " " + person.getEtternavn() + " ble ansatt i år:\n Eksempel: 2018");
		int ansattAr = Integer.parseInt(ansattArLest);
		String manedsLonnLest = showInputDialog("Skriv inn månedslønnen til denne personen (kr):\n Eksempel: 13000");
		double manedslonn = Double.parseDouble(manedsLonnLest);
		String skattLest = showInputDialog("Hva skal denne personen betale i skatt (%):\n Eksempel: 48");
		Double skatt = Double.parseDouble(skattLest);
		arbTaker = new ArbTaker(person, arbeiderNr, ansattAr, manedslonn, skatt);
	}

	public int lesValg() {
		int valg = showOptionDialog(null, "Velg en operasjon", "Hovedmeny", 0, PLAIN_MESSAGE, null, MULIGHETER, MULIGHETER[0]);
		return valg;
	}

	public void valgtOperasjon(int valg) {
		switch(valg) {
			case 0:
			nyArbTaker();
			break;

			case 1:
			int valg1 = showOptionDialog(null, arbTaker.toString(), "Undermeny ansatt", 0, PLAIN_MESSAGE, null, METODER, METODER[0]);
			switch(valg1) {
				case 0:
				String nyttAnsattNr = showInputDialog("Skriv inn nytt ansattNr: ");
				arbTaker.setArbeiderNr(nyttAnsattNr);
				break;

				case 1:
				String nyManedsLonn = showInputDialog("Skriv inn ny månedslønn: ");
				double nylonn = Double.parseDouble(nyManedsLonn);
				arbTaker.setManedsLonn(nylonn);
				break;

				case 2:
				showMessageDialog(null, arbTaker.navnForm() + " betaler " + arbTaker.skattPerManed() + "kr i skatt per måned.");
				break;

				case 3:
				showMessageDialog(null, arbTaker.navnForm() + " betaler " + arbTaker.skattPerAr() + "kr i skatt per år.");
				break;

				case 4:
				ImageIcon bilde = new ImageIcon("resources/testBilde.png");
				showMessageDialog(null, arbTaker.navnForm() + " er " + arbTaker.getAlder() + " år gammel.", "Alder", JOptionPane.INFORMATION_MESSAGE, bilde);
				break;

				case 5:
				showMessageDialog(null, arbTaker.navnForm() + " har vært ansatt i " + arbTaker.arIBedriften() + " år.");
				break;

				case 6:
				String arLest = showInputDialog("Du vil finne ut om denne ansatte har vært ansatte lengre enn: (år)");
				int ar = Integer.parseInt(arLest);
				if (arbTaker.ansattLengreEnn(ar) == true) {
					showMessageDialog(null, arbTaker.navnForm() + " har vært ansatt lengre enn " + ar + "år");
				} else {
					showMessageDialog(null, arbTaker.navnForm() + " har ikke vært ansatt lengre enn " + ar + "år");
				}
				break;
			}
			break;

		}
	}
}

class PersonaliaKlient {
	public static void main(String[] args) {
		BGS bgs = new BGS();
		int valg = 0;
		while (valg != CLOSED_OPTION) {
			valg = bgs.lesValg();
			bgs.valgtOperasjon(valg);
		}
	}
}
