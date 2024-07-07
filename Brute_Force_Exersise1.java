class Tester {

    public static int calculatePower(int num, int p) {
        int result = 1;
        for (int i = 1; i <= p; i++) {
            result *= num;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int num = 2;
        int p = 3;
        System.out.println(num + " raised to the power of " + p + " is: " + calculatePower(num, p));
    }
}