package CustomHashSetAndArrayList;

public class Main {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet(1, 10);
        myHashSet.add(5);
        myHashSet.add(8);
        System.out.println(myHashSet.contains(8));
        myHashSet.remove(8);
        System.out.println(myHashSet.contains(8));
        System.out.println(myHashSet.contains(5));

        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.toString());
        list.add(7);
        System.out.println(list.toString());
        list.remove(3);
        System.out.println(list.toString());
        System.out.println(list.get(3));
        list.addAll(new int[]{8, 9, 10});
        System.out.println(list.toString());
    }
}