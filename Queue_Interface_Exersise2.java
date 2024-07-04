import java.util.Deque;
import java.util.ArrayDeque;

class Tester {
    
    public static Deque<Integer> changeSmallest(Deque<Integer> inputStack) {
        Deque<Integer> tempStack = new ArrayDeque<>();
        int smallest = Integer.MAX_VALUE;
        int smallestCount = 0;
        
        // Find the smallest element and count its occurrences
        while (!inputStack.isEmpty()) {
            int current = inputStack.pop();
            if (current < smallest) {
                smallest = current;
                smallestCount = 1;
            } else if (current == smallest) {
                smallestCount++;
            }
            tempStack.push(current);
        }
        
        // Move all non-smallest elements back to inputStack in the original order
        while (!tempStack.isEmpty()) {
            int current = tempStack.pop();
            if (current != smallest) {
                inputStack.push(current);
            }
        }
        
        // Push all occurrences of smallest element to the bottom of inputStack
        while (smallestCount > 0) {
            inputStack.push(smallest);
            smallestCount--;
        }
        
        return inputStack;
    }

    public static void main(String[] args) {
        Deque<Integer> inputStack = new ArrayDeque<>();
        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);
        
        Deque<Integer> updatedStack = changeSmallest(inputStack);
        
        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
}