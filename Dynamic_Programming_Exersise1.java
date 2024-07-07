class Tester {

    public static int cutRod(int[] price, int n) {
        // dp array to store maximum revenue for rod lengths 0 to n
        int[] dp = new int[n + 1];
        
        // Initialize dp[0] to 0, since no revenue for rod of length 0
        dp[0] = 0;

        // Compute maximum revenue for each rod length from 1 to n
        for (int i = 1; i <= n; i++) {
            int maxRevenue = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxRevenue = Math.max(maxRevenue, price[j - 1] + dp[i - j]);
            }
            dp[i] = maxRevenue;
        }

        // Maximum revenue for rod of length n is stored in dp[n]
        return dp[n];
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 4;
        System.out.println("Maximum price: " + cutRod(price, n));
    }
}