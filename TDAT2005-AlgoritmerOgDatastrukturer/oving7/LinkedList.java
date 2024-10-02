
// Dette blir en klasse for de "vertikale" listene som skal inneholde "barna" til en node
class LinkedList {
    private Node hode;
    private Node hale;

    public LinkedList(Node hode) {
        this.hode = hode;
        this.hale = hode;
    }

    public Node getHode() {
        return hode;
    }

    public void leggTilNode(Node nyNode) {
        hale.setNesteNode(nyNode);
        this.hale = nyNode;
    }
}