public class Stack_array {
    int[] a;
    int top;        //top of the stack
    int size;       //size of the stack

    public Stack_array(int x) {
        a = new int[x];
    }

    public void push(int value) {
        if(isEmpty()) {
            a[top] = value;
        }
        else {
            top++;
            a[top] = value;
        }
        size++;
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("array is empty !");
        }
        else {
            top--;
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for(int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("size: "+size);
    }

    public void print2() {
        System.out.println("top pointer: "+top);
        System.out.println("+a[top] "+a[top]);
    }
    
    public void moveRight() {
        for(int i = 0; i < size; i++) {
            a[i] = a[i+1];
        }
    }

    public boolean contains(int x) {
        while(a[top] != x && top != 0) {
            top--;
        }
        return a[top] == x;
    }

    public boolean contains2(int x) {
        while(a[top] != x && size != 1) {
            pop();
        }
        return a[top] == x;
    }
}