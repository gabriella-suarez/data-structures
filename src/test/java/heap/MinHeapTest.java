package heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinHeapTest {

    MinHeap minHeap;

    @Before
    public void setup() {
        minHeap = new MinHeap(12);
        minHeap.insert(1);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(7);
        System.out.println(minHeap.toString());
    }

    @Test
    public void testInsertMinHeap() {
        assertEquals(true, minHeap.isMinHeap(0,3));
    }

    @Test
    public void testHeapMin() {
        assertEquals(1, minHeap.heapMin());
    }

    @Test
    public void testExtractMinHeap() {
        assertEquals(1, minHeap.extractHeapMin());
        System.out.println(minHeap.toString());
        assertEquals(2, minHeap.heapMin());
    }

    @Test
    public void testHeapSort() {
        minHeap.heapsort();
        assertEquals(7, minHeap.heap[0]);
    }


    @Test
    public void testBuildMinHeap() {
        int arr[] = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        MinHeap minHeap = new MinHeap(10);
        minHeap.buildMinHeap(arr);
        System.out.println(minHeap.toString());
        assertEquals(true, minHeap.isMinHeap(0, 9));
    }

}
