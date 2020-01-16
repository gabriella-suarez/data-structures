package lists;

public class DoublyLinkedList {

    Node head;
    Node tail;

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // push
    public void push(int data) {
        Node node = new Node(data);
        if(head == null) {
            node.prev = tail;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
        }
        head = node;
    }

    // insert
    public void insert(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    // iterative search
    public boolean iterativeSearch(int data) {
        Node current = head;

        while(current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // recursive search
    public boolean recursiveSearch(Node node, int data) {
        if(node == null) {
            return false;
        }
        if(node.data == data) {
            return true;
        }
        return recursiveSearch(node.next, data);
    }

    public void printBackwards() {
        Node current = tail;
        while(current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    public void delete(int data) {
        Node current = head;

        // delete head
        if(head != null && head.data == data) {
            head = head.next;
            head.prev = null;
            return;
        }

        while(current != null && current.data != data) {
            current = current.next;
        }

        if(current == null) {
            return;
        }

        if (current == tail) {
            tail = current.prev;
            current.prev.next = null;
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    @Override
    public String toString() {
        String s = "" + head.data;
        Node curr = head.next;
        while(curr != null) {
            s = s + " -> " + curr.data;
            curr = curr.next;
        }
        return s;
    }


}
