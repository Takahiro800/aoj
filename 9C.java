import java.util.Arrays;
import java.util.ArrayList;

class HeapLibrary {

    public static void buildMaxHeap(ArrayList<Integer> arr) {
        int middle = HeapLibrary.parent(arr.size() - 1);
        for (int i = middle; i >= 0; i--) {
            HeapLibrary.maxHeapify(arr, arr.size() - 1, i);
        }
    }

    public static void maxHeapify(ArrayList<Integer> arr, int heapEnd, int i) {

        int l = HeapLibrary.left(i);
        int r = HeapLibrary.right(i);

        int biggest = i;
        if (l <= heapEnd && arr.get(l) > arr.get(biggest))
            biggest = l;
        if (r <= heapEnd && arr.get(r) > arr.get(biggest))
            biggest = r;

        if (biggest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest, temp);
            HeapLibrary.maxHeapify(arr, heapEnd, biggest);
        }
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static int parent(int i) {
        return (int) Math.floor((i - 1) / 2);
    }
}

class PriorityQueue {
    public ArrayList<Integer> maxHeap;

    public PriorityQueue(ArrayList<Integer> arr) {

        this.maxHeap = new ArrayList<Integer>();
        for (Integer i : arr)
            this.maxHeap.add(i);
        HeapLibrary.buildMaxHeap(this.maxHeap);
    }

    public int top() {
        return this.maxHeap.get(0);
    }

    public int pop() {
        Integer temp = this.maxHeap.get(0);
        this.maxHeap.set(0, this.maxHeap.get(this.maxHeap.size() - 1));
        this.maxHeap.remove(this.maxHeap.size() - 1);
        HeapLibrary.maxHeapify(this.maxHeap, this.maxHeap.size() - 1, 0);
        return temp;
    }

    // ここから開発してください。
    // insert
    public void insert(int key) {
        this.maxHeap.add(key);
        int i = this.maxHeap.size() - 1;
        int parent = HeapLibrary.parent(i);
        while (parent > 0 && this.maxHeap.get(parent) < key) {
            int temp = this.maxHeap.get(i);
            this.maxHeap.set(i, this.maxHeap.get(parent));
            this.maxHeap.set(parent, temp);
            i = parent;
            parent = HeapLibrary.parent(i);
        }
    }
}

class Main {
    public static void main(String[] args) {

        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[] { 2, 3, 43, 2, 53, 6, 75, 10 }));
        System.out.println(heap1);
        PriorityQueue pq = new PriorityQueue(heap1);
        System.out.println(pq.maxHeap);
        pq.insert(5);
        System.out.println(pq.maxHeap);
        pq.insert(5);
        System.out.println(pq.maxHeap);
        pq.insert(79);
        System.out.println(pq.maxHeap);
        pq.pop();
        System.out.println(pq.maxHeap);
    }
}