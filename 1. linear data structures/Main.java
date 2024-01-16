public class Main {
    public static void main(String[] args) throws Exception {
        Linked_list l = new Linked_list();
        l.insertAt(1, 100);
        l.insertAt(2, 65);
        l.insertAt(3, 945);
        l.insertAt(4, 9987);
        l.insertAt(5, 9945);
        l.print();
        System.out.println();
        l.insertAt(3, 0);
        l.print();
    }

}