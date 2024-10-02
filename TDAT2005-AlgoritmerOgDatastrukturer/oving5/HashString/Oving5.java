import java.io.*;
import java.util.ArrayList;

class Oving5 {
    
    public static ArrayList<String> lesNavn(String filnavn) {
        FileReader fis = null;
        BufferedReader bis = null;
        ArrayList<String> navn = new ArrayList<String>();

        try {
            fis = new FileReader(new File(filnavn));
            bis = new BufferedReader(fis);

            String line = bis.readLine();
            while (line != null) {
                navn.add(line);
                line = bis.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        return navn;
    }
    
    public static void main(String[] args) {
        HashTable hs = new HashTable(128);
        ArrayList<String> navn = lesNavn("navn.txt");
        double antPersoner = 96;
        double antKollisjoner = 0;

        for(int i = 0; i < navn.size(); i++) {
            boolean kollisjon = hs.settInnNavn(navn.get(i));
            if (kollisjon) {
                antKollisjoner++;
                int index = hs.stringIndex(navn.get(i));
                String kollidertMed = hs.toString(index);
                System.out.println(navn.get(i) + " kolliderte med følgende:\n" + kollidertMed);
            }
        }

        

        System.out.println(hs.sokPerson("Dokken,Nikolai Roede"));
        System.out.println("Antall kollisjoner: " + antKollisjoner);
        System.out.println("Gjennomsnittlig kollisjoner per person er: " + (antKollisjoner / antPersoner));
        System.out.println("Lastfaktor: " + antPersoner/ hs.getSize());
    }    
}
