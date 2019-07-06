package com.tm.heap;

public class MaxHeap {
	private int[] heap;
	private int size;
	private int capasity;

	public MaxHeap(int capacity) {
		this.capasity = capacity;
		heap = new int[capacity + 1];
		heap[0] = Integer.MAX_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return 2 * pos;
	}

	private int rightChild(int pos) {
		return 2 * pos + 1;
	}

	private boolean isLeaf(int pos) {
		return pos > size / 2 && pos <= size;
	}

	private void swap(int fpos, int spos) {
		int temp;
		temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}

	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;
		if (heap[leftChild(pos)] > heap[pos]) {
			int l = leftChild(pos);
			if (size >= rightChild(pos)) {
				if (heap[l] < heap[rightChild(pos)]) {
					l = rightChild(pos);
				}
				swap(pos, l);
			}
		} else {
			return;
		}
	}

	private void insert(int element) {
		if(size>= capasity) {
			System.out.print("There is no space to insert");
			return;
		}
		heap[++size] = element;
		int pos = size;
		while (heap[parent(pos)] < heap[pos]) {
			swap(pos, parent(pos));
			pos = parent(pos);
		}
	}

	private int getAndRemoveMax() {
		int maxElement = heap[1];
		heap[1] = heap[size--];
		maxHeapify(1);
		return maxElement;
	}

	public void print() {
		if (size == 1) {
			System.out.print("Parent: " + heap[1]);
			return;
		}
		for (int i = 1; i <= size / 2; i++) {
			System.out.print("Parent: " + heap[i]);
			System.out.print("    Left Child: " + heap[leftChild(i)]);
			if (rightChild(i) <= size) {
				System.out.print("    Right Child: " + heap[rightChild(i)]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(50);
		maxHeap.insert(10);
		maxHeap.insert(4);
		maxHeap.insert(8);
		maxHeap.insert(6);
		maxHeap.insert(70);
		maxHeap.insert(80);
		maxHeap.print();
		maxHeap.getAndRemoveMax();
		maxHeap.print();
		System.out.println();
		for (int i = 1; i <= maxHeap.size; i++)
			System.out.print(" " + maxHeap.heap[i]);
	}

}
