/*
 * A class for managing lists of Nodes, whose values are integers and they have a 
 * one-sided reference to their next Node.
 * This lists maintains among with next Nodes also first and last node.
 */

public class Linked_list {
    // Attributes
    Node first;
    Node last;
    int cursor;
    int size;

    /*
     * Creates a new empty list and sets its attributes values.
     */
    public Linked_list() {
        size = cursor = 0;
        first = last = null;
    }

    /*
     * inserts a new Node at the beggining of the list. If the list already contains
     * some node,
     * this node is shifted and newly created nodes becomes the first one, with
     * making reference
     * to the next node (previously created one).
     * 
     * @param x, integer value of the newly created node
     */
    public void insertAtBeggining(int x) {
        Node nNode = new Node(x);
        if (first == null) {
            first = nNode;
            last = nNode;
        } else {
            nNode.setNext(first); // (1) connects the first node to the new of the newly created node
            first = nNode; // (2) new node becomes the first with reference to the previous one
        }
        size++;
    }

    /*
     * inserts a new Node at the end of the list.
     * If the list contains some nodes, the last one is found (does not have
     * reference to the next node)
     * and this last node is added to the list, by making a reference and setting
     * the last node. The new
     * node becomes the last one after making the reference.
     * 
     * @param int value x of the node
     */

    public void insertAtEnd(int x) {
        Node nNode = new Node();
        {
            Node newNode = new Node(x);
            if (first == null) {
                first = nNode;
                last = nNode;
            } else {
                nNode = first;
                while (nNode.getNext() != null) {
                    nNode = nNode.getNext(); // (1) finding last node
                }
                nNode.setNext(newNode); // (2) making reference to the last (found) node and setting new node as the
                                        // next node that will become last later
                last = newNode; // (3) setting up updated last node.
            }
        }
        size++;
    }

    /*
     * Method for choosing at which position a new node should be inserted.
     * Cursoring starts with 1, where 1 indicates start of the list and all the
     * previous values
     * are moved to the left.
     * 
     * @param int value of desired position, where new node should be inserted
     * 
     * @value, int attribue of Node value
     */
    public void insertAt(int cursor, int value) { // 1 = 1st place, 2 = 2nd place...
        Node nNode = new Node();
        Node newNode = new Node(value);
        if (cursor == 1) { // inserting at first position
            insertAtBeggining(value);
        } else {
            if (cursor == (size + 1)) { // insertig at last position
                insertAtEnd(value);
            } else if (cursor > size) {
                System.out.println("position does not exist !");
            } else { // inserting at desired position
                nNode = first;
                for (int i = 2; i < cursor; i++) { // inserting at desired position
                    nNode = nNode.getNext(); // (1) indexing at for loop starts with 2, because firstly a node before
                                             // desired
                } // cursor's place where new node should be insterted is found and then inserted
                  // at this place, and rest of the nodes is moved to the left
                newNode.setNext(nNode.getNext()); // (2) making a reference of newly added node to the other nodes
                nNode.setNext(newNode); // (3) setting up reference of the previous node before newly added node
                size++;
            }
        }
    }

    public void deleteFirst() {
        first = first.getNext();
        size--;
    }

    public void deleteLast() {
        Node nNode = new Node();
        nNode = first;
        while (nNode.getNext().getNext() != null) {
            nNode = nNode.getNext();
        }
        last = nNode;
        last.setNext(null);
        size--;
    }

    public void deleteAt(int cursor) {
        Node nNode = new Node();
        if (cursor == 1) {
            first = first.getNext();
            size--;
        } else if (cursor == size) {
            nNode = first;
            while (nNode.getNext().getNext() != null) {
                nNode = nNode.getNext();
            }
            nNode.setNext(null);
            last = nNode;
            size--;
        } else if (cursor < size) {
            nNode = first;
            for (int i = 1; i < cursor - 1; i++) {
                nNode = nNode.getNext();
            }
            nNode.setNext(nNode.getNext().getNext());
            size--;
        } else
            System.out.println("cursor out of the range !");
    }

    public int getSize() {
        return size;
    }

    public void print() {
        Node nNode = new Node();
        nNode = first;
        System.out.print("first --> ");
        while (nNode.getNext() != null) {
            System.out.print(nNode.getValue() + " ");
            nNode = nNode.getNext();
        }
        System.out.print(last.getValue() + " <-- last ");
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int value) {
        Node nNode = new Node();
        nNode = first;
        while (nNode.getNext() != null && nNode.getValue() != value) {
            nNode = nNode.getNext();
        }
        return nNode.getValue() == value;
    }

    public void set(int cursor, int x) {
        Node nNode = new Node();
        if (cursor == 1) {
            first.setValue(x);
        }
        if (cursor == size) {
            last.setValue(x);
        } else if (cursor < size) {
            nNode = first;
            for (int i = 1; i < cursor; i++) {
                nNode = nNode.getNext();
            }
            nNode.setValue(x);
        } else {
            System.out.println("this place in the list does not exist !");
        }
    }

}