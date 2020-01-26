package heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxHeapTest {
    MaxHeap maxHeap;

    @Before
    public void setup() {
        maxHeap = new MaxHeap(12);
        maxHeap.insert(1);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(7);
        System.out.println(maxHeap.toString());
    }

    @Test
    public void testInsertMinHeap() {
        assertEquals(true, maxHeap.isMaxHeap(0,3));
    }

    @Test
    public void testHeapMax() {
        assertEquals(7, maxHeap.heapMax());
    }

    @Test
    public void testExtractMaxHeap() {
        assertEquals(7, maxHeap.extractHeapMax());
        System.out.println(maxHeap.toString());
        assertEquals(6, maxHeap.heapMax());
    }

    @Test
    public void testHeapSort() {
        maxHeap.heapsort();
        System.out.println(maxHeap.toString());
        assertEquals(0, maxHeap.heap[0]);
    }


    @Test
    public void testBuildMinHeap() {
        int arr[] = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.buildMaxHeap(arr);
        System.out.println(maxHeap.toString());
        assertEquals(true, maxHeap.isMaxHeap(0, 9));
        maxHeap.heapsort();
        System.out.println(maxHeap.toString());
        assertEquals(1, maxHeap.heap[0]);

    }
}
