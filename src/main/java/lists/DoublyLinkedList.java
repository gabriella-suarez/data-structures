package lists;

public class DoublyLinkedList {

    Node head;
    Node tail;

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }
    }



    // push
    public void push(int data) {
        Node node = new Node(data);
        if(head == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    // insert
    public void insert(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    // iterative search
    public boolean iterativeSearch(int data) {
        Node curr = head;

        while(curr != null && curr.data != data) {
            curr = curr.next;
        }
        if(curr == null) {
            return false;
        }
        return true;
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
        Node curr = head;

        if(head.data == data) {
            head = head.next;
            head.prev = null;
            return;
        }

        while(curr != null && curr.data != data) {
            curr = curr.next;
        }

        if(curr == null) {
            return;
        }

        if(curr == tail) {
            tail = curr.prev;
            tail.next = null;
            return;
        }

        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;

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
