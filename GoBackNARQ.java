import java.util.ArrayList;
import java.util.Collections;

public class PowerOfTwoMaxHeap {
    private ArrayList<Integer> heap;

    public PowerOfTwoMaxHeap() {
        heap = new ArrayList<>();
    }

    // Insert a value into the heap
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Remove and return the max (root) value
    public int popMax() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return max;
    }

    // Heapify up to maintain heap property after insert
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);
            if (heap.get(index) > heap.get(parentIndex)) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Heapify down to maintain heap property after pop
    private void heapifyDown(int index) {
        while (true) {
            int level = getLevel(index);
            int childCount = (int) Math.pow(2, level);
            int maxIndex = index;

            for (int i = 0; i < childCount; i++) {
                int childIndex = getChildIndex(index, i, level);
                if (childIndex < heap.size() && heap.get(childIndex) > heap.get(maxIndex)) {
                    maxIndex = childIndex;
                }
            }

            if (maxIndex == index) break;
            Collections.swap(heap, index, maxIndex);
            index = maxIndex;
        }
    }

    // Get the parent index of the current node
    private int getParentIndex(int index) {
        if (index == 0) return -1;

        int level = getLevel(index) - 1;

        // Traverse backwards to find parent
        for (int i = index - 1; i >= 0; i--) {
            if (getLevel(i) == level) return i;
        }

        return -1;
    }

    // Get level of node at index
    private int getLevel(int index) {
        int count = 0;
        int level = 0;

        while (count <= index) {
            int nodesAtLevel = (int) Math.pow(2, level);
            if (index < count + nodesAtLevel) return level;
            count += nodesAtLevel;
            level++;
        }

        return level;
    }

    // Get the child index for a node
    private int getChildIndex(int parentIndex, int childOffset, int level) {
        int index = parentIndex;
        for (int i = 0; i <= level; i++) {
            index += (int) Math.pow(2, i);
        }
        return index + childOffset;
    }

    // For debugging: print heap as array
    public void printHeap() {
        System.out.println(heap);
    }

    // Main method for simple testing
    public static void main(String[] args) {
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap();

        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(10);
        heap.insert(70);
        heap.insert(60);
        heap.insert(90);

        heap.printHeap();

        System.out.println("Max: " + heap.popMax());
        heap.printHeap();

        System.out.println("Max: " + heap.popMax());
        heap.printHeap();
    }
}
