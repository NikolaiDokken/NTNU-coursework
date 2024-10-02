import java.util.Scanner;
import java.io.*;

class Graf {
    private LinkedList[] graf;

    public Graf(String filnavn) {
        Scanner scan = null;
        try {
            File file = new File(filnavn);
            scan = new Scanner(file);
            int nodeAntall = scan.nextInt();
            int kantAntall = scan.nextInt();
            scan.nextLine();

            this.graf = new LinkedList[nodeAntall];

            for (int i = 0; i < nodeAntall; i++) {
                this.graf[i] = new LinkedList(new Node(i));
            }

            for (int i = 0; i < kantAntall; i++) {
                int fraNode = scan.nextInt();
                int tilNode = scan.nextInt();

                this.graf[fraNode].leggTilNode(new Node(tilNode));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

    }

    public void printGraf() {
        for (int i = 0; i < graf.length; i++) {
            String nodeString = "";
            Node currentNode = graf[i].getHode();
            nodeString += currentNode.getVerdi() + ": ";
            currentNode = currentNode.getNesteNode();
            while (currentNode != null) {
                nodeString += currentNode.getVerdi() + " ";
                currentNode = currentNode.getNesteNode();
            }
            System.out.println(nodeString);
        }
    }

    public int getAntallNoder() {
        return graf.length;
    }

    public Node getNode(int s) {
        return graf[s].getHode();
    }
}