class HashTable {

    private LinkedList[] list;

    public HashTable(int size) {
        this.list = new LinkedList[size];
    }

    public int stringIndex(String text) {
        int textLength = text.length();
        int value = 0;
        for(int i = 0; i < textLength; i++) {
            value = (value + (int)text.charAt(i) * i) % list.length;
        }
        return value;
    }

    public boolean settInnNavn(String navn) {
        int index = stringIndex(navn);
        if (list[index] == null) {
            list[index] = new LinkedList(new Node(navn));
            return false;
        } else {
            list[index].settInnNode(new Node(navn));
            return true;
        }
    }

    public boolean sokPerson(String navn) {
        int index = stringIndex(navn);
        if (list[index] == null) {
            return false;
        } else {
            Node currentNode = list[index].getHode();
            if (currentNode.getNavn().equals(navn)) {
                return true;
            }
            while (currentNode.getNesteNode() != null) {
                if (currentNode.getNesteNode().getNavn().equals(navn)) {
                    return true;
                }
                currentNode = currentNode.getNesteNode();
            }
            return false;
        }
    }

    public String toString() {
        String print = "";
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                print += list[i].toString() + "\n";
            }
        }
        return print;
    }

    public String toString(int index) {
        String print = "";
            if (list[index] != null) {
                print = list[index].toString();
            }
        return print;
    }

    public int getSize() {
        return list.length;
    }
}