package lists;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    Stack stack;

    @Before
    public void setup() {
        stack = new Stack(10);
    }

    @Test
    public void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(1, stack.arr[0]);
        assertEquals(2, stack.arr[1]);
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
    }

    @Test(expected = RuntimeException.class)
    public void testPop_throwsError() {
        stack.pop();
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.peek());
        assertEquals(4, stack.top);
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        assertEquals(true, stack.isFull());
    }

}
