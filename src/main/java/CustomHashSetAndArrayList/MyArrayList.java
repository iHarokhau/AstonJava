package CustomHashSetAndArrayList;

import java.util.*;

class MyArrayList {
    private static final int SIZE = 10;

    private int[] mas = new int[SIZE];
    private int elements = 0;

    MyArrayList() {
    }

    public void add(int x) {
        mas[elements] = x;
        elements += 1;
    }

    public int get(int i) {
        checkIndex(i);
        return mas[i];
    }

    public void remove(int x) {
        checkIndex(x);
        for (int i = x; i < elements; i++) {
            mas[i] = mas[i + 1];
        }
        elements -= 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(mas, elements));
    }

    public void addAll(int[] x) {
        for (int i = 0; i < x.length; i++) {
            mas[elements] = x[i];
            elements += 1;
        }
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= elements) {
            throw new IndexOutOfBoundsException("Index: " + i + "elements:" + elements);
        }
    }

}
