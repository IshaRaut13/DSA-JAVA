import java.util.Deque;
import java.util.ArrayDeque;

class Tester {
    
    public static Deque<Object> mergeQueue(Deque<Integer> intQueue, Deque<Character> charQueue) {
        Deque<Object> mergedQueue = new ArrayDeque<>();
        
        // Determine the size of each queue
        int sizeIntQueue = intQueue.size();
        int sizeCharQueue = charQueue.size();
        
        // Merge elements at the same position starting with the integer queue
        int minSize = Math.min(sizeIntQueue, sizeCharQueue);
        for (int i = 0; i < minSize; i++) {
            mergedQueue.add(intQueue.poll()); // Add integer element
            mergedQueue.add(charQueue.poll()); // Add character element
        }
        
        // Add remaining elements from integer queue, if any
        while (!intQueue.isEmpty()) {
            mergedQueue.add(intQueue.poll());
        }
        
        // Add remaining elements from character queue, if any
        while (!charQueue.isEmpty()) {
            mergedQueue.add(charQueue.poll());
        }
        
        return mergedQueue;
    }

    public static void main(String[] args) {
        Deque<Integer> integerQueue = new ArrayDeque<>();
        integerQueue.add(3);
        integerQueue.add(6);
        integerQueue.add(9);
        
        Deque<Character> characterQueue = new ArrayDeque<>();
        characterQueue.add('a');
        characterQueue.add('e');
        characterQueue.add('i');
        characterQueue.add('o');
        characterQueue.add('u');
        characterQueue.add('b');
        
        Deque<Object> mergedQueue = mergeQueue(integerQueue, characterQueue);
        
        System.out.println("The elements in the merged queue are:");
        for(Object element: mergedQueue) {
            System.out.print(element + " ");
        }
    }
}
