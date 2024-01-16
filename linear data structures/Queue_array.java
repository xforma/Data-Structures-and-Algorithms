/**
 * this class is demonstrating using queue represented as array that
 * is using circular buffer for saving data using modular arithmetics
 */
public class Queue_array {
    int first;
    int last;
    int[] a;
    int sizeA;

    public Queue_array(int size) {
     a = new int[10];
     first = 0;
     last = 0;
     sizeA = 0;
    }

    public void push(int x) {
        if(sizeA == 0) {
            first = 0;
        }
        last = (sizeA % a.length);
        a[sizeA % a.length] = x;
        sizeA++;
    }

    public void popFromEnd() {
        if(sizeA == 0) {
            System.out.println("array is empty !!");
        }
        else {
            sizeA--; 
            last--;
        }
    }

    public void popFromBeginning() {
        if(sizeA == 0) {
            System.out.println("array is empty !!");
        }
        else {
            moveLeft();
            last--;
        }
    }

    public void print() {
        if(!isEmpty()) {
        for(int i = 0; i < sizeA; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        }
    }

    public boolean isEmpty() {
        return sizeA == 0;
    }

    public boolean contains(int x) {
        while(last != 0 && a[last] != x) {
            last--;
        }
        return a[last] == x;
    }

    public void moveLeft() {
        sizeA--;
        for(int i = 0; i < sizeA; i++ ) {
            a[i] = a[i+1];
        }
    }
}