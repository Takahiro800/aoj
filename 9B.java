import java.util.Arrays;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 }));
        System.out.println(heap1);
        Heap.buildMaxHeap(heap1);
        System.out.println(heap1);// 42, 30, 11, 9, 10, 7, 6, 5, 2
    }
}

class Heap {
    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static int parent(int i) {
        return (int) Math.floor((i - 1) / 2);
    }

    public static void maxHeapify(ArrayList<Integer> arr, int i) {

        int l = Heap.left(i);
        int r = Heap.right(i);

        int biggest = i;
        if (l < arr.size() && arr.get(l) > arr.get(biggest))
            biggest = l;
        if (r < arr.size() && arr.get(r) > arr.get(biggest))
            biggest = r;

        if (biggest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest, temp);
            Heap.maxHeapify(arr, biggest);
        }
    }

    // ここから実装してください。
    // builMacHeap
    public static void buildMaxHeap(ArrayList<Integer> arr) {
        int middle = Heap.parent(arr.size() - 1);

        for (int i = middle; i >= 0; i--) {
            Heap.maxHeapify(arr, i);
        }
    }

}
