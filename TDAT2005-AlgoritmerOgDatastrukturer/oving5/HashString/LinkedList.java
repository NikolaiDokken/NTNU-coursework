class LinkedList {
    
    Node hode;
    Node hale;

    public LinkedList(Node node){
        this.hode = node;
        this.hale = node; 
    };

    public Node getHode() {
        return hode;
    }

    public void setHode(Node node) {
        this.hode = node;
    }

    public void setHale(Node node) {
        this.hale = node;
    }

    public void settInnNode(Node nyNode) {
        hale.setNesteNode(nyNode);
        hale = nyNode;
    }

    public void fjernNode(String navn) {
        Node currentNode = hode;
        if (currentNode.getNavn().equals(navn)) {
            hode = hode.getNesteNode();
        }
        while(currentNode.getNesteNode() != null) {
            if (currentNode.getNesteNode().getNavn().equals(navn)) {
                currentNode.fjernNesteNode();
            }
        }
    }

    public String toString() {
        String print = "";
        Node currentNode = hode;
        while (currentNode != null) {
            print += currentNode.getNavn() + "\n";
            currentNode = currentNode.getNesteNode();
        }
        return print;
    }
}   