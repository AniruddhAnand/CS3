public class GemList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Gem gem; //does a private inner class need private instance variables?
        Node next;

        public Node(Gem val) {
            this.gem = val;
        }

        @Override
        public String toString() {
            return "" + this.gem;
        } //for printing / debug
    }

    GemList() {
        head = null;
        size = 0;
    }

    GemList(Gem val) {
        head = new Node(val);
        tail = head;
        size = 1;
    }

    GemList(Gem... args) {
        for (Gem t : args) {
            add(t);
        }
    }

    public void insertBefore(Gem gem, int index) {
        if (index >= size) {
            add(gem);
        } else {
            add(gem, index);
        }
    }

    private void add(Gem newVal) {
        if (size == 0) {
            head = new Node(newVal);
            tail = head;
            size++;
            return;
        }
        tail.next = new Node(newVal);
        tail = tail.next;
        size++;
    }

    private void add(Gem newVal, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node x = new Node(newVal);
        if (index == 0) {
            x.next = head;
            head = x;
            return;
        } else if (index == size) {
            add(newVal);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        x.next = temp.next;
        temp.next = x;
        size++;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Node temp = head;
        String s = "[";
        while (temp != null) {
            s += temp.toString();
            temp = temp.next;
            if (temp != null) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

    public void draw(double y) {
        double x = 0;
        Node current = head;
        while (current != null) {
            current.gem.draw(x, y);
            current = current.next;
            x += .06;
        }
    }

    int score() {
        int score = 0;
        Node current = head;
        while (current != null) {
            int rep = 1;
            int tempScore = current.gem.points;
            GemType type = current.gem.type;
            current = current.next;
            while (current != null && current.gem.type == type) {
                rep++;
                tempScore += current.gem.points;
                current = current.next;
            }
            score += rep * tempScore;
        }
        return score;
    }

    public static void main(String[] args) {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);

        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);

        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.7);

        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);

        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.5);

        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.4);

        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);
    }
}
