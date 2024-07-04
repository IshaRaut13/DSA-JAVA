import java.util.ArrayDeque;
import java.util.Deque;

class Tester {

    public static Deque<Character> updateStack(Deque<Character> inputStack) {
        // Check if there are at least 3 elements in the stack
        if (inputStack.size() < 3) {
            // If less than 3 elements, return the stack unchanged
            return inputStack;
        }
        
        // Create a temporary stack to hold the bottom 3 elements in reverse order
        Deque<Character> tempStack1 = new ArrayDeque<>();
        Deque<Character> tempStack2 = new ArrayDeque<>();
        for (int i = 0; i < 2; i++) {
            tempStack1.push(inputStack.pop());
        }
        int n = inputStack.size();
        for(int i=0; i<n; i++) {
            tempStack2.push(inputStack.pop());
        }
        
        // Now tempStack has the bottom 3 elements in reverse order
        // Restore them to the original inputStack with the reversed order
        while (!tempStack1.isEmpty()) {
            inputStack.push(tempStack1.pop());
        }
        
        while (!tempStack2.isEmpty()) {
            inputStack.push(tempStack2.pop());
        }

        return inputStack;
    }
    
    public static void main(String[] args) {
        Deque<Character> inputStack = new ArrayDeque<>();
        inputStack.push('E');
        inputStack.push('D');
        inputStack.push('C');
        inputStack.push('B');
        inputStack.push('A');
        
        Deque<Character> resultStack = updateStack(inputStack);
        
        System.out.println("The alphabets in updated stack are:");
        for (Character alphabet : resultStack) {
            System.out.println(alphabet);
        }
    }
}