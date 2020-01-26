package lists;

public class SinglyLinkedList {
    Node head;


    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /*
    Steps:
    1. If the head is null take care of the tail
    2. Set the value of Node.next to the head
    3. Set the head to the node
    Complexity: O(1)
     */

    // pushing to the front of the list
    public void push(int data) {
        Node node = new Node(data);
        if(head != null) {
            node.next = head;
        }
        head =  node;
    }

    /*
    Steps:
    1. If the head is null (empty list), set the node as the head
    2. Else, set the node to tail.next
    3. Set the end of the list (tail) to the node
    Complexity: O(1) w/ tail
     */

    // pushing to the back of the list
    public void insert(int data) {
        Node node = new Node(data);
        Node curr = head;
        if(head == null) {
            head = node;
            return;
        }
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    /*
    Steps:
    1. Check if the head is the data you are trying to find, if it is return true
    2. Traverse through the tree, if you find the data return true
    3. End of traversal, return false, you have not found the data
    Complexity: O(n)
     */
    public boolean iterativeSearch(int data) {
        Node curr = head;
        while(curr != null && curr.data != data) {
            curr = curr.next;
        }

        if (curr == null) {
            return false;
        }
        return true;

    }

    /*
    Steps:
    1. First check if the node is null, if it is return false
    2. Check if the data is equal to the node data, if it is return true
    3. Call the method again, inputting node.next and data
    Complexity: O(n)
     */
    public boolean recursiveSearch(Node node, int data) {

        if(node == null) {
            return false;
        }

        if(node.data == data) {
            return true;
        }

        return recursiveSearch(node.next, data);
    }

    /*
    Steps:
    1. Check to see if the head if the head is null
    2. Check to see if the head should be deleted
    3. Traverse the list while the node is not null and the data is not equal
    4. At the end, check to see if the node is null, if so do nothing, the value is not in the list
    5. If the tail is the node, then set the new tail to the previous node
    6. Else, delete the node
    Complexity: O(n)
     */

    public void delete(int data) {
        Node curr = head;
        Node prev = null;

        if(head.data == data) {
            head = head.next;
            return;
        }

        while(curr!=null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if(curr.data == data) {
            prev.next = curr.next;
        }

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
