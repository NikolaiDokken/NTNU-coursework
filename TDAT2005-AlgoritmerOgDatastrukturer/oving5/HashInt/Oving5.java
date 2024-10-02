import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

class Oving5 {
    
    public static int[] fyllTabell(int length) {
        Random rand = new Random();
        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000000000);
        }
        return array;
    }
    
    public static void main(String[] args) {
        HashTable hs = new HashTable(5000011);
        int[] numbs = fyllTabell(5000000);
        double antTall = 5000000;
        double antKollisjoner = 0;

        HashMap hs2 = new HashMap(5000011);

        long startTime = System.nanoTime();
        for(int i = 0; i < numbs.length; i++) {
            boolean kollisjon = hs.settInnNumb(numbs[i]);
            if (kollisjon) {
                antKollisjoner++;
            }
        }

        long endTime = System.nanoTime();
        double runTime = (endTime - startTime) / 1000000;
        System.out.println("Runtime manual hash " + runTime + " ms");

        long startTime2 = System.nanoTime();
        for (int i = 0; i < numbs.length; i++) {
            hs2.put(numbs[i], numbs[i]);
        }
        long endTime2 = System.nanoTime();
        double runTime2 = (endTime2 - startTime2) / 1000000;
        System.out.println("Runtime java hash " + runTime2 + " ms");

       
        // System.out.println(hs.toString());
        System.out.println("Antall kollisjoner: " + antKollisjoner);
        System.out.println("Gjennomsnittlig kollisjoner per tall er: " + (antKollisjoner / antTall));
        System.out.println("Lastfaktor: " + antTall / hs.getSize());
    }    
}
