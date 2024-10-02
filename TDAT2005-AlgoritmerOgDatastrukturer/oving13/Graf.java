import java.util.*;

class Graf {
    static int N, K;
    static Node[] node;
    static int sjekket = 0;

    static void astar(Node s, Node m, boolean dijkstra) {
        // Lager en prioritetritetskø
        PriorityQueue<Node> priko = new PriorityQueue<>(N,
                (o1, o2) -> ((Forgj) o1.d).prioritet - ((Forgj) o2.d).prioritet);
        // Setter node start sin forgjenger
        s.d = new Forgj();
        // Setter forgjengers distanseTilStartanse til 0
        ((Forgj) s.d).distanseTilStart = 0;
        // Legger til i kø
        priko.add(s);

        while (!priko.isEmpty()) {
            Node curr = priko.poll();
            sjekket++;
            if (curr == m) {
                skrivPath(m, s); // Vi har nådd målnoden og må jobbe oss tilbake til start
            }
            for (VKant k = (VKant) curr.kant1; k != null; k = (VKant) k.neste) {
                Node n = k.til;
                if (curr.d != null && n.d != null
                        && ((Forgj) curr.d).distanseTilStart + k.vekt >= ((Forgj) n.d).distanseTilStart)
                    continue; // Not a better match
                n.d = new Forgj();
                ((Forgj) n.d).forgj = curr;
                ((Forgj) n.d).kjoretid = ((Forgj) curr.d).kjoretid + k.vekt;
                ((Forgj) n.d).distanseTilStart = ((Forgj) curr.d).distanseTilStart + k.vekt;
                ((Forgj) n.d).prioritet = ((Forgj) curr.d).distanseTilStart + k.vekt
                        + (dijkstra ? 0 : (int) avstand(curr, m));
                priko.remove(n);
                priko.add(n);
            }

        }
    }

    public static int avstand(Node n1, Node n2) {
        // Til radianer
        double sin_bredde = Math.sin((n1.breddegrad - n2.breddegrad) / 2.0) * (Math.PI / 180);
        double sin_lengde = Math.sin((n1.lengdegrad - n2.lengdegrad) / 2.0) * (Math.PI / 180);
        return (int) (35285538.46153846153846153846 * Math
                .asin(Math.sqrt((sin_bredde * sin_bredde) + n1.cosBredde * n2.cosBredde * sin_lengde * sin_lengde)));
    }

    public static double forventetAvstand(Node start, Node goal) {
        return (2 * 6371
                * Math.asin(Math.sqrt(Math.sin((Math.toRadians(start.breddegrad) - Math.toRadians(goal.breddegrad)) / 2)
                        * Math.sin((Math.toRadians(start.breddegrad) - Math.toRadians(goal.breddegrad)) / 2)
                        + Math.cos(Math.toRadians(start.breddegrad)) * Math.cos(Math.toRadians(goal.breddegrad))
                                * Math.sin((Math.toRadians(start.lengdegrad) - Math.toRadians(goal.lengdegrad)) / 2)
                                * Math.sin((Math.toRadians(start.lengdegrad) - Math.toRadians(goal.lengdegrad)) / 2))));
    }

    private static void skrivPath(Node n, Node s) {
        Node m = n;
        int teller = 1;
        ArrayList<Node> koordinater = new ArrayList<Node>();
        while (m != s) {
            koordinater.add(m);
            m = ((Forgj) m.d).forgj;
            teller++;
        }
        koordinater.add(s);
        FilSkriver.skrivKoordinater(koordinater, "koordinater.txt");
        System.out.println("Startet på: " + s.breddegrad + "," + s.lengdegrad); // Skriv ut startnode
        System.out.println("Antall sjekkede noder: " + sjekket);
        System.out.println("Antall noder i veien: " + teller);
        int totSekunder = ((Forgj) n.d).kjoretid / 100;
        int timer = totSekunder / 3600;
        int minutter = (totSekunder % 3600) / 60;
        int sekunder = (totSekunder % 3600) % 60;
        System.out.println("Kjøretid: " + timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder");
    }
}
