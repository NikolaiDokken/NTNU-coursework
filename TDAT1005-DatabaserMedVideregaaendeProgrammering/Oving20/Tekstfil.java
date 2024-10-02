import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tekstfil {

    public static void skriv(String setning) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("utskrift.txt", true));
            bw.write(setning);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
