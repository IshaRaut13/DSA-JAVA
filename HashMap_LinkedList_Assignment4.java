import java.util.LinkedList;
import java.util.List;

class Queue {
    private LinkedList<String> queue;
    private int maxSize;

    public Queue(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    // Method to add an element to the queue (enqueue operation)
    public void enqueue(String element) {
        if (queue.size() < maxSize) {
            queue.add(element);
        } else {
            System.out.println("Queue is full. Cannot enqueue " + element);
        }
    }

    // Method to remove an element from the front of the queue (dequeue operation)
    public void dequeue() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
        }
    }

    // Method to get the current state of the queue
    public List<String> getQueue() {
        return queue;
    }
}

class Tester {

    public static void main(String args[]) {
        Queue queue = new Queue(5);

        queue.enqueue("Emily");
        queue.enqueue("Lily");
        queue.enqueue("Rachel");
        queue.enqueue("Rose");

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.getQueue());
    }
}