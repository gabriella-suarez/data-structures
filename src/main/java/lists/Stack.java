package lists;

public class Stack {
    int arr[];
    int capacity;
    int top;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("Error: Stack is full");
        }
        arr[++top] = data;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Error: Stack is empty");
        }
        return arr[top--];
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

}
