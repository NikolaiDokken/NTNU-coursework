class Node {
    private int numb;
    private Node nesteNode;

    public Node(int numb) {
        this.numb = numb;
    }

    public void setNesteNode(Node node) {
        this.nesteNode = node;
    }

    public Node getNesteNode() {
        return nesteNode;
    }

    public int getNumb() {
        return numb;
    }

    public void fjernNesteNode() {
        if (this.nesteNode != null) {
            this.nesteNode = this.nesteNode.getNesteNode();
        }
    }
}