package CustomHashSetAndArrayList;

class MyHashSet {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node[] buckets;
    private int size;

    public MyHashSet(int min, int max) {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    public void add(int value) {
        if (contains(value)) {
            return;
        }
        int index = getIndex(value);
        Node newNode = new Node(value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size += 1;
        if (size > LOAD_FACTOR * buckets.length) {
            rehash();
        }
    }

    public void remove(int value) {
        int index = getIndex(value);
        Node head = buckets[index];
        Node prev = null;

        while (head != null) {
            if (head.value == value) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                size -= 1;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    private int getIndex(int value) {
        return hash(value) % (buckets.length - 1);
    }

    private void rehash() {
        Node[] oldBuckets = buckets;
        buckets = new Node[2 * oldBuckets.length];
        size = 0;

        for (Node head : oldBuckets) {
            while (head != null) {
                add(head.value);
                head = head.next;
            }
        }
    }

    private int hash(int value) {
        int hash = value * buckets.length;
        return hash ^ (hash >>> 16);
    }

    public boolean contains(int value) {
        int index = getIndex(value);
        Node head = buckets[index];
        //Проверка на существование элемента
        while (head != null) {
            if (head.value == value) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
