import java.util.PriorityQueue;
import java.util.Collections;

public class HeapEasy {

    public static void main(String[] args) {

       
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);

        System.out.println("Min Heap: " + minHeap);

        System.out.println("Remove from Min Heap: " + minHeap.poll());
        System.out.println("After removal: " + minHeap);


       
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);

        System.out.println("\nMax Heap: " + maxHeap);

        System.out.println("Remove from Max Heap: " + maxHeap.poll());
        System.out.println("After removal: " + maxHeap);
    }
}