public class Stack_linked {
    Node top;
    int size;
 
    public Stack_linked() {
        size = 0;
        top = null;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }   
    public void push(int x) {
        Node nNode = new Node(x);
        if(top == null) {
            top = nNode;
        }
        else {
            nNode.setPrevious(top);
            top = nNode;
        }
        size++;
    }

    public int push2(int x) {
        Node nNode = new Node(x);
        if(top == null) {
            top = nNode;
        }
        else {
            nNode.setPrevious(top);
            top = nNode;
        }
        size++;
        return top.getValue();
    }

    public void pop() {         //removes top of the stack from the stack
        if(top == null) {
            System.out.println("nothing to pop !");
        }
        else {
        top = top.getPrevious();
        size--;
        }
    }
    
    public int pop2() {
        if(top == null) {
            System.out.println("nothing to pop !");
            return -1;
        }
        else {
            int temp = top.getValue();
            top = top.getPrevious();
            size--;
            return temp;
        }
    }

    public boolean contains(int x) {
        while(top.getValue() != x) {
            top = top.getPrevious();
        }
        return top.getValue() == x;
    }
    public boolean contains2(int x) {
        while(top.getValue() != x && size != 1) {
            pop();
        }
        return top.getValue() == x;
    }

    public void print() {
        Node nNode = new Node();
        nNode = top;
        System.out.print("top-"+top.getValue()+"- ");
        while(nNode.getPrevious() != null) {
            nNode = nNode.getPrevious();
            System.out.print(nNode.getValue()+" ");
        }
    } 
    
    public int top() {
        return top.getValue();
    }

    public static Stack_linked removeGreaterThan(Stack_linked q, int x) {
        Stack_linked output = new Stack_linked();
        Stack_linked temp = new Stack_linked();
        while(!q.isEmpty()) {
            if(q.top() < x) {
                temp.push2(q.top());
            }
            output.push(q.pop2());
        }
        temp.print();
       return output;
    }
}
