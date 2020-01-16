package lists;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTest {

     SinglyLinkedList testList = new SinglyLinkedList();

    @Before
    public void setup() {
        testList.insert(1);
        testList.insert(2);
        testList.insert(3);
        testList.insert(4);
    }

    @Test
    public void pushTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);

        assertEquals(3, list.head.data);
        assertEquals(2, list.head.next.data);
        assertEquals(1, list.head.next.next.data);
        assertEquals(1, list.tail.data);

        System.out.println("push test: " + list.toString());
    }

    @Test
    public void insertTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        assertEquals(1, list.head.data);
        assertEquals(2, list.head.next.data);
        assertEquals(3, list.head.next.next.data);

        System.out.println("insert test: " + list.toString());
    }

    @Test
    public void iterativeSearchTest() {
        assertEquals(true, testList.iterativeSearch(3));
        assertEquals(false, testList.iterativeSearch(30));

        System.out.println("iterative test: " + testList.toString());
    }

    @Test
    public void recursiveSearchTest() {
        assertEquals(true, testList.recursiveSearch(testList.head,3));
        assertEquals(false, testList.recursiveSearch(testList.head,30));

        System.out.println("recursive test: " + testList.toString());
    }

    @Test
    public void deleteTest() {
        testList.delete(6);
        assertEquals(1, testList.head.data);

        System.out.println("Should delete nothing: " + testList.toString());

        testList.delete(2);
        assertEquals(3, testList.head.next.data);
        assertEquals(1, testList.head.data);

        System.out.println("Should delete two: " + testList.toString());

        testList.delete(4);
        assertEquals(3, testList.tail.data);

        System.out.println("Should delete four or the tail: " + testList.toString());

        testList.delete(1);
        assertEquals(3, testList.head.data);
        assertEquals(3, testList.tail.data);

        System.out.println("Should delete everything but the three: " + testList.toString());

    }


}
