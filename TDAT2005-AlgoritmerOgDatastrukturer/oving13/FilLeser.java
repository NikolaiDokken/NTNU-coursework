import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FilLeser {

    public static String[] hsplit(String linje, int antall) {
        int j = 0;
        int lengde = linje.length();
        String[] felt = new String[antall];
        for (int i = 0; i < antall; ++i) {
            // Hopp over innledende blanke, finn starten på ordet
            while (linje.charAt(j) <= ' ')
                ++j;
            int ordstart = j;
            // Finn slutten på ordet, hopp over ikke-blanke
            while (j < lengde && linje.charAt(j) > ' ')
                ++j;
            felt[i] = linje.substring(ordstart, j);
        }
        return felt;
    }

    public void lesNoderOgKanter(String filnavnNoder, String filnavnKanter) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filnavnNoder));
            int n = Integer.parseInt(br.readLine().replace(" ", ""));
            Graf.N = n;
            Graf.node = new Node[Graf.N];

            for (int i = 0; i < n; i++) {
                // process the line.
                String[] data = hsplit(br.readLine(), 3);
                int id = Integer.parseInt(data[0]);
                Graf.node[id] = new Node();
                Graf.node[id].id = id;
                Graf.node[id].breddegrad = Double.parseDouble(data[1]);
                Graf.node[id].lengdegrad = Double.parseDouble(data[2]);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {

                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        try {
            br = new BufferedReader(new FileReader(filnavnKanter));
            int n = Integer.parseInt(br.readLine().replace(" ", ""));
            Graf.K = n;
            for (int i = 0; i < n; i++) {
                // process the line.
                String[] data = hsplit(br.readLine(), 5);
                int fra = Integer.parseInt(data[0]);
                int til = Integer.parseInt(data[1]);
                int vekt = Integer.parseInt(data[2]);
                VKant k = new VKant((VKant) Graf.node[fra].kant1, Graf.node[til], vekt);
                Graf.node[fra].kant1 = k;
            }
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {

                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }
}