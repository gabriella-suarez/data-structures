package heap;

public class MaxHeap {
    int heapSize;
    int heap[];
    int maxsize;

    public MaxHeap(int maxsize) {
        this.heap = new int[maxsize];
        this.maxsize = maxsize;
        heapSize = 0;
    }

    // builds a heap from a fixed array
    public void buildMaxHeap(int[] arr) {
        this.heap = arr;
        this.maxsize = arr.length;
        this.heapSize = arr.length;
        for(int i = arr.length/2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    // inserts value into class level heap
    public void insert(int key) {
        int current = heapSize;
        heap[current] = Integer.MIN_VALUE;
        heapIncreaseKey(heap, current, key);
        heapSize++;
    }

    public void heapsort() {
        buildMaxHeap(heap);
        for(int i = heap.length - 1; i >= 1; i--) {
            int tmp = heap[i];
            heap[i] = heap[0];
            heap[0] = tmp;
            heapSize = heapSize - 1;
            maxHeapify(heap, 0);
        }
    }

    public int heapMax() {
        return this.heap[0];
    }

    public int extractHeapMax() {
        if(heapSize < 0) {
            throw new RuntimeException("heap underflow");
        }
        int min = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize = heapSize - 1;
        maxHeapify(heap, 0);
        return min;
    }


    public boolean isMaxHeap(int startIndex, int endIndex) {
        if (startIndex > (endIndex - 2) / 2) {
            return true;
        }

        if (heap[startIndex] >= heap[right(startIndex)] && heap[startIndex] >= heap[left(startIndex)]
                && isMaxHeap(right(startIndex), endIndex) && isMaxHeap(left(startIndex), endIndex)) {
            return true;
        }

        return false;

    }

    private void maxHeapify(int[] arr, int index) {
        int left = left(index);
        int right = right(index);
        int largest;
        if(left < heapSize && arr[left] > arr[index]) {
            largest = left;
        } else {
            largest = index;
        }
        if(right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != index) {
            int tmp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = tmp;
            maxHeapify(arr, largest);
        }
    }

    private void heapIncreaseKey(int[] arr, int index, int key) {
        if(key < arr[index]) {
            throw new RuntimeException("new key is larger than current key");
        }
        arr[index] = key;
        while(index > 0 && arr[parent(index)] < arr[index]) {
            int tmp = arr[index];
            arr[index] = arr[parent(index)];
            arr[parent(index)] = tmp;
            index = parent(index);
        }
    }


    private int parent(int index) {
        return (index - 1)/2;
    }

    private int right(int index) {
        return 2*index + 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    @Override
    public String toString() {
        printArray();
        return "MaxHeap{" +
                "heapSize=" + heapSize +
                '}';
    }

    private void printArray() {
        for(int i = 0; i < this.heap.length; i++) {
            System.out.print(" " + heap[i] + " ");
        }
        System.out.println();
    }
}
