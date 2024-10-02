class Klient {
    public static void main(String[] args) {
        FilLeser m = new FilLeser();

        m.lesNoderOgKanter("nordenNoder.txt", "nordenKanter.txt");
        // m.lesNoderOgKanter("islandNoder.txt", "islandKanter.txt");
        System.out.println("Lest ferdig");

        long startTime = System.nanoTime();
        // Graf.astar(Graf.node[5108028], Graf.node[5709083], true); // Gjemnes-Kårvåg

        // Oslo-Kristiansand
        Graf.astar(Graf.node[3267443], Graf.node[3147229], true);

        // Reykjavík–Hafnarfjörður
        // Graf.astar(Graf.node[3023], Graf.node[14416], true);

        // Oslo til Bergen
        // Graf.astar(Graf.node[30236], Graf.node[94114], true);

        // Kristiansund til Helsinki
        // Graf.astar(Graf.node[2058549], Graf.node[1051859], false);

        // Graf.astar(Graf.node[3237536], Graf.node[1881040], false); // Test
        long stopTime = System.nanoTime();
        System.out.println("Runtime: " + (stopTime - startTime) / 1000000000);

    }
}