package com.test.heap;

public class HeapUsingArray {

    class Heap {
        int[] array;
        int sizeOfHeap;

        enum HeapType {
            MIN_HEAP, MAX_HEAP
        }

        HeapType heapType;

        public Heap(int sizeOfArray, HeapType heapType) {
            this.array = new int[sizeOfArray + 1];
            this.heapType = heapType;
            this.sizeOfHeap = 0;
        }
    }

    Heap heap;

    public HeapUsingArray(int sizeOfArray, Heap.HeapType heapType) {
        heap = new Heap(sizeOfArray, heapType);
    }

    private void levelOrderTraversal() {
        System.out.println("-------------- LOT -- Start---------------");
        for (int indx = 1; indx <= heap.sizeOfHeap; indx++) {
            System.out.print(heap.array[indx] + " ");

        }
        System.out.println("\n-------------- LOT -- End-----------------");
    }

    private boolean insert(final int value) {
        if (isHeapFull()) {
            return false;
        }
        heap.array[heap.sizeOfHeap + 1] = value;
        heap.sizeOfHeap++;
        heapifyFromBottomToTop(heap.sizeOfHeap);
//        heapifyBottomToTop(heap.sizeOfHeap,"Min");
        return true;
    }

    private void heapifyFromBottomToTop(int currentNodeIndex) {
        // BC
        if (currentNodeIndex <= 1) {
            return;
        }

        // H & I
        int parentNodeIndex = currentNodeIndex / 2;

        if (heap.heapType.equals(Heap.HeapType.MIN_HEAP)
                && (heap.array[parentNodeIndex] > heap.array[currentNodeIndex])) {
            int tmp = heap.array[currentNodeIndex];
            heap.array[currentNodeIndex] = heap.array[parentNodeIndex];
            heap.array[parentNodeIndex] = tmp;
        }


        if (heap.heapType.equals(Heap.HeapType.MAX_HEAP)
                && (heap.array[parentNodeIndex] < heap.array[currentNodeIndex])) {
            int tmp = heap.array[parentNodeIndex];
            heap.array[parentNodeIndex] = heap.array[currentNodeIndex];
            heap.array[currentNodeIndex] = tmp;
        }
        heapifyFromBottomToTop(parentNodeIndex);
    }

