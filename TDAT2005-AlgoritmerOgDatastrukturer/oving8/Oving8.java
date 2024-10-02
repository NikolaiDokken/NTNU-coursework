import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

class Oving8 {
    public static int[][] lesGraf(String filnavn) {
        Scanner scan = null;
        int[][] graf = null;
        try {
            File file = new File(filnavn);
            scan = new Scanner(file);
            int nodeAntall = scan.nextInt();
            int kantAntall = scan.nextInt();
            scan.nextLine();

            graf = new int[nodeAntall][nodeAntall];

            for (int i = 0; i < kantAntall; i++) {
                int fraNode = scan.nextInt();
                int tilNode = scan.nextInt();
                int kapasitet = scan.nextInt();

                graf[fraNode][tilNode] = kapasitet;
            }
            return graf;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return graf;

    }

    public static boolean bfs(int[][] restGraf, int kilde, int sluk, int[] parent) {
        // Besøkt liste
        boolean[] besokt = new boolean[restGraf.length];

        // Lag kø og legg til kildenoden
        LinkedList<Integer> ko = new LinkedList<Integer>();
        ko.add(kilde);
        besokt[kilde] = true;
        parent[kilde] = -1;

        while (ko.size() != 0) {
            int u = ko.poll();

            for (int i = 0; i < restGraf.length; i++) {
                if (!besokt[i] && restGraf[u][i] > 0) {
                    ko.add(i);
                    parent[i] = u;
                    besokt[i] = true;
                }
            }
        }
        return (besokt[sluk] == true);
    }

    public static int maxFlow(int[][] graf, int kilde, int sluk) {
        System.out.println("Maksimum flyt fra " + kilde + " til " + sluk + " med Edmond-Karp");
        System.out.println("Økning  :  Flytøkende vei");

        // Lager en restgraf som holde styr på kapasitetene etter endring
        int[][] restGraf = new int[graf.length][graf.length];
        int u, v;
        // Denne løkken fyller bare restGraf med initielle verdier til original graf
        for (u = 0; u < graf.length; u++) {
            for (v = 0; v < graf.length; v++) {
                restGraf[u][v] = graf[u][v];
            }
        }

        int[] parent = new int[graf.length];
        int maxFlow = 0;

        while (bfs(restGraf, kilde, sluk, parent)) {
            int pathFlow = 1000000000;

            // Finner den minste kapasiteten langs en sti
            String print = "";
            for (v = sluk; v != kilde; v = parent[v]) {
                print += v + " ";
                u = parent[v];
                pathFlow = Math.min(pathFlow, restGraf[u][v]);
            }
            System.out.println("     " + pathFlow + "     " + print + kilde);

            // Trekker fra kapasiteten vi fant over, og legger denne til i kantene som går
            // motsatt vei
            for (v = sluk; v != kilde; v = parent[v]) {
                u = parent[v];
                restGraf[u][v] -= pathFlow;
                restGraf[v][u] += pathFlow;

            }

            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] test = lesGraf("3.txt");

        int maxFlow = maxFlow(test, 0, 1);
        System.out.println("Maksimal flyt ble " + maxFlow);
    }
}