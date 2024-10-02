class Node {
    private Node nesteNode;
    private int verdi;

    public Node(int verdi) {
        this.nesteNode = null;
        this.verdi = verdi;
    }

    public void setNesteNode(Node nesteNode) {
        this.nesteNode = nesteNode;
    }

    public Node getNesteNode() {
        return nesteNode;
    }

    public int getVerdi() {
        return verdi;
    }
}