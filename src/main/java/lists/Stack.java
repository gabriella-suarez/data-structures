package lists;

public class Stack {

    int[] arr;
    int top;
    int capacity;

    public Stack(int size) {
        arr = new int[size];
        this.top = -1;
        this.capacity = size;
    }

    public void push(int data) {
        if(isFull()) {
            throw new RuntimeException("stack is full, stack overflow");
        }
        arr[++top] = data;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("stack is empty nothing to pop");
        }
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

}