    private boolean isHeapFull() {
        return heap.sizeOfHeap + 1 > heap.array.length - 1;
//        return heap.sizeOfHeap > heap.array.length;
    }

    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) {
            return;
        }
        if (heapType == "Min") {
            if (heap.array[index] < heap.array[parent]) {
                int tmp = heap.array[index];
                heap.array[index] = heap.array[parent];
                heap.array[parent] = tmp;
            }
        } else if (heapType == "Max") {
            if (heap.array[index] > heap.array[parent]) {
                int tmp = heap.array[index];
                heap.array[index] = heap.array[parent];
                heap.array[parent] = tmp;
            }
        }
        heapifyBottomToTop(parent, heapType);

    }

    private int extractValue() {
        if (heapIsEmpty()) {
            return Integer.MIN_VALUE;
        }
        int extractedValue = heap.array[1];
        heap.array[1] = heap.array[heap.sizeOfHeap];
        heap.sizeOfHeap--;
        heapifyFromTop(1);
        return extractedValue;
    }

    private void heapifyFromTop(int currentIndex) {
        // BC

        int left = currentIndex * 2;
        int right = currentIndex * 2 + 1;

        if (left > heap.sizeOfHeap) {
            return;
        }

        // H & I
        int swapIndex = 0;
        if (heap.heapType.equals(Heap.HeapType.MIN_HEAP)) {
            if (left == heap.sizeOfHeap) {
                // This means we have reached the last element and no right child exist
                if (heap.array[currentIndex] > heap.array[left]) {
                    int tmp = heap.array[currentIndex];
                    heap.array[currentIndex] = heap.array[left];
                    heap.array[left] = tmp;
                }
                return;
            } else {
                // Both right and left child exists
                if (heap.array[left] < heap.array[right]) {
                    swapIndex = left;
                } else {
                    swapIndex = right;
                }

                if (heap.array[currentIndex] > swapIndex) {
                    int tmp = heap.array[swapIndex];
                    heap.array[swapIndex] = heap.array[currentIndex];
                    heap.array[currentIndex] = tmp;
                }
            }
        }

        if (heap.heapType.equals(Heap.HeapType.MAX_HEAP)) {
            if (heap.sizeOfHeap == left) {
                // This means we have reached the last element and no right node exist
                if (heap.array[currentIndex] < heap.array[left]) {
                    int tmp = heap.array[currentIndex];
                    heap.array[currentIndex] = heap.array[left];
                    heap.array[left] = tmp;
                }
                return;
            } else {
                if (heap.array[left] > heap.array[right]) {
                    swapIndex = left;
                } else {
                    swapIndex = right;
                }

                if (heap.array[currentIndex] < swapIndex) {
                    int tmp = heap.array[swapIndex];
                    heap.array[swapIndex] = heap.array[currentIndex];
                    heap.array[currentIndex] = tmp;
                }
            }
        }

        heapifyFromTop(swapIndex);

    }

    private boolean heapIsEmpty() {
        return heap.sizeOfHeap == 0;
    }

    public static void main(String[] args) {
        HeapUsingArray minHeap1 = new HeapUsingArray(9, Heap.HeapType.MIN_HEAP);
        System.out.println("Insert of 5 succeeded ? " + minHeap1.insert(5));
        System.out.println("Insert of 4 succeeded ? " + minHeap1.insert(4));
        System.out.println("Insert of 1 succeeded ? " + minHeap1.insert(1));
        System.out.println("Insert of 9 succeeded ? " + minHeap1.insert(9));
        System.out.println("Insert of 7 succeeded ? " + minHeap1.insert(7));
        System.out.println("Insert of 3 succeeded ? " + minHeap1.insert(3));
        System.out.println("Insert of 11 succeeded ? " + minHeap1.insert(11));
        System.out.println("Insert of 8 succeeded ? " + minHeap1.insert(8));
        System.out.println("Insert of 2 succeeded ? " + minHeap1.insert(2));
        minHeap1.levelOrderTraversal();
        System.out.println("Root value of minHeap is " + minHeap1.extractValue());
        minHeap1.levelOrderTraversal();

        System.out.println("Root value of minHeap is " + minHeap1.extractValue());
        minHeap1.levelOrderTraversal();
        System.out.println("Root value of minHeap is " + minHeap1.extractValue());
        minHeap1.levelOrderTraversal();

        HeapUsingArray maxHeap = new HeapUsingArray(5, Heap.HeapType.MAX_HEAP);
        System.out.println("Insert of 10 succeeded ? " + maxHeap.insert(10));
        System.out.println("Insert of 5 succeeded ? " + maxHeap.insert(5));
        System.out.println("Insert of 15 succeeded ? " + maxHeap.insert(15));
        System.out.println("Insert of 1 succeeded ? " + maxHeap.insert(1));
        System.out.println("Insert of 7 succeeded ? " + maxHeap.insert(7));
        maxHeap.levelOrderTraversal();

        HeapUsingArray maxHeap2 = new HeapUsingArray(6, Heap.HeapType.MAX_HEAP);
        System.out.println("Insert of 5 succeeded ? " + maxHeap2.insert(5));
        System.out.println("Insert of 4 succeeded ? " + maxHeap2.insert(4));
        System.out.println("Insert of 1 succeeded ? " + maxHeap2.insert(1));
        System.out.println("Insert of 9 succeeded ? " + maxHeap2.insert(9));
        System.out.println("Insert of 7 succeeded ? " + maxHeap2.insert(7));
        System.out.println("Insert of 2 succeeded ? " + maxHeap2.insert(2));
        maxHeap2.levelOrderTraversal();
    }


}
