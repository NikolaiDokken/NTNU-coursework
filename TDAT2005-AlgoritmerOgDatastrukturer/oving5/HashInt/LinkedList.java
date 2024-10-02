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

    public void fjernNode(int numb) {
        Node currentNode = hode;
        if (currentNode.getNumb() == numb) {
            hode = hode.getNesteNode();
        }
        while(currentNode.getNesteNode() != null) {
            if (currentNode.getNesteNode().getNumb() == numb) {
                currentNode.fjernNesteNode();
            }
        }
    }

    public String toString() {
        String print = "";
        Node currentNode = hode;
        while (currentNode != null) {
            print += currentNode.getNumb() + "\n";
            currentNode = currentNode.getNesteNode();
        }
        return print;
    }
}   