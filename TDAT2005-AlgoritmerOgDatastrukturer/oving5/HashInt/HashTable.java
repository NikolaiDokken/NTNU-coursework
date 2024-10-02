class HashTable {

    private LinkedList[] list;

    public HashTable(int size) {
        this.list = new LinkedList[size];
    }

    public int hashFirst(int numb) {
        return numb % list.length;
    }

    public int hashSecond(int hashedNumb) {
        return (hashedNumb % (list.length - 1)) + 1;
    }

    public boolean settInnNumb(int numb) {
        int index = hashFirst(numb);
        if (list[index] == null) {
            list[index] = new LinkedList(new Node(numb));
            return false;
        } else {
            int newIndex = hashSecond(index);
            if (list[newIndex] == null) {
                list[newIndex] = new LinkedList(new Node(numb));
                return false;
            } else {
                list[newIndex].settInnNode(new Node(numb));
                return true;
            }
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