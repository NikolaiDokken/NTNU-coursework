class Kant {
    Kant neste;
    Node til;

    public Kant(Kant nst, Node n) {
        this.til = n;
        this.neste = nst;
    }
}

class VKant extends Kant {
    int vekt;

    public VKant(VKant nst, Node n, int vkt) {
        super(nst, n);
        this.vekt = vkt;
    }
}