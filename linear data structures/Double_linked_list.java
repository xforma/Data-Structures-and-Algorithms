public class Double_linked_list {
    /*
     * Class for managing lists of integers by using a double-linked sequence
     * as internal representation.
     */

    Node first; // first node of the list
    Node last; // last node of the list
    int size; // size of the list
    int cursor; // pointer designed for pointing at certain nodes

    // Constructors

    /*
     * Creates a new, double-linked empty list
     */
    public Double_linked_list() {
        size = cursor = 0;
        first = last = null;
    }

    // Other methods

    /*
     * @return <code>true</code> if the list is empty, <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * @returns integer indicating size of the list
     */
    public int getSize() {
        return size;
    }

    /*
     * Appends a new Node at the beggining of the list.
     * If list already contains some Node, then the first Node is moved to second
     * place
     * and newly inserted Node becomes the first one. Same action happends with last
     * node.
     */
    public void insertAtBeggining(int value) {
        Node nNode = new Node(value);
        if (isEmpty()) {
            first = nNode;
            last = nNode;
        } else {
            first.setPrevious(nNode); // (1) setting first node, as the second one
            nNode.setNext(first); // (2) setting up rerefence of the second node, to the newly inserted first one
                                  // (step 3)
            first = nNode; // (3) setting newly inserted node as the first one
        }
        size++;
    }

    /*
     * Appends a new Node at the end of the list.
     * If list already contains some Node, then the first Node is moved to second
     * place
     * and newly inserted Node becomes the first one. Same action happends with last
     * node.
     */
    public void insertAtEnd(int value) {
        Node nNode = new Node(value);
        if (isEmpty()) {
            first = nNode;
            last = nNode;
        } else {
            last.setNext(nNode); // (1) moving last node, as the (last-1) node
            nNode.setPrevious(last); // (2) setting up reference of the last node, for setting new end node in step 3
            last = nNode; // (3) setting newly inserted node as the last one
        }
        size++;
    }

    /*
     * Inserts Node on a desired positon. Method is using integer number for
     * refering to a desired position.
     * New value is added to this position (starts with 1) and rest of the list is
     * moved to the right.
     * 
     * @param cursor, for reffering at the point of interest (place in the list
     * starting from 1)
     * 
     * @param value, the new value to be stored at cursor position
     */
    public void insertAt(int cursor, int value) {
        Node nNode = new Node();
        Node newNode = new Node(value);
        if (cursor == 1) { // inserting at first position
            insertAtBeggining(value);
        } else {
            if (cursor == (size + 1)) { // insertig at last position
                insertAtEnd(value);
            } else if (cursor > size) { // trivial case
                System.out.println("position does not exist !");
            } else { // inserting bewteen first and last position
                nNode = first;
                for (int i = 1; i < cursor; i++) {
                    nNode = nNode.getNext();
                }
                nNode.getPrevious().setNext(newNode);
                newNode.setNext(nNode);
                newNode.setPrevious(nNode.getPrevious());
                nNode.setPrevious(newNode);
                nNode = first;
                for (int i = 1; i < cursor - 1; i++) {
                    nNode = nNode.getNext();
                }
                size++;
            }
        }
    }

    /*
     * Removes Node from the first position.
     */
    public void deleteFirst() {
        first.getNext().setPrevious(null);
        first = first.getNext();
        size--;
    }

    /*
     * Removes Node from the last position
     */
    public void deleteLast() {
        last.getPrevious().setNext(null);
        last = last.getPrevious();
        size--;
    }

    /*
     * Removes Node from the desired position. Method is using integer value for
     * refering
     * to a point of interest. Numbering starts with 1, where 1 is the first
     * element.
     * 
     * @param cursor, for reffering at the point of interest (place in the list)
     * starting from 1)
     */
    public void deleteAt(int cursor) {
        Node nNode = new Node();
        if (cursor == 1) {
            deleteFirst();
        } else if (cursor == size) {
            deleteLast();
        } else if (cursor < size) {
            nNode = first;
            for (int i = 1; i < cursor; i++) {
                nNode = nNode.getNext();
            }
            nNode.getNext().setPrevious(nNode.getPrevious());
            nNode.getPrevious().setNext(nNode.getNext());
            size--;
        }
    }

    /*
     * Creates a Node, which is moved from the first position to the last, and at
     * each position
     * is the value of a Node compared with the searched one. Loop stops when value
     * is found,
     * or a last node is reached.
     * 
     * @param value, to be found in the list
     * 
     * @return <code>true</code> if the list contains certain value,
     * <code>false</code> otherwise.
     */
    public boolean contains(int value) {
        Node nNode = new Node();
        nNode = first;
        while (nNode.getNext() != null && nNode.getValue() != value) {
            nNode = nNode.getNext();
        }
        return nNode.getValue() == value;
    }

    /*
     * Replaces the integer at position given by cursor
     * 
     * @param cursor, for reffering at the point of interest (place in the list)
     * 
     * @param value, the new value to be stored at cursor position
     */
    public void set(int cursor, int value) {
        Node nNode = new Node();
        if (cursor == 1) {
            first.setValue(value);
        }
        if (cursor == size) {
            last.setValue(value);
        } else if (cursor < size) {
            nNode = first;
            for (int i = 1; i < cursor; i++) {
                nNode = nNode.getNext();
            }
            nNode.setValue(value);
        } else {
            System.out.println("this place in the list does not exist !");
        }
    }

    /*
     * Prints the values of the nodes in the list from first to last
     */
    public void print() {
        Node nNode = new Node();
        nNode = first;
        System.out.print("first --> ");
        while (nNode.getNext() != null) {
            System.out.print(nNode.getValue() + "-");
            nNode = nNode.getNext();
        }
        System.out.print(nNode.getValue() + " <-- last ");
        System.out.println();
    }

    /*
     * Prints the values of the nodes in the list from last to first
     */
    public void reversePrint() {
        Node nNode = new Node();
        nNode = last;
        System.out.print("last  --> ");
        while (nNode.getPrevious() != null) {
            System.out.print(nNode.getValue() + " ");
            nNode = nNode.getPrevious();
        }
        System.out.print(nNode.getValue() + " <-- first ");
        System.out.println();
    }

}
