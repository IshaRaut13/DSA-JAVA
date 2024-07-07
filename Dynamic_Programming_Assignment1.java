import java.util.List;

class Tester {
    
    static int count = 0;
    
    public static void findWordSegments(List<String> wordsList, String inputString) {
        int n = inputString.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case: empty string can be segmented

        for (int i = 1; i <= n; i++) {
            for (String word : wordsList) {
                int len = word.length();
                if (i >= len && inputString.substring(i - len, i).equals(word)) {
                    if (dp[i - len]) {
                        dp[i] = true;
                        break; // no need to check further for this i
                    }
                }
            }
        }

        if (dp[n]) {
            count++; // increment count if inputString can be segmented
        }
    }

    public static void main(String[] args){
        List<String> wordsList = List.of("i", "like", "pizza", "li", "ke", "pi", "zza");
        String inputString = "ilikepizza";

        findWordSegments(wordsList, inputString);
        System.out.println("Number of segments: " + count); // prints the number of possible word segments
    }
}