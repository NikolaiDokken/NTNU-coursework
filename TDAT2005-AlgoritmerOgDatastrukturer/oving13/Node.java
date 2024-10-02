class Node {
    double breddegrad;
    double lengdegrad;
    int id;
    Kant kant1;
    Object d;
    double cosBredde = Math.cos((this.breddegrad * Math.PI) / 180.0);
}

class Forgj {
    int distanseTilStart;
    int prioritet;
    int kjoretid;
    Node forgj;
    static int uendelig = Integer.MAX_VALUE;

    public Forgj() {
        distanseTilStart = uendelig;
    }
}