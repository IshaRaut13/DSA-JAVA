class Stack {
   
    private int top;
    private int maxSize;
    private int[] arr;

    Stack(int maxSize) {
        this.top = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return top >= (maxSize - 1);
    }

    public boolean push(int data) {
        if (isFull()) {
            return false;
        } else {
            arr[++top] = data;
            return true;
        }
    }

    public int peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top];
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is empty!");
        else {
            System.out.println("Displaying stack elements");
            for (int index = top; index >= 0; index--) {
                System.out.println(arr[index]); // accessing element at position index
            }
        }
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top--];
    }

    public int getMaxSize() {
        return maxSize;
    }
}


class Tester {
     
    public static void main(String args[]) {
           
        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);
       
        calculateSum(stack);
           
        System.out.println("Updated stack:");
        stack.display();
    }

    public static void calculateSum(Stack stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        Stack tempStack = new Stack(stack.getMaxSize()); // Temporary stack to hold elements
        int sum = 0;

        // Transfer elements from original stack to tempStack and calculate sum
        while (!stack.isEmpty()) {
            int element = stack.pop();
            sum += element;
            tempStack.push(element); // Push element into tempStack
        }

        // Push the sum to the bottom of the original stack
        stack.push(sum);

        // Transfer elements back from tempStack to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        System.out.println("Sum of elements added to the bottom of the stack: " + sum);
    }
}

