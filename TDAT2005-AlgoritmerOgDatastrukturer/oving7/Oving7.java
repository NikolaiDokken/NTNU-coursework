import java.util.LinkedList;
import java.util.ArrayList;

class Oving7 {

    public static int[][] bfs(Graf graf, int startNode) {
        LinkedList<Integer> ko = new LinkedList<Integer>();
        boolean[] visited = new boolean[graf.getAntallNoder()];
        int[][] info = new int[graf.getAntallNoder()][3];

        visited[startNode] = true;
        ko.add(startNode);
        info[startNode][0] = startNode;
        info[startNode][1] = -1;
        info[startNode][2] = 0;

        while (!(ko.size() == 0)) {
            int s = ko.poll();
            // System.out.println(s + " ");

            Node currentNode = graf.getNode(s);
            while (currentNode.getNesteNode() != null) {

                int n = currentNode.getNesteNode().getVerdi();

                if (!visited[n]) {
                    info[n][0] = n;
                    info[n][1] = s;
                    info[n][2] = info[s][2] + 1;
                    visited[n] = true;
                    ko.add(n);
                }
                currentNode = currentNode.getNesteNode();
            }
        }
        return info;
    }

    public static void topologiskHjelpeMetode(int node, boolean[] visited, ArrayList<Integer> stack, Graf graf) {
        visited[node] = true;

        Node currentNode = graf.getNode(node);

        while (currentNode.getNesteNode() != null) {
            int i = currentNode.getNesteNode().getVerdi();
            if (!(visited[i])) {
                topologiskHjelpeMetode(i, visited, stack, graf);
            }
            currentNode = currentNode.getNesteNode();
        }
        stack.add(node);
    }

    public static void topologiskSok(Graf graf) {
        ArrayList<Integer> stack = new ArrayList<Integer>();
        boolean[] visited = new boolean[graf.getAntallNoder()];

        for (int i = 0; i < graf.getAntallNoder(); i++) {
            if (!(visited[i])) {
                topologiskHjelpeMetode(i, visited, stack, graf);
            }
        }

        while (stack.size() != 0) {
            System.out.print(stack.get(stack.size() - 1) + " ");
            stack.remove(stack.size() - 1);
        }
    }

    public static void main(String[] args) {
        Graf test = new Graf("graf.txt");
        Graf test2 = new Graf("L7g5.txt");
        // test.printGraf();
        int[][] result = bfs(test, 5);
        System.out.println("Node    Forgj    Dist");
        for (int[] i : result) {
            if (i[1] == -1) {
                System.out.println(i[0] + "       " + " " + "        " + i[2]);
            } else {
                System.out.println(i[0] + "       " + i[1] + "        " + i[2]);

            }
        }
        System.out.println();
        topologiskSok(test2);
    }
}