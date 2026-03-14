import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class StackQueueEasy {

    public static void main(String[] args) {

        // =====================
        // STACK (LIFO)
        // =====================
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after push: " + stack);

        stack.pop();  // removes 30
        System.out.println("Stack after pop: " + stack);


        // =====================
        // QUEUE (FIFO)
        // =====================
        Queue<Integer> queue = new LinkedList<>();

        queue.add(100);
        queue.add(200);
        queue.add(300);

        System.out.println("\nQueue after add: " + queue);

        queue.poll();  // removes 100
        System.out.println("Queue after poll: " + queue);
    }
}