import java.io.*;
import java.util.ArrayList;

class FilSkriver {
    public static void skrivKoordinater(ArrayList<Node> kordinater, String outputFil) {
        try (FileWriter writer = new FileWriter(outputFil); BufferedWriter bw = new BufferedWriter(writer)) {
            for (int i = 0; i < kordinater.size(); i++) {
                String linje = kordinater.get(i).breddegrad + ", " + kordinater.get(i).lengdegrad;
                bw.write(linje);
                bw.newLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}