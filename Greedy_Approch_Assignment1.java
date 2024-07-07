class Tester {
    
    public static int findSwapCount(String inputString) {
        int swapCount = 0;
        int balance = 0; // Balance to track '(' - ')'

        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            // If balance is negative, we need to swap to balance the string
            if (balance < 0) {
                swapCount++;
                balance = 0; // Reset balance as we start a new segment
            }
        }

        return swapCount+1;
    }
  
    public static void main(String args[])  { 
        String inputString = "())()("; 
        System.out.println("Number of swaps: " + findSwapCount(inputString)); 
    } 
}