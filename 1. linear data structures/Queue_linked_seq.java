public class Queue_linked_seq {
    Node first;
    Node last;
    int cursor;
    int size;
    
    public Queue_linked_seq() {        
    }

    public void push(int value) {
        Node nNode = new Node(value);
        if(isEmpty()) {
            first = nNode;
            last = nNode;
        }
        else {
          last.setNext(nNode);
          last = nNode;
            }
        size++;
    }

    public void insertAt(int value) {
        
    }

    public void popFromBegging() {
        if(isEmpty()) {
            System.out.println("Queue is empty !!");
        }
        else {
            first = first.getNext();
            size--;
        }
    }

    public void popFromEnd() {
        if(isEmpty()) {
            System.out.println("queue is empty !!");
        }
        else {
            Node nNode = new Node();
            nNode = first;
            while(nNode.getNext().getNext() != null) {
            nNode = nNode.getNext();
            }
            last = nNode;
            last.setNext(null);
            size--;
        }
    }

    public void deleteAt(int cursor) {
        if(cursor == 1) {
            popFromBegging();
        }
        else if(cursor == size) {
            popFromEnd();
        }
        else if(cursor < size) {
            Node nNode = new Node();
            nNode = first;
            for(int i = 1; i < cursor-1; i++) {
                nNode = nNode.getNext();
            }
            nNode.setNext(nNode.getNext().getNext());
            size--;
        }
        else System.out.println("wrong cursor !!");
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void print() {
        Node nNode = new Node();
        nNode = first;
        System.out.print(nNode.getValue()+" ");
        while(nNode != last) {
            nNode = nNode.getNext();
            System.out.print(nNode.getValue()+" ");
        }
    }

}
