package com.test.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ImplementHeapTry {

    static class MinHeap {
        private int[] heap;
        private int capacity =5;
        private int size=0;


        public MinHeap() {
            this.heap = new int [capacity];
        }

        public void add(int item){
            // Take care of capacity
            ensureCapacity();

            heap[size] = item;
            size++;
            upSift();
        }

        public int remove(){
            if(isEmpty()){
                throw new NoSuchElementException("Heap is empty.");
            }
            int value = heap[0];
            heap[0] = heap[size-1];
            size--;
            pushTopValueDown();
            return value;
        }

        private void pushTopValueDown() {
            int index = 0;

            while(hasLeftChild(index)) {
                int currentValue = heap[index];
                int smallerChildIndex = leftChildIndex(index);

                if(hasRightChild(index)  && (rightChildValue(index) < leftChildValue(index))){
                    smallerChildIndex = rightChildIndex(index);
                }

                if(currentValue < heap[smallerChildIndex]){
                    break;
                } else {
                    swap(index,smallerChildIndex);
                }
                index = smallerChildIndex;

            }
        }

        public int[] getHeap(){
            return this.heap;
        }

        private int rightChildValue(int index) {
            return heap[rightChildIndex(index)];
        }

        private int leftChildValue(int index) {
            return heap[leftChildIndex(index)];
        }

        private boolean hasLeftChild(int index) {
            return leftChildIndex(index) <size;
        }

        private boolean hasRightChild(int index) {
            return rightChildIndex(index) <size;
        }

        private int leftChildIndex(int index){
            return index*2+1;
        }

        private int rightChildIndex(int index){
            return index*2+2;
        }

        private boolean isEmpty(){
            return size==0;
        }
        private void ensureCapacity() {
            if(size == capacity){
                capacity = 2*capacity;
                heap = Arrays.copyOf(heap,capacity);
            }
        }

        private void upSift() {
            int index = size-1;
            while(hasParent(index) && heap[index] < valueOfParent(index)){
                swap(index,getParentIndex(index));
                index = getParentIndex(index);
            }
        }

        private void swap(int indexOne, int indexTwo) {
            int temp =  heap[indexTwo];
            heap[indexTwo] = heap[indexOne];
            heap[indexOne] = temp;
        }

        private int valueOfParent(int index) {
            return heap[getParentIndex(index)];
        }

        private boolean hasParent(int index) {
            return getParentIndex(index)>=0 && index!=0;
        }

        private int getParentIndex(int index){
            return (index-1)/2;
        }
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(10);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(-1);
        minHeap.add(-10);
        minHeap.remove();

        int[] heap;
        heap= minHeap.getHeap();
        System.out.println("--A------");
        for (int index = 0; index < heap.length; index++) {
            System.out.println(heap[index]);
        }
        System.out.println("--B------");
        minHeap.remove();
        heap= minHeap.getHeap();
        for (int index = 0; index < heap.length; index++) {
            System.out.println(heap[index]);
        }

        System.out.println("---C-----");

        minHeap.remove();
        heap= minHeap.getHeap();
        for (int index = 0; index < heap.length; index++) {
            System.out.println(heap[index]);
        }
        System.out.println("---D-----");
        minHeap.add(-11);
        minHeap.add(-12);
        minHeap.add(-13);
        minHeap.add(-14);
        minHeap.add(3);
        minHeap.add(4);
        heap= minHeap.getHeap();
        for (int index = 0; index < heap.length; index++) {
            System.out.println(heap[index]);
        }

        System.out.println("---E-----");
        minHeap.remove();
        heap= minHeap.getHeap();
        for (int index = 0; index < heap.length; index++) {
            System.out.println(heap[index]);
        }
    }
}
